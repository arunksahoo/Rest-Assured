package com.automation.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import com.automation.commonfunctionalites.ResourceFile;
import com.automation.commonfunctionalites.ReusableMethods;

public class GetGoogleLocation {
	@Test
	public void getPlaceAPI() {
		// BaseURL or Host
		RestAssured.baseURI = ReusableMethods.readPropertiesFile("baseUrlApi");
		given().param("location", "-33.8670522,151.1957362").param("radius", "1500")
				.param("key", ReusableMethods.readPropertiesFile("Key")).when().get(ResourceFile.GetLocationApi())
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and()
				.header("Server", "scaffolding on HTTPServer2");

	}

}
