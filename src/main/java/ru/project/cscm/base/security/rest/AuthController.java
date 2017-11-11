package ru.project.cscm.base.security.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import ru.project.cscm.base.rest.ControllerWithExceptionHandler;
import ru.project.cscm.base.security.Security;

@Controller
public class AuthController extends ControllerWithExceptionHandler {

	@Autowired
	private Security security;

	@GetMapping(value = SecurityImpl.PATH_LOGIN)
	@ResponseStatus(HttpStatus.OK)
	public void login(final HttpServletRequest request) throws UnsupportedEncodingException {
		final String authHeader = request.getHeader("Authorization");
		final String[] parts = authHeader.split(" ");
		if (parts.length != 2) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}

		final String args = new String(Base64.decode(parts[1]), "UTF-8");
		final String[] authParams = args.split(":");

		security.login(authParams[0], authParams[1]);
	}

	@GetMapping(value = SecurityImpl.PATH_LOGOUT)
	@ResponseStatus(HttpStatus.OK)
	public void logout() {
		security.logout();
	}

	@RequestMapping(value = { SecurityImpl.PATH_LOGIN, SecurityImpl.PATH_LOGOUT }, method = RequestMethod.OPTIONS)
	@ResponseStatus(HttpStatus.OK)
	public void doOptions(final HttpServletRequest request, final HttpServletResponse response) {
		response.setHeader("Allow", "GET, OPTIONS");
		if (request.getHeader("Origin") != null) {
			response.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS");
		}
	}
}
