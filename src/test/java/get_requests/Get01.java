package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
    /*
        Given
            https://petstore.swagger.io/v2/pet/5
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Status Line "HTTP/1.1 200 OK" olmalı
    */

    @Test
    public void get01a() {
        // Birinci Yöntem
        // String url = "https://petstore.swagger.io/v2/pet/5";

        // İkinci Yöntem
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/5";

        Response response = given().when().get();
        response.prettyPrint();

        response
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().statusLine("HTTP/1.1 200 OK");

    }

    @Test
    public void get01b() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/5";

        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");
    }
}
