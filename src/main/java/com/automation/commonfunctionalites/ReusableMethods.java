package com.automation.commonfunctionalites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {
	static Properties prop = new Properties();
	static InputStream input;

	public static JsonPath rawToJson(Response r) {
		String respon = r.asString();
		JsonPath x = new JsonPath(respon);
		return x;
	}

	// Reading the properties file
	public static String readPropertiesFile(String Value) {
		File file = new File("./src/main/java/com/automation/commonfunctionalites/enviorment.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String Data = prop.getProperty(Value);

		return Data;
	}

	// Get key from json
	public static List getKeysFromJson(String jsoString) throws Exception {
		Object things = new Gson().fromJson(jsoString, Object.class);
		List keys = new ArrayList();
		collectAllTheKeys(keys, things);
		return keys;
	}

	static void collectAllTheKeys(List keys, Object o) {
		@SuppressWarnings("rawtypes")
		Collection values = null;
		if (o instanceof Map) {
			Map map = (Map) o;
			keys.addAll(map.keySet()); // collect keys at current level in hierarchy
			values = map.values();
		} else if (o instanceof Collection) {
			values = (Collection) o;
		} else {
			return;
		}

		for (Object value : values) {
			collectAllTheKeys(keys, value);
		}

	}

	// Creating Random name
	public static void Firstname() throws IOException {
		prop = new Properties();
		input = null;
		input = new FileInputStream(System.getProperty("user.dir") + readPropertiesFile("pathToCredential"));
		prop.load(input);
		String dummy = prop.getProperty("default");
		prop.setProperty("Firstname", dummy);
		String name = prop.getProperty("Firstname") + RandomStringUtils.randomNumeric(4);
		input.close();
		FileOutputStream out = new FileOutputStream(
				System.getProperty("user.dir") + readPropertiesFile("pathToCredential"));
		prop.setProperty("Firstname", name);

		prop.store(out, null);

	}
	// email id for new patients order items
		public static void Lastname() throws IOException {
			prop = new Properties();
			input = null;
			input = new FileInputStream(System.getProperty("user.dir") + readPropertiesFile("pathToCredential"));
			prop.load(input);
			String dummy = prop.getProperty("default2");
			prop.setProperty("Lastname", dummy);
			String name = prop.getProperty("Lastname") + RandomStringUtils.randomNumeric(4);
			input.close();
			FileOutputStream out = new FileOutputStream(
					System.getProperty("user.dir") + readPropertiesFile("pathToCredential"));
			prop.setProperty("Lastname", name);

			prop.store(out, null);

		}
	// Config data file data
	public static String CredentialValue(String Value) {
		File file = new File("./src/main/java/com/automation/commonfunctionalites/CredentialValue.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String Data = prop.getProperty(Value);

		return Data;
	}

	 public static Integer getRandomNumberInRange(int min, int max) {

		  Random r = new Random();
		  return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

		 }
	 // Creating Random number
	public static void randomNumber() throws IOException {

		prop = new Properties();
		input = null;
		input = new FileInputStream(System.getProperty("user.dir") + readPropertiesFile("pathToCredential"));
		prop.load(input);

		String dummy = prop.getProperty("default1");
		prop.setProperty("Number", dummy);

		String number = getRandomNumberInRange(1,1000000).toString();
		
		input.close();

		FileOutputStream out = new FileOutputStream(
				System.getProperty("user.dir") + readPropertiesFile("pathToCredential"));
		// setting email value in property file for further use
		prop.setProperty("Number", number);

		prop.store(out, null);
		
	}
}