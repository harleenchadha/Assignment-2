/*
 * 
 */
package com.nagarro.util;

import java.util.Comparator;

import com.nagarro.model.Flight;

/**
 * The Class FareSorting.
 */
public class FareSorting implements Comparator<Flight> {

	@Override
	public int compare(Flight o1, Flight o2) {
		int result = 0;
		if (o1.getFare() > o2.getFare()) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}
}