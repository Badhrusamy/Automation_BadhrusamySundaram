import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Validate_POSTResponse {
    @Test
    public void validateResponse() {
        // Set the base URI for the API
        RestAssured.baseURI = "http://restapi.adequateshop.com/api/Tourist";

        // Define the payload
        String payload = "{\n" +
                "\"tourist_name\": \"Badhrusamy\",\n" +
                "\"tourist_email\": \"Badhrusamysundaram125@idealtechlabs.com\",\n" +
                "\"tourist_location\": \"Paris\"\n" +
                "}";

        // Send a POST request with the payload and capture the response
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/Tourist")
                .then()
                .statusCode(201) // Adjust the expected status code based on your API's behavior
                .extract()
                .response();

        // Validate status code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 201, "Status code is not as expected");


        // Retrieve and print the success response body
        String successResponseBody = response.getBody().asString();
        Reporter.log(successResponseBody);
        System.out.println("Success Response Body: " + successResponseBody);
    }
}
