package ch.iMampf.service;

/**
 * Database operation service for roomMateRepository interface
 */

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import ch.iMampf.entity.Dish;
import ch.iMampf.entity.Image;
import ch.iMampf.entity.User;
import ch.iMampf.repository.DishRepository;
import ch.iMampf.repository.ImageRepository;
import ch.iMampf.repository.UserRepository;

@Service
public class DishService {
	@Autowired
	private DishRepository dishRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ImageRepository imageRepository;


	/**
	 * Saves the ad in the database
	 *
	 * @param name
	 */
	public void save(Dish dish, String name) {
		User user = userRepository.findByName(name);
		dish.setUser(user);
		dishRepository.save(dish);
	}

	@PreAuthorize("#ad.user.name == authentication.name or hasRole('ROLE_ADMIN')")
	public void delete(@P("dish") Dish dish) {
		Dish tempDish = dishRepository.findOne(dish.getId());
		dishRepository.delete(tempDish);
	}

	@Transactional
	public Dish findOne(int id) {
		return dishRepository.findOne(id);
	}

	@Transactional
	public List<Dish> findAll() {
		return dishRepository.findAll();
	}

//	@Transactional
//	public List<Dish> findAdsWithFormCriteria(String city, String zip,
//			int priceMin, int priceMax, int searchTextNbrRoomMatesMin,
//			int searchTextNbrRoomMatesMax, float searchTextNbrRoomsMin,
//			float searchTextNbrRoomsMax, boolean sharedApartment) {
//		List<Dish> dishes = dishRepository.findAdsWithFormCriteria("%" + city + "%",
//				"%" + zip + "%", priceMin, priceMax, searchTextNbrRoomMatesMin,
//				searchTextNbrRoomMatesMax, searchTextNbrRoomsMin,
//				searchTextNbrRoomsMax, sharedApartment);
//		for (Dish dish : dishes) {
//			List<Image> images = imageRepository.findByDish(dish);
//			dish.setImages(images);
//		}
//		return dishes;
//
//	}

	@Transactional
	public void doAddAd(Model model, Dish dish, BindingResult result,
			Principal principal, MultipartFile[] images, WebRequest webRequest) {

		String name = principal.getName();
		save(dish, name);

		try {
			
			// save imagesAsString
			if (!images[0].isEmpty())
				saveImages(dish, images);

		} catch (IOException e) {
            System.out.println("Could not load image");
			e.printStackTrace();
		}

	}


	@Transactional
	private void saveImages(Dish dish, MultipartFile[] images) throws IOException {
		byte[] bytes;
		for (MultipartFile imageMPF : images) {
			Image image = new Image();
			if (!imageMPF.isEmpty()) {
				bytes =  imageMPF.getBytes();
				byte[] encoded = Base64.encodeBase64(bytes);
				String encodedString = new String(encoded);
				image.setImageAsString(encodedString);
				image.setDish(dish);
				imageRepository.save(image);
			}

		}
	}
	

	@Transactional
	public void editDish(int id, Model model, Dish dish, BindingResult result,
			Principal principal, MultipartFile[] images, WebRequest webRequest) {
		

		String name = principal.getName();
		dish.setId(id);
		save(dish, name);

		try {

			// save imagesAsString
			if (!images[0].isEmpty()) {
				saveImages(dish, images);
			}

		} catch (IOException e) {
			System.out.println("Could not save Image");
			e.printStackTrace();
		} 
	}

	public Object findDishesWithFormCriteria(String searchTextCity,
			String searchTextZip, int searchTextMinPrice,
			int searchTextMaxPrice, int searchTextNbrRoomMatesMin,
			int searchTextNbrRoomMatesMax, float searchTextNbrRoomsMin,
			float searchTextNbrRoomsMax, boolean searchSharedApartment) {
		// TODO Auto-generated method stub
		return null;
	}

}
