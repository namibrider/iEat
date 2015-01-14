package ch.iEat.repository;

/**
 * Manages the database operations for the role entity
 */
import org.springframework.data.jpa.repository.JpaRepository;

import ch.iEat.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
