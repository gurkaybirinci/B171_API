package herokuapp_smoketest;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;

import static herokuapp_smoketest.TC01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TC02_GetBooking extends HerokuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        Kullanıcı GET Request gönderir
    Then
        Status Code: 200
    And
        {
            "firstname" : "Jim",
            "lastname" : "Brown",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Breakfast"
        }'
    */


    @Test
    public void getBooking() {
        spec.pathParams("first", "booking", "second", bookingId);

        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jim", "Brown", 111, true, bookingDates, "Breakfast");

        Response response = given(spec).when().get("{first}/{second}");

        BookingPojo actualData = response.as(BookingPojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDates.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

    }
}
