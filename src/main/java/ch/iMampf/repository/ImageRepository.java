package ch.iMampf.repository;


/**
 * Manages the database operations for the image entity
 */
import org.springframework.data.jpa.repository.JpaRepository;

import ch.iMampf.entity.Dish;
import ch.iMampf.entity.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

	List<Image> findByDish(Dish dish);
	
}