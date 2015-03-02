package ch.iMampf.service;

/**
 * Database operation service for imageRepository interface
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.iMampf.entity.Dish;
import ch.iMampf.entity.Image;
import ch.iMampf.repository.DishRepository;
import ch.iMampf.repository.ImageRepository;
import ch.iMampf.repository.UserRepository;

@Service
public class ImageService{
	@Autowired
	private DishRepository dishRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ImageRepository imageRepository;
	

	

	/**
	 * Saves the image in the database
	 * @param image
	 */
	public void save(Image image, int id) {
		Dish dish = dishRepository.findOne(id);
		image.setDish(dish);
		imageRepository.save(image);
		dish.addImage(image);
		dishRepository.save(dish);
	}
	


	public void save(Image image) {
		imageRepository.save(image);
		
	}
	
	public void delete(Image image) {
		imageRepository.delete(image);
		
	}
	
	public Image findOneById(int id) {
		return imageRepository.findOne(id);
		
	}

}
