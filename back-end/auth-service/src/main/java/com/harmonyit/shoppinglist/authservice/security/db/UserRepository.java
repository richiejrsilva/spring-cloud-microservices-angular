package com.harmonyit.shoppinglist.authservice.security.db;

import java.util.Optional;

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
	 * Find by user name. Get the user as well as his role
	 *
	 * @param username the username
	 * @return the optional
	 */
	@Query("FROM User u JOIN FETCH u.roles WHERE u.userName = ?1")
	Optional<User> findByUserName(String username);
	
}
