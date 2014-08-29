/*
 * 
 */
package com.nagarro.controller;

import java.util.List;

import com.nagarro.service.FlightService;
import com.nagarro.view.InputData;
import com.nagarro.view.OutputData;

/**
 * The Class Controller.
 */
public class Controller {

	/** The input data. */
	private InputData inputData;

	/** The output data. */
	private OutputData outputData;

	/** The flight service. */
	private FlightService flightService;

	/** The input. */
	private List<String> input = null;

	/**
	 * Instantiates a new controller.
	 *
	 * @param flightService
	 *            the flight service
	 */
	public Controller(FlightService flightService) {
		inputData = new InputData();
		outputData = new OutputData();
		this.flightService = flightService;
	}

	/**
	 * Start.
	 */
	public void start() {
		do {
			input = inputData.userInput();
			outputData.availableFlights(flightService.searchFlights(input),
					input);
			if (!inputData.enterChoice()) {
				break;
			}
		} while (true);
		inputData.closeStream();
		System.exit(0);
	}
}
