/*
 * 
 */
package com.nagarro.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagarro.datastore.FileConstants;
import com.nagarro.model.Flight;

/**
 * The Class FlightDaoImpl.
 */
public class FlightDaoImpl implements FlightDao {

	/** The flight map. */
	private Map<String, List<Flight>> flightMap = new HashMap<>();

	@Override
	public void setFlightMap(List<Flight> flightList, String fileStatus) {
		String key, flightClass;
		for (Flight flight : flightList) {
			flightClass = flight.getFlightClass();
			for (int traverseflightClass = 0; traverseflightClass < flightClass
					.length(); traverseflightClass++) {
				key = flight.getDepLoc() + "," + flight.getArrLoc() + ","
						+ flightClass.charAt(traverseflightClass);
				if (flightMap.containsKey(key)) {
					if (fileStatus.equalsIgnoreCase(FileConstants.OLD_FILE)) {
						if (!compareFlightObject(flightMap.get(key), flight)) {
							flightMap.get(key).add(flight);
						}
					} else {
						flightMap.get(key).add(flight);
					}
				} else {
					List<Flight> list = new ArrayList<>();
					list.add(flight);
					flightMap.put(key, list);
				}
			}
		}
	}

	@Override
	public List<Flight> getFlightList(String key, Date date) {
		List<Flight> availableFlights = new ArrayList<>();
		if (flightMap.containsKey(key)) {
			for (Flight flight : flightMap.get(key)) {
				if ((flight.getValidTill().compareTo(date) >= 0)
						&& flight.getSeatAvailable().equalsIgnoreCase("Y")) {
					availableFlights.add(flight);
				}
			}
		}
		return availableFlights;
	}

	/**
	 * Compare flight object.
	 *
	 * @param flight
	 *            the flight
	 * @param o2
	 *            the o2
	 * @return true, if successful
	 */
	private boolean compareFlightObject(List<Flight> flight, Flight o2) {
		boolean valid = false;
		for (Flight f : flight) {
			if (f.getFlightNo().equals(o2.getFlightNo())
					&& f.getFlightTime().equals(o2.getFlightTime())
					&& f.getFlightClass().equals(o2.getFlightClass())) {
				valid = true;
				break;
			}
		}
		return valid;
	}
}