package ch.iMampf.repository;


/**
 * Manages the database operations for the user entity
 */

import org.springframework.data.jpa.repository.JpaRepository;

import ch.iMampf.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
