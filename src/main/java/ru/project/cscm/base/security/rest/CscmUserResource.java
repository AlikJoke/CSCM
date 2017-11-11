package ru.project.cscm.base.security.rest;

import java.util.Calendar;
import java.util.Collection;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import ru.project.cscm.base.NotNullOrEmpty;
import ru.project.cscm.base.security.AppRole;
import ru.project.cscm.model.CscmUser;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class CscmUserResource {

	private final String id;
	private final String password;
	private final Collection<String> roles;
	private final boolean isActive;
	private final Calendar createdTime;
	private final Calendar modifiedTime;

	private static final Function<AppRole, String> appRoleToRole = new Function<AppRole, String>() {

		@Override
		@NotNullOrEmpty
		public String apply(@NotNull final AppRole arg0) {
			return arg0.name();
		}

	};

	private static final Function<String, AppRole> roleToAppRole = new Function<String, AppRole>() {

		@Override
		@NotNull
		public AppRole apply(@NotNullOrEmpty final String arg0) {
			return AppRole.valueOf(arg0.toUpperCase());
		}

	};

	public CscmUserResource(@JsonProperty("id") final String id, @JsonProperty("password") final String password,
			@JsonProperty("roles") final Set<String> roles, @JsonProperty("isActive") final boolean isActive,
			@JsonProperty("createdTime") final Calendar createdTime,
			@JsonProperty("modifiedTime") final Calendar modifiedTime) {
		super();
		this.id = id;
		this.password = password;
		this.roles = roles;
		this.isActive = isActive;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	public CscmUserResource(@NotNull final CscmUser user) {
		this.id = user.getId();
		this.password = null;
		this.roles = Collections2.transform(user.getAppRoles(), appRoleToRole);
		this.isActive = user.isActive();
		this.createdTime = user.getCreatedTime();
		this.modifiedTime = user.getModifiedTime();
	}

	@NotNullOrEmpty
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	@NotNullOrEmpty
	public Collection<String> getRoles() {
		return roles;
	}

	@JsonIgnore
	@NotNullOrEmpty
	public Collection<AppRole> getAppRoles() {
		return Collections2.transform(getRoles(), roleToAppRole);
	}

	public boolean isActive() {
		return isActive;
	}

	@NotNullOrEmpty
	public Calendar getCreatedTime() {
		return createdTime;
	}

	@NotNullOrEmpty
	public Calendar getModifiedTime() {
		return modifiedTime;
	}

}
