/*
 * 
 */
package com.nagarro.view;

import java.util.List;

import com.nagarro.datastore.FlightConstants;
import com.nagarro.model.Flight;

/**
 * The Class OutputData.
 */
public class OutputData {

	/**
	 * Available flights.
	 *
	 * @param list
	 *            the list
	 * @param input
	 *            the input
	 */
	public void availableFlights(List<Flight> list, List<String> input) {
		if (list.size() == 0) {
			System.out.println("No records found");
		} else {
			boolean calculate = false;
			if (input.get(0).substring(input.get(0).length() - 1)
					.equalsIgnoreCase(FlightConstants.CLASS_BUSINESS))
				calculate = true;
			System.out.println("\t\tAVAILABLE FLIGHTS ON " + input.get(1)
					+ " FROM " + list.get(0).getDepLoc() + " TO "
					+ list.get(0).getArrLoc() + "\n");
			System.out
					.println("\tFLIGHT_NAME \tFLIGHT_NO \tFLIGHT_TIME \tFLIGHT_DURATION \tFARE\n");
			for (int traverseList = 0; traverseList < list.size(); traverseList++) {
				System.out.print(String.format("%17s", list.get(traverseList)
						.getFlightName().toUpperCase())
						+ " \t");
				System.out
						.print(list.get(traverseList).getFlightNo() + " \t\t");
				System.out.print(list.get(traverseList).getFlightTime()
						+ " \t\t");
				System.out.print(list.get(traverseList).getFlightDur()
						+ " \t\t\t");
				if (calculate)
					System.out.print(calculateFare(list.get(traverseList)
							.getFare()) + " \n");
				else
					System.out.print(list.get(traverseList).getFare() + " \n");
			}
		}
	}

	/**
	 * Calculate fare.
	 *
	 * @param fare
	 *            the fare
	 * @return the double
	 */
	private Double calculateFare(Double fare) {
		return (fare + (fare * 40 / 100));
	}

	/**
	 * Display exceptions.
	 *
	 * @param display
	 *            the display
	 */
	public static void displayExceptions(String display) {
		System.out.println(display);
	}
}