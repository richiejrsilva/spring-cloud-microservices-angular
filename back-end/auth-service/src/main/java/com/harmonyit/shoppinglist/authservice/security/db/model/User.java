package com.harmonyit.shoppinglist.authservice.security.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * The persistent class for the SHL_USER database table.
 * 
 * It can be improved as follows:
 * Check the user entity on the following link.
 * https://www.programcreek.com/java-api-examples/?code=sniperqpc/Spring-cloud-gather/Spring-cloud-gather-master/auth-service/src/main/java/com/piggymetrics/auth/config/AuthorizationServerConfiguration.java#
 * 
 * Is interesting to improve the entity user to implements org.springframework.security.core.userdetails.UserDetails; It can be checked on the previous link
 * 
 */
@Entity
@Table(name = "SHL_USER")
public class User implements Serializable {

	/** The serial version UID. */
	private static final long serialVersionUID = 2028453732117468443L;

	/** The USER_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(allocationSize = 1, name = "USER_SEQ", sequenceName = "USER_SEQ")
	@Column(name = "USER_ID", updatable = false)
	private Integer userId;

	/** The USER_EMAIL. */
	@Column(name = "USER_EMAIL", columnDefinition = "VARCHAR2(50)", nullable = false)
	private String userEmail;

	/** The USER_NAME. */
	@Column(name = "USER_NAME", columnDefinition = "VARCHAR2(100)", nullable = false)
	private String userName;

	/** The USER_PWD. */
	@Column(name = "USER_PWD", columnDefinition = "VARCHAR2(20)")
	private String password;

	/** The User Roles. */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "USER_ROLE", joinColumns = {
			@JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	private Set<Role> roles = new HashSet<>();

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user email.
	 *
	 * @return the user email
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * Sets the user email.
	 *
	 * @param userEmail the new user email
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the authorities.
	 * https://docs.spring.io/spring-security/site/docs/4.2.4.RELEASE/apidocs/org/springframework/security/core/GrantedAuthority.html
	 * I'm considering a role as an authority or permission to access a resource
	 * It can be differentiated in permissions per role. Please note this is only a simple example.
	 * This method support the Spring security permissions setup for a given user
	 * Check the caller for this method on CustomUserDetailsServiceImpl.loadUserByUsername(...);
	 *
	 * @return the authorities
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		this.getRoles().forEach(role -> {
			
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
			//for a scenario using permissions per role, you can get the permissions belonging to the user role and add it instead of add the role.
		});
		
		return authorities;
		
	}
	
}
