import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.core.IsEqual;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
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

        if (responseBody.contains("11100")) {
            Reporter.log("All the information retrieved from the server successfully");
            System.out.println("All the information retrieved from the server successfully");
        } else {
            Reporter.log("Information not retrieved from the server");
            System.out.println("Information not retrieved from the server");
        }


// Extract specific data points and verify their values
        String makeName = response.path("Results[0].Make_Name");
        response.then().assertThat().body("Results[0].Make_ID", notNullValue());
        response.then().assertThat().body("Results[0].Make_Name", IsEqual.equalTo("1/OFF KUSTOMS, LLC"));
        Reporter.log(makeName);

        String makeName1 = response.path("Results[1].Make_Name");
        response.then().assertThat().body("Results[1].Make_ID", notNullValue());
        response.then().assertThat().body("Results[1].Make_Name", IsEqual.equalTo("102 IRONWORKS, INC."));
        Reporter.log(makeName1);

        String makeName2 = response.path("Results[2].Make_Name");
        response.then().assertThat().body("Results[2].Make_ID", notNullValue());
        response.then().assertThat().body("Results[2].Make_Name", IsEqual.equalTo("12832429 CANADA INC."));
        Reporter.log(makeName2);


    }
}
