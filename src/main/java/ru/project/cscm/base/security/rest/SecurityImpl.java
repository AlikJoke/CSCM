package ru.project.cscm.base.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ru.project.cscm.base.NotNullOrEmpty;
import ru.project.cscm.base.security.Security;

@Service
public class SecurityImpl implements Security {

	static final String PATH_LOGIN = "/login";
	static final String PATH_LOGOUT = "/logout";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void login(@NotNullOrEmpty final String username, @NotNullOrEmpty final String password) {
		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}

	@Override
	public void logout() {
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
	}

}
