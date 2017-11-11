package ru.project.cscm.base.security;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ru.project.cscm.base.NotNullOrEmpty;

/**
 * Интерфейс входа в систему.
 * 
 * @author Alimurad A. Ramazanov
 * @since 11.11.2017
 *
 */
public interface Security {

	/**
	 * Авторизация в системе.
	 * <p>
	 * 
	 * @see SecurityContextHolder
	 * @see AuthenticationManager
	 * 
	 * @param username
	 *            - имя пользователя, не может быть {@code null}.
	 * @param password
	 *            - пароль пользователя, не может быть {@code null}.
	 * @throws UsernameNotFoundException
	 */
	void login(@NotNullOrEmpty @NotEmpty String username, @NotNullOrEmpty String password);

	/**
	 * Выход из системы.
	 * <p>
	 * 
	 * @see SecurityContextHolder
	 * @see AuthenticationManager
	 */
	void logout();
}
