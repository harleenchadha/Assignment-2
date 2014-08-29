/*
 * 
 */
package com.nagarro.controller;

import java.io.FileNotFoundException;
import java.util.TimerTask;

import com.nagarro.datastore.FileConstants;
import com.nagarro.exception.FileExceptions;
import com.nagarro.service.FlightService;
import com.nagarro.util.ReadCsvFiles;
import com.nagarro.view.OutputData;

/**
 * The Class CsvFileExtractor.
 */
public class CsvFileExtractor extends TimerTask {

	/** The read csv file. */
	private ReadCsvFiles readCsvFile;

	/**
	 * Instantiates a new csv file extractor.
	 *
	 * @param flightService the flight service
	 */
	public CsvFileExtractor(FlightService flightService) {
		readCsvFile = new ReadCsvFiles(flightService);
	}

	@Override
	public void run() {
		try {
			readCsvFile.extractFolder();
		} catch (FileNotFoundException ex) {
			OutputData.displayExceptions(FileConstants.FILE_NOT_FOUND);
		} catch (FileExceptions ex) {
			new FileExceptions(ex.getMessage());
		}
	}
}
