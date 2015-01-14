package ch.iEat.repository;


/**
 * Manages the database operations for the image entity
 */
import org.springframework.data.jpa.repository.JpaRepository;

import ch.iEat.entity.Dish;
import ch.iEat.entity.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

	List<Image> findByDish(Dish dish);
	
}