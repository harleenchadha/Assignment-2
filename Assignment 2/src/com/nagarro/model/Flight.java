/*
 * 
 */
package com.nagarro.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class Flight.
 */
public class Flight {

	/** The flight name. */
	private String flightNo, depLoc, arrLoc, flightTime, seatAvailable,
			flightClass, flightName;

	/** The valid till. */
	private Date validTill;

	/** The fare. */
	private double flightDur, fare;

	/**
	 * Gets the flight name.
	 *
	 * @return the flight name
	 */
	public String getFlightName() {
		return flightName;
	}

	/**
	 * Sets the flight name.
	 *
	 * @param flightName
	 *            the new flight name
	 */
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	/**
	 * Gets the flight no.
	 *
	 * @return the flight no
	 */
	public String getFlightNo() {
		return flightNo;
	}

	/**
	 * Sets the flight no.
	 *
	 * @param flightNo
	 *            the new flight no
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	/**
	 * Gets the dep loc.
	 *
	 * @return the dep loc
	 */
	public String getDepLoc() {
		return depLoc;
	}

	/**
	 * Sets the dep loc.
	 *
	 * @param depLoc
	 *            the new dep loc
	 */
	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	/**
	 * Gets the arr loc.
	 *
	 * @return the arr loc
	 */
	public String getArrLoc() {
		return arrLoc;
	}

	/**
	 * Sets the arr loc.
	 *
	 * @param arrLoc
	 *            the new arr loc
	 */
	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	/**
	 * Gets the valid till.
	 *
	 * @return the valid till
	 */
	public Date getValidTill() {
		return validTill;
	}

	/**
	 * Sets the valid till.
	 *
	 * @param validTill
	 *            the new valid till
	 */
	public void setValidTill(String validTill) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			this.validTill = formatter.parse(validTill);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the flight time.
	 *
	 * @return the flight time
	 */
	public String getFlightTime() {
		return flightTime;
	}

	/**
	 * Sets the flight time.
	 *
	 * @param flightTime
	 *            the new flight time
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	/**
	 * Gets the flight dur.
	 *
	 * @return the flight dur
	 */
	public double getFlightDur() {
		return flightDur;
	}

	/**
	 * Sets the flight dur.
	 *
	 * @param flightDur
	 *            the new flight dur
	 */
	public void setFlightDur(String flightDur) {
		this.flightDur = Double.parseDouble(flightDur);
	}

	/**
	 * Gets the fare.
	 *
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}

	/**
	 * Sets the fare.
	 *
	 * @param fare
	 *            the new fare
	 */
	public void setFare(String fare) {
		this.fare = Double.parseDouble(fare);
	}

	/**
	 * Gets the seat available.
	 *
	 * @return the seat available
	 */
	public String getSeatAvailable() {
		return seatAvailable;
	}

	/**
	 * Sets the seat available.
	 *
	 * @param seatAvailable
	 *            the new seat available
	 */
	public void setSeatAvailable(String seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	/**
	 * Gets the flight class.
	 *
	 * @return the flight class
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * Sets the flight class.
	 *
	 * @param flightClass
	 *            the new flight class
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	/**
	 * Gets the flight object.
	 *
	 * @param flightInfo
	 *            the flight info
	 * @param flightName
	 *            the flight name
	 * @return the flight object
	 */
	public Flight getFlightObject(String flightInfo[], String flightName) {
		Flight flight = new Flight();
		flight.setFlightNo(flightInfo[0]);
		flight.setDepLoc(flightInfo[1]);
		flight.setArrLoc(flightInfo[2]);
		flight.setValidTill(flightInfo[3]);
		flight.setFlightTime(flightInfo[4]);
		flight.setFlightDur(flightInfo[5]);
		flight.setFare(flightInfo[6]);
		flight.setSeatAvailable(flightInfo[7]);
		flight.setFlightClass(flightInfo[8]);
		flight.setFlightName(flightName.substring(0, flightName.length() - 4));
		return flight;
	}
}