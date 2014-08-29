/*
 * 
 */
package com.nagarro.main;

import com.nagarro.controller.Controller;
import com.nagarro.controller.InitiateCsvFileExtractor;
import com.nagarro.service.FlightService;
import com.nagarro.service.FlightServiceImpl;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		FlightService flightService = new FlightServiceImpl();
		new InitiateCsvFileExtractor().init(flightService);
		new Controller(flightService).start();
	}
}
