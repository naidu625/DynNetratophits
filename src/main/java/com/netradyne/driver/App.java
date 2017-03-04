package com.netradyne.driver;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * APP driver 
 *
 */
public class App {

	static Logger log = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {

		if (args.length > 1) {
			log.log(Level.SEVERE, "Invalid input,input should be only one argument");
		} else {
			DriverSupport.driverController(args[0]);
		}

	}
}
