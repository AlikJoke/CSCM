package ru.project.cscm.base.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Базовый контроллер с обработкой ошибок.
 * 
 * @author Alimurad A. Ramazanov
 * @since 11.11.2017
 *
 */
public abstract class ControllerWithExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	public void handle(final RuntimeException e, final HttpServletResponse response, final HttpServletRequest request) {
		writeStatusAndMessageIntoResponse(response, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}

	@ExceptionHandler(value = HttpClientErrorException.class)
	public void handle(final HttpClientErrorException e, final HttpServletResponse response,
			final HttpServletRequest request) {
		writeStatusAndMessageIntoResponse(response, e.getStatusCode(), e.getMessage());
	}

	private static void writeStatusAndMessageIntoResponse(@NotNull final HttpServletResponse response,
			@NotNull final HttpStatus status, final String message) {
		response.setStatus(status.value());
		response.setContentType("text/plain; charset=UTF-8");
		try {
			final byte[] message_ = message.getBytes("UTF-8");
			response.setContentLength(message_.length);
			response.getOutputStream().write(message_);
			response.getOutputStream().flush();
		} catch (Exception e) {
			throw new IllegalStateException("Unable to write text response", e);
		}
	}
}
