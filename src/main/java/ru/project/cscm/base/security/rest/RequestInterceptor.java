package ru.project.cscm.base.security.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Перехватчик запросов к приложению для проверки наличия данных об авторизации
 * и схемы запроса.
 * 
 * @see HttpScheme
 * 
 * @author Alimurad A. Ramazanov
 * @since 11.11.2017
 *
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
			throws Exception {
		final String authHeader = request.getHeader("Authorization");
		if (StringUtils.isEmpty(authHeader)) {
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
		}

		if (!HttpScheme.isHttps(request.getScheme())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}

		return super.preHandle(request, response, handler);
	}
}