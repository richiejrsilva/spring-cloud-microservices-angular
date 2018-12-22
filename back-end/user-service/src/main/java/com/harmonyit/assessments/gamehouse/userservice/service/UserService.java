package com.harmonyit.assessments.gamehouse.userservice.service;

import com.harmonyit.assessments.gamehouse.domain.UserDTO;

/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	UserDTO getUser(final String userId);

	/**
	 * Gets the total users.
	 *
	 * @return the total users
	 */
	Long getTotalUsers();

	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @return the user
	 */
	UserDTO addUser(final UserDTO user);

}
