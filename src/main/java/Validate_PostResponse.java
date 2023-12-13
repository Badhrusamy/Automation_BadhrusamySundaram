import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Reporter;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Validate_PostResponse{
    public static void main(String[] args) {
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
                    + "\"tourist_name\": \"Maki\","
                    + "\"tourist_email\": \"samybadhru1990@gmail.com.com\","
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

            // Check if the response code is 200 (OK)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("POST request successful");
                Reporter.log("POST request successful");

            } else {
                // Print an error message if the response code is not 200
                System.out.println("Failed to make POST request. Response Code: " + responseCode);
            }

            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                    .post("/Tourist")
                    .then()
                    .statusCode(200) // Adjust the expected status code based on your API's behavior
                    .extract()
                    .response();

            String responseBody = response.getBody().asString();
            System.out.println("Response Body: " + responseBody);
            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
