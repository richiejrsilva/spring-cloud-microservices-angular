package com.harmonyit.shoppinglist.authservice.security.db.model;

import java.io.Serializable;
import java.util.HashSet;
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

/**
 * The persistent class for the ROLE database table.
 */
@Entity
@Table(name = "SHL_ROLE")
public class Role implements Serializable {

	/** The serial version UID. */
	private static final long serialVersionUID = 4118685476968214356L;

	/** The ROLE_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
	@SequenceGenerator(allocationSize = 1, name = "ROLE_SEQ", sequenceName = "ROLE_SEQ")
	@Column(name = "ROLE_ID", updatable = false)
	private Integer roleId;

	/** The ROLE_CODE. */
	@Column(name = "ROLE_CODE", columnDefinition = "VARCHAR2(100)", nullable = false, unique = true)
	private String code;

	/** Users belonging to the role. */
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * Sets the users.
	 *
	 * @param users the new users
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
