package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get10 extends HerokuAppBaseUrl {
   /*
    Given
        https://restful-booker.herokuapp.com/booking/91
    When
        I send GET Request to the url
    Then
        Response body should be like that;
            {
                "firstname": "Jane",
                "lastname": "Doe",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Extra pillows please"
            }
     */

    @Test
    public void get10() {
        // Set the URL
        spec.pathParams("first", "booking", "second", 91);

        // Set the expected data
        Map<String, String> bookingdatesData = new HashMap<>();
        bookingdatesData.put("checkin", "2018-01-01");
        bookingdatesData.put("checkout", "2019-01-01");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Jane");
        expectedData.put("lastname", "Doe");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdatesData);
        expectedData.put("additionalneeds", "Extra pillows please");

        System.out.println(expectedData);

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        assertEquals(bookingdatesData.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesData.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));

        // 2.YOL
        JsonPath json = response.jsonPath();
        assertEquals(bookingdatesData.get("checkin"), json.getString("bookingdates.checkin"));
        assertEquals(bookingdatesData.get("checkout"), json.getString("bookingdates.checkout"));

        Object obj = new HashMap<>();
        ((Map)obj).get("asdasd");

    }

    @Test
    public void get10Metotlu() {
        // Set the URL
        spec.pathParams("first", "booking", "second", 91);

        // Set the expected data
        HerokuAppTestData obj = new HerokuAppTestData();
        Map<String, String> bookingdatesData = obj.getBookingDates("2018-01-01", "2019-01-01");
        Map<String, Object> expectedData = obj.getPayLoad("Jane", "Doe", 111, true, bookingdatesData, "Extra pillows please");

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        assertEquals(bookingdatesData.get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesData.get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));

        // 2.YOL
        JsonPath json = response.jsonPath();
        assertEquals(bookingdatesData.get("checkin"), json.getString("bookingdates.checkin"));
        assertEquals(bookingdatesData.get("checkout"), json.getString("bookingdates.checkout"));
    }
}