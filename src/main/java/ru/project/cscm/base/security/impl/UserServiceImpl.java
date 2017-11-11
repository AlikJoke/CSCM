package ru.project.cscm.base.security.impl;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.common.collect.ImmutableList;

import ru.project.cscm.base.NotNullOrEmpty;
import ru.project.cscm.base.UserRepository;
import ru.project.cscm.base.UserService;
import ru.project.cscm.base.security.AppRole;
import ru.project.cscm.model.CscmUser;

@Service
@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@NotNull
	public List<CscmUser> getUsers() {
		return ImmutableList.<CscmUser>copyOf(userRepository.findAll());
	}

	@Override
	public CscmUser getUserByUsername(@NotNullOrEmpty final String username) {
		return userRepository.findOne(username);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void load(@NotNullOrEmpty final String id, @NotNullOrEmpty final String password,
			@NotNull Set<AppRole> roles) {
		if (StringUtils.isEmpty(password) || StringUtils.isEmpty(id)) {
			throw new RuntimeException("Password and login must be provided!");
		}

		final CscmUser curUser = getUserByUsername(id);
		final String encodedPassword = bCryptPasswordEncoder.encode(password);
		final CscmUser user;
		if (curUser == null) {
			user = new CscmUser(id, encodedPassword, roles);
		} else {
			user = curUser;
			user.setPassword(encodedPassword);
			user.getAppRoles().clear();
			user.getAppRoles().addAll(roles);
		}

		userRepository.save(user);
	}

	@Override
	public void deactivate(@NotNullOrEmpty final String id) {
		final CscmUser user = getUserByUsername(id);
		user.setActive(false);
		userRepository.save(user);
	}

}
