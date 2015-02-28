package ch.iEat.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import pojo.SearchDishesForm;
import ch.iEat.entity.Dish;
import ch.iEat.entity.Image;
import ch.iEat.entity.User;
import ch.iEat.service.DishService;
import ch.iEat.service.ImageService;
import ch.iEat.service.UserService;

@Controller
public class DishController {
	
	Logger  log = Logger.getLogger(DishController.class);

	@Autowired
	private DishService dishService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageService imageService;

	
	
	/**
	 * Instantiates an ad object which is mapped to the spring form in 
	 * user-account.jsp
	 * 
	 * @return
	 */
	@ModelAttribute("searchDishesForm")
	public SearchDishesForm constructSearchDishesForm() {
		return new SearchDishesForm();
	}
	
	/**
	 * Instantiates an ad object which is mapped to the spring form in
	 * user-account.jsp
	 * 
	 * @return
	 */
	@ModelAttribute("dish")
	public Dish constructDish() {
		return new Dish();
	}

	/**
	 * Maps the request url /ads to the page ads.jsp and provides the model
	 * "ads" with all ads in the repository
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/dishes")
	public String ads(Model model) {
		model.addAttribute("dishes", dishService.findAll());
		return "dishes";
	}
	
	/**
	 * Maps the request url /account to the page account.jsp and provides the
	 * model "user" with the current user
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/placeDish")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithAds(name));
		model.addAttribute("users", userService.findAll());

		return "placeDish";
	}
	
	@RequestMapping("/placeNewDish")
	public String placeNewDish(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithAds(name));
		model.addAttribute("users", userService.findAll());
		return "editDish";
	}
	
	/**
	 * Receives the data from user-account form and adds the data to the ad
	 * object and saves the ad to the current user in the database. Provides
	 * model ad.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/placeNewDish", method = RequestMethod.POST)
	@Transactional
	public String doAddAd(Model model, @ModelAttribute("dish") Dish dish,
			BindingResult result,
			Principal principal,
			@RequestParam("image[]") MultipartFile[] images, org.springframework.web.context.request.WebRequest webRequest) {
		
		model.addAttribute("users",userService.findAll());
		
		dishService.doAddAd(model, dish, result, principal, images,webRequest);

		return "redirect:/placeDish.html"; 
	}

	
	
	/**
	 * Removes the dish with the id={id} and redirects to account.html
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/dish/remove/{id}")
	public String removeAd(@PathVariable int id) {
		Dish dish = dishService.findOne(id);
		dishService.delete(dish);
		return "redirect:/placeDish.html";
	}

	@RequestMapping("/dish/edit/{id}")
	public String editAd(@PathVariable int id, Model model) {
		model.addAttribute("dish", dishService.findOne(id));
		model.addAttribute("users", userService.findAll());
		model.addAttribute("selectedImages", dishService.findOne(id).getImages());
		return "editDish";
	}
	
	
	@RequestMapping("/dish/deleteImage/{id}/{imageId}")
	public String deleteImage(@PathVariable int id,@PathVariable int imageId, Model model) {
		Image image = imageService.findOneById(imageId);
		imageService.delete(image);
		
		return "redirect:/dish/edit/"+id+".html"; 
	}
	
	@RequestMapping("/dish/placeNewDish")
	public String placeNewDish() {
		return "editDish";
	}
	
	

	@RequestMapping(value = "/dish/edit/{id}", method = RequestMethod.POST)
	public String sendEdit(@PathVariable int id, Model model,
			@ModelAttribute("dish") Dish dish, BindingResult result,
			Principal principal, @RequestParam("image[]") MultipartFile[] images
			, org.springframework.web.context.request.WebRequest webRequest) {
		dishService.editDish(id, model, dish, result, principal, images, webRequest);
	
		return "redirect:/placeDish.html";
	}
	/**
	 * Maps the request url /ads to the page ads.jsp and provides the model
	 * "ads" with all ads in the repository
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/searchDishes", method = RequestMethod.POST)
	public String search(Model model, @ModelAttribute("searchDishesForm") SearchDishesForm searchDishesForm, BindingResult result) {	
		model.addAttribute("dishes", dishService.findDishesWithFormCriteria(searchDishesForm.getSearchTextCity(), searchDishesForm.getSearchTextZip(), 
				searchDishesForm.getSearchTextMinPrice(), searchDishesForm.getSearchTextMaxPrice(), 
				searchDishesForm.getSearchTextNbrRoomMatesMin(),searchDishesForm.getSearchTextNbrRoomMatesMax(),
				searchDishesForm.getSearchTextNbrRoomsMin(), searchDishesForm.getSearchTextNbrRoomsMax(),
				searchDishesForm.isSearchSharedApartment()));	


		return "dishes";
	}

    /**
     * Maps the request url /ads{id} (with an ad id) to the page adDetail.jsp
     * and provides the model "ad" with all fields of the ad
     *
     * @param model
     * @return
     */
    @RequestMapping("/random")
    @Transactional
    public String getRandomDish(Model model, WebRequest request) {
        List<Dish> dishes = dishService.findAll();
        Dish randomDish = dishes.get(randInt(0, dishes.size()-1));
        List<Dish> rdishes = new ArrayList<Dish>();
        rdishes.add(randomDish);
        request.removeAttribute("dishes", WebRequest.SCOPE_SESSION);
        model.addAttribute("rdishes", dishService.findOne(randomDish.getId()));
        model.addAttribute("dishes", rdishes);
        System.out.println("RandomDish: "+ randomDish.getId() + randomDish.getDishName());
        System.out.println("Find Dish: "+ dishService.findOne(randomDish.getId()).getDishName());
        return "dishes";
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

	/**
	 * Maps the request url /ads{id} (with an ad id) to the page adDetail.jsp
	 * and provides the model "ad" with all fields of the ad
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/dishes/{id}")
	@Transactional
	public String detail(Model model, @PathVariable("id") int id, Principal principal) {
		model.addAttribute("dish", dishService.findOne(id));

		return "dishDetail";
	}

	
	/**
	 * Maps the date format to the convenient date format for the database
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

}
