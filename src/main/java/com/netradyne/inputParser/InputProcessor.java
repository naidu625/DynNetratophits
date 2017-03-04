package com.netradyne.inputParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author omkar
 * 
 *         Class to read inputs
 *
 */

public class InputProcessor {

	static Logger log = Logger.getLogger(InputProcessor.class.getName());

	/**
	 * 
	 * @param fileName
	 * @return list of account name as list variable
	 */

	public static List<String> processFile(String fileName) {

		log.info("Entering processFile method");

		List<String> accountList = new ArrayList<String>();

		FileInputStream fis = null;
		BufferedReader reader = null;

		try {
			fis = new FileInputStream(fileName);
			reader = new BufferedReader(new InputStreamReader(fis));
			String name = reader.readLine();
			while (name != null) {
				if (!name.isEmpty()) {
					accountList.add(name);
				}
				name = reader.readLine();
			}

		} catch (FileNotFoundException ex) {

			log.log(Level.SEVERE,"file not found " + fileName);
		} catch (IOException ex) {
			log.log(Level.SEVERE,"not able to open file " + fileName);

		} finally {
			try {
				reader.close();
				fis.close();
			} catch (IOException ex) {
				log.log(Level.SEVERE,"not able to open file " + fileName);
			}
		}

		log.info("Exiting processFile method");

		return accountList;

	}

}
