package com.harmonyit.assessments.gamehouse.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmonyit.assessments.gamehouse.domain.UserDTO;
import com.harmonyit.assessments.gamehouse.userservice.db.repository.UserRepository;
import com.harmonyit.assessments.gamehouse.userservice.mapper.UserMapper;
import com.harmonyit.assessments.gamehouse.userservice.service.UserService;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

	/** The application repository. */
	@Autowired
	private UserRepository applicationRepository;
	
	/* (non-Javadoc)
	 * @see com.harmonyit.assessments.gamehouse.userservice.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public UserDTO getUser(String userId) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.harmonyit.assessments.gamehouse.userservice.service.UserService#getTotalUsers()
	 */
	@Override
	public Long getTotalUsers() {
		return applicationRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.harmonyit.assessments.gamehouse.userservice.service.UserService#addUser(com.harmonyit.assessments.gamehouse.domain.UserDTO)
	 */
	@Override
	public UserDTO addUser(final UserDTO user) {
		return UserMapper.dbEntityToDomainUser(applicationRepository.save(UserMapper.domainToDbEntityUser(user)));
	}

}
