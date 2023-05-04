/*
 * Name: Bonita Li
 * File: MainController.java
 * Other Files in this Project:
 * 		index.html
 * 		order.html
 * 		confirm.html
 * 		main.css
 * 		Cheese.java
 * 		Units.java
 */

/**
 * This class is the Main Controller for handling mapping for HTML and creating 
 * Models for Cheese objects. 
 * 
 * @author Bonita Li
 */

package ca.sheridancollege.libon.A2_libon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.libon.A2_libon.beans.Cheese;

@Controller
public class MainController {
	
	/**
	 * Sends web page to index.html
	 * 
	 * @return String of index.html
	 */
	@GetMapping("/index.*")
	public String indexPage() {
		
		return "index.html";
	}
	
	/**
	 * Sends web page to order.html
	 * 
	 * @param model Basic model for adding attributes
	 * @return String of order.html
	 */
	@GetMapping("/orderform")
	public String orderPage(Model model){
		
		model.addAttribute("cheese", new Cheese());
		return "order.html";
	}
	
	/**
	 * Sends web page to confirm.html
	 * 
	 * @param model Basic model for adding attributes
	 * @param cheese Cheese model
	 * @param quantity Quantity of cheese from form
	 * @return String of confirm.html
	 */
	@GetMapping("/submit")
	public String form(Model model, @ModelAttribute Cheese cheese, 
			@RequestParam int quantity) {
		
		model.addAttribute("quantity", quantity);
		return "confirm.html";
	}
	

}
