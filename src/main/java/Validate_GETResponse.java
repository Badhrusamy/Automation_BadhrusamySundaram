import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Validate_GETResponse {

    @Test
    public void validateResponse() {
        // Set the base URI
        RestAssured.baseURI = "https://vpic.nhtsa.dot.gov/api/vehicles";

        // Send a GET request to the "getallmakes" endpoint and store the response
        Response response = given().get("/getallmakes?format=json");

        // Validate status code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "Status code is not as expected");

        // Validate a specific element in the response body (customize as needed)
        String responseBody = response.getBody().asString();

        Reporter.log(responseBody);
        assertEquals(responseBody.contains("Make_ID"), true, "Response body doesn't contain expected value");

        System.out.println("Response Body: " + responseBody);

       if(responseBody.contains("11100"))
       {
           Reporter.log("All the information retrieved from the server successfully");
           System.out.println("All the information retrieved from the server successfully");
       }
else {
           Reporter.log("Information not retrieved from the server");
           System.out.println("Information not retrieved from the server");
       }
    }
}
