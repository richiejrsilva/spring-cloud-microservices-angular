package com.harmonyit.assessments.gamehouse.api.service.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.harmonyit.assessments.gamehouse.domain.UserDTO;

import feign.Headers;

/**
 * The Interface UserServiceProxy.
 */
@FeignClient(name = "user-service")
public interface UserServiceProxy {

	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
	UserDTO getUser(@PathVariable(name = "userId", required = true) final String userId);

	/**
	 * Gets the total users.
	 *
	 * @return the total users
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user/count")
	Long getTotalUsers();

	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @return the user
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/user", consumes = "application/json")
	UserDTO addUser(@RequestBody final UserDTO user);

}
