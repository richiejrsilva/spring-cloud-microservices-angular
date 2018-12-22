package com.harmonyit.assessments.gamehouse.userservice.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harmonyit.assessments.gamehouse.userservice.db.entity.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends CrudRepository <User, Integer>{

}
