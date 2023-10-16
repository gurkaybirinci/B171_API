package post_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.jsonplaceholder.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {
    /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
        }
     */

    @Test
    public void post03() {
        // Set the URL
        spec.pathParam("first", "todos");

        // Set the expected data
        JsonPlaceHolderPojo payLoad = new JsonPlaceHolderPojo(55, "Tidy your room", false);

        // Send the request and get the response
        Response response = given(spec).body(payLoad).when().post("{first}"); // Serialization
        response.prettyPrint();

        // Do assertion
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class); // De-serialization
        assertEquals(201, response.statusCode());
        assertEquals(payLoad.getUserId(), actualData.getUserId());
        assertEquals(payLoad.getTitle(), actualData.getTitle());
        assertEquals(payLoad.getCompleted(), actualData.getCompleted());
    }
}