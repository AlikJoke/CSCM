package ru.project.cscm.base.utils;

import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.codec.Base64;

public abstract class Base64Helper {

	public static String encodeToString(@NotNull final String value) {
		return new String(Base64.encode(value.getBytes()));
	}
	
	public static String decodeFromString(@NotNull final String value) {
		return new String(Base64.decode(value.getBytes()));
	}
}
