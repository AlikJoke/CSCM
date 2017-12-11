package ru.project.cscm.base.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import ru.project.cscm.base.NotNullOrEmpty;
import ru.project.cscm.base.security.Security;

@Service
public class SecurityImpl implements Security {

	static final String PATH_LOGIN = "/CSCM/login";
	static final String PATH_LOGOUT = "/CSCM/logout";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private TokenStore tokenStore;

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
		tokenStore.findTokensByClientId(SecurityContextHolder.getContext().getAuthentication().getName())
				.forEach(token -> tokenStore.removeAccessToken(token));
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
	}

}
