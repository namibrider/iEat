package ch.iEat.repository;


/**
 * Manages the database operations for the ad entity
 */
import org.springframework.data.jpa.repository.JpaRepository;

import ch.iEat.entity.Dish;
import ch.iEat.entity.User;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {

	List<Dish> findByCook(User user);
	
}
