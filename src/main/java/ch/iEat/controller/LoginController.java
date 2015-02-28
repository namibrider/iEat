package ch.iEat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	/**
	 * Maps the request url /login to the page login.jsp
	 *
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
