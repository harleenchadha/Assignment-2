/*
 * 
 */
package com.nagarro.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.nagarro.dao.FlightDao;
import com.nagarro.dao.FlightDaoImpl;
import com.nagarro.datastore.InputConstants;
import com.nagarro.model.Flight;
import com.nagarro.util.FareDurationSorting;
import com.nagarro.util.FareSorting;

/**
 * The Class FlightServiceImpl.
 */
public class FlightServiceImpl implements FlightService {

	/** The flight dao. */
	private FlightDao flightDao;

	/**
	 * Instantiates a new flight service impl.
	 */
	public FlightServiceImpl() {
		flightDao = new FlightDaoImpl();
	}

	@Override
	public void setFlightMap(List<Flight> flightList, String fileStatus) {
		flightDao.setFlightMap(flightList, fileStatus);
	}

	@Override
	public List<Flight> searchFlights(List<String> userInput) {
		Date date = convertDate(userInput.get(1));
		return sortFlights(flightDao.getFlightList(userInput.get(0), date),
				userInput.get(2));
	}

	/**
	 * Convert date.
	 *
	 * @param dateString
	 *            the date string
	 * @return the date
	 */
	private Date convertDate(String dateString) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Sort flights.
	 *
	 * @param flight
	 *            the flight
	 * @param preference
	 *            the preference
	 * @return the list
	 */
	private List<Flight> sortFlights(List<Flight> flight, String preference) {
		if (preference.equalsIgnoreCase(InputConstants.OPTION_A)) {
			Collections.sort(flight, new FareSorting());
		} else {
			Collections.sort(flight, new FareDurationSorting());
		}
		return flight;
	}
}