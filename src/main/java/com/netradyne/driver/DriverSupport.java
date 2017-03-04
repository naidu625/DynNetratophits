package com.netradyne.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import com.netradyne.apiCalls.APICall;
import com.netradyne.constants.Variables;
import com.netradyne.contracts.HttpCaller;
import com.netradyne.contracts.JsonParser;
import com.netradyne.contracts.URLFormater;
import com.netradyne.entities.Entity;
import com.netradyne.inputParser.InputProcessor;
import com.netradyne.urlFormatter.URLMaker;
import com.netradyne.util.JsonFormating;

public class DriverSupport {

	static Logger log = Logger.getLogger(DriverSupport.class.getName());

	/**
	 * 
	 * @param filename
	 * 
	 * print value and username and values in descending order
	 * 
	 */

	public static void driverController(String filename) {

		List<Entity> public_repos = new ArrayList<Entity>();

		List<Entity> public_gists = new ArrayList<Entity>();

		URLFormater uRLFormater = new URLMaker();
		HttpCaller httpCaller = new APICall();
		JsonParser jsonParser = new JsonFormating();

		// creates urllist with accestoken

		List<String> urls = uRLFormater.getUrlsWithToken(InputProcessor.processFile(filename), Variables.accessToken);

		for (String url : urls) {

			if (url != null) {
				String json = httpCaller.callApi(url);
				if (json != null) {

					if (jsonParser.parseJson(json, Variables.public_repos) != null) {
						public_repos.add((Entity) jsonParser.parseJson(json, Variables.public_repos));
					}
					if (jsonParser.parseJson(json, Variables.public_gists) != null) {
						public_gists.add((Entity) jsonParser.parseJson(json, Variables.public_gists));
					}
				}
			}

		}

		System.out.println("public_repos");
		
		//sorting in descending order

		Collections.sort(public_repos, new Comparator<Entity>() {

			public int compare(Entity o1, Entity o2) {

				if (Long.compare((Long) o1.getValue(), (Long) o2.getValue()) == 1) {
					return -1;
				} else if (Long.compare((Long) o1.getValue(), (Long) o2.getValue()) == -1) {
					return 1;
				} else {
					return 0;
				}

			}

		});

		printElements(public_repos);

		System.out.println();

		System.out.println("public_gists");

		Collections.sort(public_gists, new Comparator<Entity>() {

			public int compare(Entity o1, Entity o2) {

				if (Long.compare((Long) o1.getValue(), (Long) o2.getValue()) == 1) {
					return -1;
				} else if (Long.compare((Long) o1.getValue(), (Long) o2.getValue()) == -1) {
					return 1;
				} else {
					return 0;
				}

			}

		});

		printElements(public_repos);

	}

	private static void printElements(List<Entity> elements) {

		for (int i = 0; i < elements.size(); i++) {
			if (i == elements.size() - 1) {
				System.out.print(elements.get(i).getColumnName() + "--" + elements.get(i).getValue());
			} else {
				System.out.print(elements.get(i).getColumnName() + "--" + elements.get(i).getValue() + ",");
			}
		}

	}

}
