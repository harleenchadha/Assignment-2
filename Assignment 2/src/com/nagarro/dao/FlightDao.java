/*
 * 
 */
package com.nagarro.dao;

import java.util.Date;
import java.util.List;

import com.nagarro.model.Flight;

/**
 * The Interface FlightDao.
 */
public interface FlightDao {

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
	 * Gets the flight list.
	 *
	 * @param key
	 *            the key
	 * @param date
	 *            the date
	 * @return the flight list
	 */
	public List<Flight> getFlightList(String key, Date date);
}
