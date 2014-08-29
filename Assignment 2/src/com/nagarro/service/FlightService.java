/*
 * 
 */
package com.nagarro.service;

import java.util.List;

import com.nagarro.model.Flight;

/**
 * The Interface FlightService.
 */
public interface FlightService {

	/**
	 * Sets the flight map.
	 *
	 * @param flightList
	 *            the flight list
	 * @param fileStatus
	 *            the file status
	 */
	public void setFlightMap(List<Flight> flightList, String fileStatus);

	/**
	 * Search flights.
	 *
	 * @param userInput
	 *            the user input
	 * @return the list
	 */
	public List<Flight> searchFlights(List<String> userInput);
}