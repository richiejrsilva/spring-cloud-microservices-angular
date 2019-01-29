package com.harmonyit.shoppinglist.userservice.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harmonyit.shoppinglist.userservice.db.entity.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends CrudRepository <User, Integer>{

}
