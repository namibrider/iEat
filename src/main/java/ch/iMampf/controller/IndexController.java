package ch.iMampf.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.iMampf.service.DishService;

@Controller
public class IndexController {
	
	@Autowired
	private DishService dishService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model, Principal principal) {
		return "index";
	}
	
}
