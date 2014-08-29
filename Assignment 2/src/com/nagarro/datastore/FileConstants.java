/*
 * 
 */
package com.nagarro.datastore;

/**
 * The Class FileConstants.
 */
public class FileConstants {

	/** The Constant FOLDER_NAME. */
	public final static String FOLDER_NAME = "D:/CSV files";

	/** The Constant DELIMITER. */
	public final static String DELIMITER = "\\|";

	/** The Constant FILE_NOT_FOUND. */
	public final static String FILE_NOT_FOUND = "Error in loading files. Try again after sometime.";

	/** The Constant FOLDER_DOES_NOT_EXISTS. */
	public final static String FOLDER_DOES_NOT_EXISTS = "The folder specified does not exists.";

	/** The Constant RECORD_INCORRECT. */
	public final static String RECORD_INCORRECT = "Incorrect row";

	/** The Constant FILE_HEADER. */
	public final static String FILE_HEADER = "FLIGHT_NO|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FLIGHT_DUR|FARE|SEAT_AVAILABILITY|CLASS";

	/** The Constant NEW_FILE. */
	public final static String NEW_FILE = "new";

	/** The Constant OLD_FILE. */
	public final static String OLD_FILE = "old";

	/** The Constant NUMBER_OF_FILEDS. */
	public final static int NUMBER_OF_FILEDS = 9;

	/** The Constant TIME_INTERVAL. */
	public final static int TIME_INTERVAL = 5000;

	/**
	 * Instantiates a new file constants.
	 */
	private FileConstants() {

	}
}
