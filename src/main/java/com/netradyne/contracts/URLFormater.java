package com.netradyne.contracts;

import java.util.List;

/**
 * 
 * @author omkar
 *
 */

public interface URLFormater {

	/**
	 * 
	 * @param list
	 *            of accounts
	 * @return all urls
	 */
	public List<String> getUrls(List<String> accounts);

	/**
	 * 
	 * @param accounts
	 * @param token
	 * @return
	 */

	public List<String> getUrlsWithToken(List<String> accounts, String token);

	/**
	 * 
	 * @param account
	 * @param token
	 * @return
	 */

	public String createUrl(String account, String token);

}
