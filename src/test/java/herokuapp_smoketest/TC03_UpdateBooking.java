package herokuapp_smoketest;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;

import static herokuapp_smoketest.TC01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TC03_UpdateBooking extends HerokuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
            "firstname" : "James",
            "lastname" : "Brown",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Breakfast"
        }
    When
        Kullanıcı PUT Request gönderir
    Then
        Status Code: 200
    And
        {
            "firstname" : "James",
            "lastname" : "Brown",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Breakfast"
        }
     */


    @Test
    public void updateBooking() {
        spec.pathParams("first", "booking", "second", bookingId);

        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo payLoad = new BookingPojo("James", "Brown", 111, true, bookingDates, "Breakfast");

        Response response = given(spec).body(payLoad).when().put("{first}/{second}");

        BookingPojo actualData = response.as(BookingPojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(payLoad.getFirstname(), actualData.getFirstname());
        assertEquals(payLoad.getLastname(), actualData.getLastname());
        assertEquals(payLoad.getTotalprice(), actualData.getTotalprice());
        assertEquals(payLoad.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDates.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(payLoad.getAdditionalneeds(), actualData.getAdditionalneeds());

    }
}




