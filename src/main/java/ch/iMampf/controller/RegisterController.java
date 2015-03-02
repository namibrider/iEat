package ch.iMampf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.iMampf.entity.User;
import ch.iMampf.service.UserService;

/**
 * Maps the request url /register
 *
 * @return
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("org.springframework.security.authenticationManager")
	private AuthenticationManager authenticationManager;

	/**
	 * Instantiates a new User and maps the values from spring form in
	 * user-register.jsp to the new user object (with commandName="user" in
	 * spring form)
	 * 
	 * @return User
	 */
	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}

	/**
	 * Maps the request url /register to the page users-register.jsp
	 *
	 * @return
	 */
	@RequestMapping
	public String showRegister() {
		return "user-register";
	}

	/**
	 * Receives the data from user-register form and adds the data to the user
	 * object and saves the user in the database. If successful, show success
	 * notification on register page
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.save(user);
		return "redirect:/login.html";
	}

	/**
	 * Checks if username is available
	 * 
	 * @param username
	 * @return true
	 */
	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username) {
		Boolean available = userService.findOneByName(username) == null;
		return available.toString();
	}

}
