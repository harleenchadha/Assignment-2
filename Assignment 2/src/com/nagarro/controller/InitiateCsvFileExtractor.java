/*
 * 
 */
package com.nagarro.controller;

import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.datastore.FileConstants;
import com.nagarro.service.FlightService;

/**
 * The Class InitiateCsvFileExtractor.
 */
public class InitiateCsvFileExtractor {

	/**
	 * Inits the.
	 *
	 * @param flightService
	 *            the flight service
	 */
	public void init(FlightService flightService) {
		TimerTask task = new CsvFileExtractor(flightService);
		Timer timer = new Timer();
		timer.schedule(task, 0, FileConstants.TIME_INTERVAL); // 5 minute
																// interval
	}
}
