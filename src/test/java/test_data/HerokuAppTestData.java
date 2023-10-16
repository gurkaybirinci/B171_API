package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {
    public Map<String, String> getBookingDates(String checkin, String checkout){
        Map<String, String> bookingdatesData = new HashMap<>();
        if(checkin!=null){
            bookingdatesData.put("checkin", checkin);
        }
        if(checkout!=null){
            bookingdatesData.put("checkout", checkout);        }
        return bookingdatesData;
    }

    public Map<String, Object> getPayLoad(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdates, String additionalneeds){
        Map<String, Object> expectedData = new HashMap<>();
        if(firstname!=null){
            expectedData.put("firstname", firstname);
        }
        if(lastname!=null){
            expectedData.put("lastname", lastname);
        }
        if(totalprice!=null){
            expectedData.put("totalprice", totalprice);
        }
        if(depositpaid!=null){
            expectedData.put("depositpaid", depositpaid);
        }
        if(bookingdates!=null){
            expectedData.put("bookingdates", bookingdates);
        }
        if(additionalneeds!=null){
            expectedData.put("additionalneeds", additionalneeds);
        }
        return expectedData;
    }
}
