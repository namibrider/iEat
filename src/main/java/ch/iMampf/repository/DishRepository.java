package ch.iMampf.repository;


/**
 * Manages the database operations for the ad entity
 */
import org.springframework.data.jpa.repository.JpaRepository;

import ch.iMampf.entity.Dish;
import ch.iMampf.entity.User;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {

	List<Dish> findByUser(User user);

//    List<Dish> findByCook(String cook);
	
}
