package com.netradyne;

import com.netradyne.apiCalls.APICall;
import com.netradyne.constants.Variables;
import com.netradyne.contracts.HttpCaller;
import com.netradyne.contracts.JsonParser;
import com.netradyne.contracts.URLFormater;
import com.netradyne.entities.Entity;
import com.netradyne.urlFormatter.URLMaker;
import com.netradyne.util.JsonFormating;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		URLFormater uRLFormater = new URLMaker();
		HttpCaller httpCaller = new APICall();
		JsonParser jsonParser = new JsonFormating();

		Entity<Long> ent = (Entity<Long>) jsonParser.parseJson(
				httpCaller.callApi(uRLFormater.createUrl(Variables.test_account, Variables.accessToken)),
				Variables.public_repos);

		Assert.assertEquals(ent.getValue().toString(), "322");

	}

}
