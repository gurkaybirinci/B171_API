package get_requests;

import baseUrl.ContactListBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get06 extends ContactListBaseUrl {
    /*
        Given
            https://thinking-tester-contact-list.herokuapp.com/contacts
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
     */

    @Test
    public void get06() {
        // Set the URL
        spec.pathParam("first", "contacts");

        // Set the expected data

        // Send the request and get the response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        // Do assertion
        // ÖDEV
    }
}
