package com.harmonyit.shoppinglist.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmonyit.shoppinglist.domain.UserDTO;
import com.harmonyit.shoppinglist.userservice.db.repository.UserRepository;
import com.harmonyit.shoppinglist.userservice.mapper.UserMapper;
import com.harmonyit.shoppinglist.userservice.service.UserService;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

	/** The application repository. */
	@Autowired
	private UserRepository applicationRepository;
	
	/* (non-Javadoc)
	 * @see com.harmonyit.shoppinglist.userservice.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public UserDTO getUser(String userId) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.harmonyit.shoppinglist.userservice.service.UserService#getTotalUsers()
	 */
	@Override
	public Long getTotalUsers() {
		return applicationRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.harmonyit.shoppinglist.userservice.service.UserService#addUser(com.harmonyit.shoppinglist.domain.UserDTO)
	 */
	@Override
	public UserDTO addUser(final UserDTO user) {
		return UserMapper.dbEntityToDomainUser(applicationRepository.save(UserMapper.domainToDbEntityUser(user)));
	}

}
