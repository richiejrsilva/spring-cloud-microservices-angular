package com.harmonyit.shoppinglist.userservice.mapper;

import com.harmonyit.shoppinglist.domain.UserDTO;
import com.harmonyit.shoppinglist.userservice.db.entity.User;

/**
 * The Class UserMapper. This is a simple mapper. mapStructs or another method could be used
 */
public class UserMapper {

	/**
	 * Db entity to domain user.
	 *
	 * @param usertoMap the userto map
	 * @return the com.harmonyit.shoppinglist.domain. userDTO
	 */
	public static com.harmonyit.shoppinglist.domain.UserDTO dbEntityToDomainUser(
			final com.harmonyit.shoppinglist.userservice.db.entity.User usertoMap) {
		
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
	 * @return the com.harmonyit.shoppinglist.userservice.db.entity. user
	 */
	public static com.harmonyit.shoppinglist.userservice.db.entity.User domainToDbEntityUser(
			final com.harmonyit.shoppinglist.domain.UserDTO usertoMap) {

		User mapped = new User();
		mapped.setName(usertoMap.getName());
		mapped.setEmail(usertoMap.getEmail());
		mapped.setPwd(usertoMap.getPwd());
		return mapped;
		
	}

}