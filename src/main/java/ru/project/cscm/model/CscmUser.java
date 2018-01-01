package ru.project.cscm.model;

import java.util.Calendar;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ru.project.cscm.base.NotNullOrEmpty;
import ru.project.cscm.base.security.AppRole;
import ru.project.cscm.base.security.HasAuthenticationAccess;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "findUserById", query = CscmUser.NamedQueries.FIND_USER_BY_ID) })
public class CscmUser extends BaseIdentifiableObject<String> implements HasAuthenticationAccess<String> {

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_roles", uniqueConstraints = {
			@UniqueConstraint(name = "idx_user_id", columnNames = { "cscm_user_id", "roles" })
	},  joinColumns = { 
			@JoinColumn(name = "cscm_user_id", referencedColumnName = "id")
	})
	@Enumerated(EnumType.STRING)
	private Set<AppRole> roles;

	@Column(length = 64, nullable = false)
	private String password;

	@Column
	private boolean isActive;

	private static final Function<AppRole, GrantedAuthority> roleToGrantedAuthority = new Function<AppRole, GrantedAuthority>() {

		@Override
		@NotNull
		public GrantedAuthority apply(@NotNull AppRole role) {
			return new SimpleGrantedAuthority(role.name());
		}

	};

	protected CscmUser() {
		super();
	}
	
	public CscmUser(@NotNullOrEmpty final String id, @NotNullOrEmpty final String password,
			@NotNullOrEmpty final Set<AppRole> roles, final boolean isActive, @NotNull final Calendar createdTime,
			@NotNull final Calendar modifiedTime) {
		super(id, createdTime, modifiedTime);
		this.password = password;
		this.roles = roles;
		this.isActive = isActive;
	}

	public CscmUser(@NotNullOrEmpty final String id, @NotNullOrEmpty final String password,
			@NotNullOrEmpty final Set<AppRole> roles) {
		super(id);
		this.password = password;
		this.roles = roles;
		this.isActive = true;
	}

	@Override
	@NotNullOrEmpty
	public Collection<GrantedAuthority> getRoles() {
		return Collections2.transform(roles, roleToGrantedAuthority);
	}
	
	@NotNull
	public Collection<AppRole> getAppRoles() {
		return roles;
	}

	@Override
	@NotNullOrEmpty
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(final boolean isActive) {
		this.isActive = isActive;
	}

	public void setPassword(@NotNullOrEmpty final String password) {
		this.password = password;
	}
	
	@PrePersist
	@PreUpdate
	public void preModify() {
		modifiedTime = Calendar.getInstance();
	}
	
	static class NamedQueries {

		public static final String FIND_USER_BY_ID = "SELECT u FROM CscmUser u WHERE u.isActive = true AND u.id = :userId";
	}
}
