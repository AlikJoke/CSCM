package ru.project.cscm.base.security;

public enum Scope {

	READ,

	WRITE,

	TRUST;

	public String getScope() {
		return this.name().toLowerCase();
	}
}
