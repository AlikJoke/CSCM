package ru.project.cscm.base.security;

/**
 * Перечисление ролей пользователей в приложении.
 * 
 * @author Alimurad A. Ramazanov
 * @since 11.11.2017
 *
 */
public enum AppRole {

	/**
	 * Пользователь
	 */
	ROLE_CLIENT,
	
	/**
	 * Доверенный пользователь
	 */
	ROLE_TRUSTED_CLIENT,

	/**
	 * Администратор
	 */
	ROLE_ADMIN,

	/**
	 * Аналитик
	 */
	ROLE_ANALYST;
}
