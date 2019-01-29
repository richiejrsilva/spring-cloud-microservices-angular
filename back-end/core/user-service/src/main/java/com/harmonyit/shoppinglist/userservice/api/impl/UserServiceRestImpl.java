package com.harmonyit.shoppinglist.userservice.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harmonyit.shoppinglist.api.service.user.UserServiceProxy;
import com.harmonyit.shoppinglist.domain.UserDTO;
import com.harmonyit.shoppinglist.userservice.service.UserService;

/**
 * The Class UserServiceRestImpl.
 */
@RestController
class UserServiceRestImpl implements UserServiceProxy {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceRestImpl.class);

	/** The user service. */
	@Autowired
	private UserService userService;

	/* (non-Javadoc)
	 * @see com.harmonyit.shoppinglist.api.service.user.UserServiceProxy#getUser(java.lang.String)
	 */
	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
	public UserDTO getUser(@PathVariable(name = "userId", required = true) final String userId) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.harmonyit.shoppinglist.api.service.user.UserServiceProxy#getTotalUsers()
	 */
	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/user/count")
	public Long getTotalUsers() {
		return userService.getTotalUsers();
	}

	/* (non-Javadoc)
	 * @see com.harmonyit.shoppinglist.api.service.user.UserServiceProxy#addUser(com.harmonyit.shoppinglist.domain.User)
	 */
	@Override
	@RequestMapping(method = RequestMethod.POST, value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO addUser(@RequestBody UserDTO user) {
		return userService.addUser(user);
	}

}
