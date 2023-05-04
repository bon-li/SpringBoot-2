/*
 * Name: Bonita Li
 * File: Cheese.java
 * Other Files in this Project:
 * 		index.html
 * 		order.html
 * 		confirm.html
 * 		main.css
 * 		Units.java
 * 		MainController.java
 */

/** 
 * This class stores a cheese object that includes the name of cheese, the
 * weight, weight units, the price of the cheese, and the spec sheet. It does
 * basic validation to ensure that the appropriate fields are valid.
 * 
 * @author Bonita Li
 */

package ca.sheridancollege.libon.A2_libon.beans;

import java.io.Serializable;

import ca.sheridancollege.libon.A2_libon.repositories.Units;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cheese implements Serializable{

	private static final long serialVersionUID = 1L;
		
	//variables for creating Cheese object
	private String name = "TBD";
	private double unitNumber = 1;
	private Units units = Units.WHEEL;
	private double price = 25.00;
	private String specSheet = "";
	
	/**
	 * Validates name to make sure it is not empty.
	 * 
	 * @param name Cheese name
	 * @throws IllegalArgumentExcept if name is empty
	 */
	public void setName(String name) {
			
		//setting name and validating for empty name
		if(name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be blank.");
		} else {
			this.name = name;
		}
	}
		
	/**
	 * Validates num to be greater than 0.
	 * 
	 * @param num Weight of the cheese
	 * @throws IllegalArgumentException if num is less than 0
	 */
	public void setUnitNumber(double num) {
			
		//setting unitNumber and validating if unitNumber is 0 or less
		if (num < 0) {
			throw new IllegalArgumentException("Number should be greater than 0.");
		} else {
			this.unitNumber = num;
		}
	}
		
	/**
	 * Validates price to be greater than 0.
	 * 
	 * @param price Cost of cheese
	 * @throws IllegalArgumentException if price is less than 0
	 */
	public void setPrice(Double price) {
			
		//setting price and validating if less than 0
		if (price < 0 ) {
			throw new IllegalArgumentException("Price must be 0 or greater.");
		} else {
			this.price = price;
		}
	}
		
	/**
	 * Calculates the total cost of cheese.
	 * 
	 * @param qty Number of cheese
	 * @return Total cost of cheese
	 */
	public double calcTotal (double qty) {
			
		//calculates and returns the total cost of cheese order
		if(qty < 1) {
			return 0;
		} else {
			double total = price * qty;
			return total;
		}
	}
	/**
	 * Creates String to represent Cheese object that includes name, unitNumber,
	 * and units.
	 * 
	 * @return Cheese as a String	
	 */
	@Override
	public String toString() {
			
		//showing the name, unitNumber, and unit of Cheese object
		return String.format("%s, %.2f %s", name, unitNumber, units);
	}
}
