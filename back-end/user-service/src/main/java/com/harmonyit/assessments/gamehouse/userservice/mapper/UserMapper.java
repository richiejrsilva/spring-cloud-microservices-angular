package com.harmonyit.assessments.gamehouse.userservice.mapper;

import com.harmonyit.assessments.gamehouse.domain.UserDTO;
import com.harmonyit.assessments.gamehouse.userservice.db.entity.User;

/**
 * The Class UserMapper. This is a simple mapper. mapStructs or another method could be used
 */
public class UserMapper {

	/**
	 * Db entity to domain user.
	 *
	 * @param usertoMap the userto map
	 * @return the com.harmonyit.assessments.gamehouse.domain. userDTO
	 */
	public static com.harmonyit.assessments.gamehouse.domain.UserDTO dbEntityToDomainUser(
			final com.harmonyit.assessments.gamehouse.userservice.db.entity.User usertoMap) {
		
		UserDTO mapped = new UserDTO();
		mapped.setId(usertoMap.getId());
		mapped.setName(usertoMap.getName());
		mapped.setEmail(usertoMap.getEmail());
		mapped.setPwd(usertoMap.getPwd());
		return mapped;

	}

	/**
	 * Domain to db entity user.
	 *
	 * @param usertoMap the userto map
	 * @return the com.harmonyit.assessments.gamehouse.userservice.db.entity. user
	 */
	public static com.harmonyit.assessments.gamehouse.userservice.db.entity.User domainToDbEntityUser(
			final com.harmonyit.assessments.gamehouse.domain.UserDTO usertoMap) {

		User mapped = new User();
		mapped.setName(usertoMap.getName());
		mapped.setEmail(usertoMap.getEmail());
		mapped.setPwd(usertoMap.getPwd());
		return mapped;
		
	}

}