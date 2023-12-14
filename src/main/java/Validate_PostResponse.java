import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Validate_POSTResponse{


    @Test
    public void validateResponse ()
    {
        try {
            // Specify the URL of the API endpoint
            String apiUrl = "http://restapi.adequateshop.com/api/Tourist";

            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Set the content type and indicate that you will send output
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Create the request payload
            String payload = "{"
                    + "\"tourist_name\": \"Test\","
                    + "\"tourist_email\": \"badhrusamy142350@idealtechlabs.com\","
                    + "\"tourist_location\": \"Paris\""
                    + "}";

            // Get the output stream of the connection
            try (OutputStream os = connection.getOutputStream()) {
                // Write the request payload to the output stream
                byte[] input = payload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Check if the response code is 201 (OK)
            if (responseCode == 201) {
                System.out.println("POST request successful");
                Reporter.log("POST request successful");


            } else {
                // Print an error message if the response code is not 201
                System.out.println("Failed to make POST request. Response Code: " + responseCode);
            }

//            Response response = RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .body(payload)
//                   .post("apiUrl")
//                   .then()
//                   .statusCode(201) // Adjust the expected status code based on your API's behavior
//                   .extract()
//                   .response();
            Response response = given().post("/Tourist");
            int statusCode = response.getStatusCode();
            String responseBody = response.getBody().asString();
            System.out.println("Response Body: " + responseBody);
            assertEquals(statusCode, 201, "Status code is not as expected");


            Reporter.log(responseBody);
            assertEquals(responseBody.contains("tourist_name"), true, "Response body doesn't contain expected value");


            // Close the connection
            connection.disconnect();

            if(responseBody.contains("tourist_name"))
            {
                Reporter.log("Information Updated successfully");

            }
            else {
                Reporter.log("Message\": \"Please try with different email address!\"");

            }
            // Validate status code



        } catch (Exception e) {
            e.printStackTrace();
        }
                }
                }
