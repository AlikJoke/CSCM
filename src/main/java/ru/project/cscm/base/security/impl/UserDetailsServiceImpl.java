package ru.project.cscm.base.security.impl;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.project.cscm.base.NotNullOrEmpty;
import ru.project.cscm.base.UserService;
import ru.project.cscm.base.security.HasAuthenticationAccess;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	@NotNull
	public UserDetails loadUserByUsername(@NotNullOrEmpty final String username) throws UsernameNotFoundException {
		final HasAuthenticationAccess<String> user = userService.getUserByUsername(username);
		if (user == null || !user.isActive()) {
			throw new UsernameNotFoundException("User not found!");
		}

		return new User(user.getId(), user.getPassword(), user.getRoles());
	}
}
