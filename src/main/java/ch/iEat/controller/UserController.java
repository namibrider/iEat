package ch.iEat.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

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
import org.springframework.web.multipart.MultipartFile;

import ch.iEat.entity.Dish;
import ch.iEat.service.DishService;
import ch.iEat.service.ImageService;
import ch.iEat.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private DishService dishService;

	@Autowired
	private ImageService imageService;
	

	/**
	 * Maps the request url /account to the page account.jsp and provides the
	 * model "user" with the current user
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithAds(name));
		model.addAttribute("users", userService.findAll());

		return "account";
	}

	/**
	 * Receives the data from user-account form and adds the data to the ad
	 * object and saves the ad to the current user in the database. Provides
	 * model ad.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	@Transactional
	public String doAddDish(Model model, @ModelAttribute("dish") Dish dish,
			BindingResult result,
			Principal principal,
			@RequestParam("image[]") MultipartFile[] images
			, org.springframework.web.context.request.WebRequest webRequest) {

	
		return "redirect:/account.html";
	}

	

	/**
	 * Removes the user with id = {id} and logs the user out
	 *
	 * @return
	 */
	@RequestMapping("/account/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/logout";
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
