package get_requests;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get03 {
    /*
        Given
            https://petstore.swagger.io/v2/pet/9898
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type “application/json” olmalı
        And
            “name” şu metni içermeli: “Pamuk”,
        And
            “status” değeri "available" olmalı
        And
            “category” altındaki "name" değeri "Köpek" olmalı
        And
            “tags” altındaki "name" değeri "Sibirya Kurdu" olmalı
     */

    @Test
    public void get03HardAssertion() {
        // 1. Set the URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/9898";

        // 2. Set the expected data

        // 3. Send the request and get the response
        given()
                .when()
                .get()
                .then() // 4. Do assertion
                .statusCode(200)
                .contentType("application/json")
                .body("name", containsString("Pamuk"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("Köpek"))
                .body("tags[0].name", equalTo("Sibirya Kurdu"));
    }

    @Test
    public void get03SoftAssertion() {
        // 1. Set the URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/9898";

        // 2. Set the expected data

        // 3. Send the request and get the response
        given()
                .when()
                .get()
                .then() // 4. Do assertion
                .statusCode(200)
                .contentType("application/json")
                .body("name", containsString("Pamuk")
                        ,"status", equalTo("available")
                        ,"category.name", equalTo("Köpek")
                        ,"tags[0].name", equalTo("Sibirya Kurdu"));
    }
}
