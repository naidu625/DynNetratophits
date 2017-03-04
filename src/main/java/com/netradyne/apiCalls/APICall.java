package com.netradyne.apiCalls;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.netradyne.contracts.HttpCaller;

/**
 * 
 * @author omkar
 *
 */

public class APICall implements HttpCaller {

	Logger log = Logger.getLogger(APICall.class.getName());

	public String callApi(String url) {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		log.log(Level.INFO,"The Url is:" + url);
		String responseString = null;
		try {

			log.info("The request is:" + request.toString());
			HttpResponse response = client.execute(request);
			
			if(response != null) {

				
			log.info("The response code:" + response.getStatusLine().getStatusCode());
			if(response.getStatusLine().getStatusCode() == 200) {
			responseString = new BasicResponseHandler().handleResponse(response);
			}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return responseString;
	}

}
