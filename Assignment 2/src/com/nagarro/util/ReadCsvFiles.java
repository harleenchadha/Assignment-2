/*
 * 
 */
package com.nagarro.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nagarro.datastore.FileConstants;
import com.nagarro.exception.FileExceptions;
import com.nagarro.model.Flight;
import com.nagarro.service.FlightService;

/**
 * The Class ReadCsvFiles.
 */
public class ReadCsvFiles {

	/** The scanned files. */
	private Map<String, Date> scannedFiles = new HashMap<>();

	/** The flight service. */
	private FlightService flightService;

	/**
	 * Instantiates a new read csv files.
	 *
	 * @param flightService
	 *            the flight service
	 */
	public ReadCsvFiles(FlightService flightService) {
		this.flightService = flightService;
	}

	/**
	 * Extract folder.
	 *
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws FileExceptions
	 *             the file exceptions
	 */
	public void extractFolder() throws FileNotFoundException, FileExceptions {
		File file = new File(FileConstants.FOLDER_NAME);
		if (file.exists() && file.isDirectory()) {
			fetchCsvFiles(file);
		} else {
			throw new FileExceptions(FileConstants.FOLDER_DOES_NOT_EXISTS);
		}
	}

	/**
	 * Fetch csv files.
	 *
	 * @param file
	 *            the file
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	private void fetchCsvFiles(File file) throws FileNotFoundException {
		boolean fileModified = false;
		String fileStatus = null;
		List<Flight> flightList = new ArrayList<>();
		for (File fileFetched : file.listFiles()) {
			if (fileFetched.getName().endsWith(".csv")) {
				if (scannedFiles.containsKey(fileFetched.getName())) {
					Date lastModifiedDate = new Date(fileFetched.lastModified());
					if (lastModifiedDate.compareTo(scannedFiles.get(fileFetched
							.getName())) != 0) {
						fileStatus = FileConstants.OLD_FILE;
						flightList = readFiles(flightList, fileFetched);
						fileModified = true;
						scannedFiles.put(fileFetched.getName(), new Date(
								fileFetched.lastModified()));
					}
				} else {
					fileStatus = FileConstants.NEW_FILE;
					flightList = readFiles(flightList, fileFetched);
					fileModified = true;
					scannedFiles.put(fileFetched.getName(), new Date(
							fileFetched.lastModified()));
				}
			}
		}
		if (fileModified) {
			flightService.setFlightMap(flightList, fileStatus);
		}
	}

	/**
	 * Read files.
	 *
	 * @param flightList
	 *            the flight list
	 * @param fileFetched
	 *            the file fetched
	 * @return the list
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	private List<Flight> readFiles(List<Flight> flightList, File fileFetched)
			throws FileNotFoundException {
		String line = "";
		String flightClass;
		String[] flightInfo;
		BufferedReader br = Stream.getBufferedReader(new FileReader(fileFetched
				.getPath()));
		try {
			while ((line = br.readLine()) != null) {
				if (!line.equalsIgnoreCase(FileConstants.FILE_HEADER)) {
					flightInfo = line.split(FileConstants.DELIMITER);
					try {
						validateFileEntries(flightInfo);
						flightClass = flightInfo[8];
						for (int i = 0; i < flightClass.length(); i++) {
							flightInfo[8] = flightClass.charAt(i) + "";
							Flight flight = new Flight().getFlightObject(
									flightInfo, fileFetched.getName());
							flightList.add(flight);
						}
					} catch (FileExceptions ex) {
						new FileExceptions(ex.getMessage());
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flightList;
	}

	/**
	 * Validate file entries.
	 *
	 * @param flightInfo
	 *            the flight info
	 * @throws FileExceptions
	 *             the file exceptions
	 */
	private void validateFileEntries(String flightInfo[]) throws FileExceptions {
		if (flightInfo.length == FileConstants.NUMBER_OF_FILEDS) {
			for (int traverse = 0; traverse < flightInfo.length; traverse++) {
				if (flightInfo[traverse] == null) {
					throw new FileExceptions(FileConstants.RECORD_INCORRECT);
				}
			}
		} else {
			throw new FileExceptions(FileConstants.RECORD_INCORRECT);
		}
	}
}