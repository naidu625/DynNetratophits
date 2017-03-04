package com.netradyne.urlFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.netradyne.constants.Variables;
import com.netradyne.contracts.URLFormater;

/**
 * 
 * @author Omkar
 *
 */

public class URLMaker implements URLFormater {

	Logger log = Logger.getLogger(URLMaker.class.getName());

	/**
	 * 
	 * @param list
	 *            of accounts
	 * @return all urls
	 */
	public List<String> getUrls(List<String> accounts) {

		log.info("Entering into getUrls method");

		List<String> urlList = new ArrayList<String>();

		if (!accounts.isEmpty()) {

			for (String account : accounts) {

				String url = createUrl(account, null);

				if (url != null) {
					urlList.add(url);
				}
			}

		}

		log.info("Exiting into getUrls method");

		return urlList;
	}

	/**
	 * 
	 * @param account
	 * @return url
	 */

	public String createUrl(String account, String token) {

		log.info("Entering into createUrl method");

		if (token == null) {
			if (account.contains(" ") || account.isEmpty()) {
				return null;
			} else {
				return "https://" + Variables.gitUrl + account;
			}
		} else {

			if (account.contains(" ") || account.isEmpty()) {
				return null;
			} else {
				return "https://" + token + ":x-oauth-basic@" + Variables.gitUrl + account;
			}

		}

	}

	public List<String> getUrlsWithToken(List<String> accounts, String token) {

		log.info("Entering into getUrlsWithToken method");

		List<String> urlList = new ArrayList<String>();

		if (!accounts.isEmpty()) {

			for (String account : accounts) {

				String url = createUrl(account, token);

				if (url != null) {
					urlList.add(url);
				}
			}

		}

		log.info("Exiting into getUrlsWithToken method");

		return urlList;
	}

}
