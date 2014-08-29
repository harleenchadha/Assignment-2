/*
 * 
 */
package com.nagarro.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * The Class Stream.
 */
public class Stream {

	/**
	 * Gets the buffered reader.
	 *
	 * @param fileReader
	 *            the file reader
	 * @return the buffered reader
	 */
	public static BufferedReader getBufferedReader(FileReader fileReader) {
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		return bufferedReader;
	}

	/**
	 * Gets the buffered reader.
	 *
	 * @param ins
	 *            the ins
	 * @return the buffered reader
	 */
	public static BufferedReader getBufferedReader(InputStreamReader ins) {
		BufferedReader bufferedReader = new BufferedReader(ins);
		return bufferedReader;
	}
}
