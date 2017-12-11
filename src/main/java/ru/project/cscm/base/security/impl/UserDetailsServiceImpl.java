package ru.project.cscm.base.security.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ru.project.cscm.base.UserService;
import ru.project.cscm.base.configuration.ResourceServerConfiguration;
import ru.project.cscm.base.security.HasAuthenticationAccess;

@Service("detailsService")
public class UserDetailsServiceImpl implements UserDetailsService, ClientDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final HasAuthenticationAccess<String> user = userService.getUserByUsername(username);
		if (user == null || !user.isActive()) {
			throw new UsernameNotFoundException("User not found!");
		}

		return new User(user.getId(), user.getPassword(), user.getRoles());
	}

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		final HasAuthenticationAccess<String> user = userService.getUserByUsername(clientId);
		if (user == null || !user.isActive()) {
			throw new UsernameNotFoundException("Client not found!");
		}

		final BaseClientDetails clientDetails = new BaseClientDetails(user.getId(), null, "read,write,trust", null,
				StringUtils.collectionToCommaDelimitedString(user.getRoles()));
		clientDetails.setClientSecret(user.getPassword());
		clientDetails.setRefreshTokenValiditySeconds(600);
		clientDetails.setAccessTokenValiditySeconds(Integer.MAX_VALUE);
		clientDetails.setAuthorizedGrantTypes(Arrays.asList("refresh_token", "client_credentials"));
		clientDetails.setResourceIds(Arrays.asList(ResourceServerConfiguration.RESOURCE_ID));
		return clientDetails;

	}
}
