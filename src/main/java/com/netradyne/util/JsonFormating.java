package com.netradyne.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.netradyne.constants.Variables;
import com.netradyne.contracts.JsonParser;
import com.netradyne.entities.Entity;

public class JsonFormating implements JsonParser<Entity<Long>> {

	Logger log = Logger.getLogger(JsonParser.class.getName());

	public Entity<Long> parseJson(String json, String column) {

		JSONParser parser = new JSONParser();
		JSONObject jSONObject = null;
		Entity<Long> entity = null;

		try {
			Object obj = parser.parse(json);

			jSONObject = (JSONObject) obj;

		} catch (ParseException pe) {

			log.log(Level.SEVERE, "position: " + pe.getPosition() + " message :" + pe);
		}

		if (jSONObject.get(column) != null || jSONObject.get(Variables.login_name) != null) {

			Long value = (Long) jSONObject.get(column);

			String columnName = (String) jSONObject.get(Variables.login_name);

			entity = new Entity<Long>(columnName, value);

		}

		return entity;
	}

}
