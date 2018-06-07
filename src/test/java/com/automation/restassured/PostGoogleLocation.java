package com.automation.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import com.automation.commonfunctionalites.PayLoad;
import com.automation.commonfunctionalites.ResourceFile;
import com.automation.commonfunctionalites.ReusableMethods;

public class PostGoogleLocation {

	@Test
	public void AddandDeletePlace() {

		// Task 1- Grab the response
		RestAssured.baseURI = ReusableMethods.readPropertiesFile("baseUrlApi");
		Response res = given().queryParam("key", ReusableMethods.readPropertiesFile("Key"))
				.body(PayLoad.createLocationApi()).when().post(ResourceFile.createLocationApi()).then().assertThat()
				.statusCode(200).and().contentType(ContentType.JSON).and().body("status", equalTo("OK")).extract()
				.response();

		// Task 2- Grab the Place ID from response
        String responseString = res.asString();
		System.out.println(responseString);
		JsonPath js = new JsonPath(responseString);
		String placeid = js.get("place_id");
		System.out.println(placeid);

		// Task 3 place this place id in the Delete request
		given().queryParam("key", ReusableMethods.readPropertiesFile("Key"))
				.body("{" + "\"place_id\": \"" + placeid + "\"" + "}").when().post(ResourceFile.deleteLocationApi())
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("status", equalTo("OK"));

	}
}
