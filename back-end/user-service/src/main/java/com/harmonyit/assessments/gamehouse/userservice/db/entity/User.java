package com.harmonyit.assessments.gamehouse.userservice.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "USERS")
public class User {

	/** The identifier. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(allocationSize = 1, name = "USER_SEQ", sequenceName = "USER_SEQ")
	@Column(name = "USER_ID", updatable = false)
	private Integer id;

	/** The Email. */
	@Column(name = "USER_EMAIL")
	private String email;

	/** The Name. */
	@Column(name = "USER_NAME")
	private String name;
	
	/** The Pwd. */
	@Column(name = "USER_PWD")
	private String pwd;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the pwd.
	 *
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Sets the pwd.
	 *
	 * @param pwd the new pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
