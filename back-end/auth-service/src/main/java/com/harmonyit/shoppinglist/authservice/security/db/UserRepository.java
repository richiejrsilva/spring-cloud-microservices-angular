package com.harmonyit.shoppinglist.authservice.security.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.harmonyit.shoppinglist.authservice.security.db.model.User;

/**
 * Repository that manages the database operations over the {@link User} entity.
 * <p>
 * The {@link CrudRepository} provides CRUD functionality for the entity class that is being
 * managed. This includes finding, saving, deleting and other minor operations, like exists or
 * count.
 * <p>
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  /**
   * Finding a user by username and his roles.
   *
   * @param username the username
   * @return the user
   */
	@Query("FROM User u JOIN FETCH u.roles WHERE u.userName = ?1")
	User findByUserName(String username);
	
}
