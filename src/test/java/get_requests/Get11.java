package get_requests;

import baseUrl.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Kannan Ahluwalia", "The Hon. Tara Chaturvedi" and "Damayanti Dubashi" are among the users
        And
            The female users are less than or equals to male users
            (Kadın kullanıcı sayısı erkek kullanıcı sayısından büyük yada eşit olmalı)
     */

    @Test
    public void get11() {
        // Set the URL
        spec.pathParam("first", "users");

        // Set the expected data

        // Send the request and get the response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        // Do assertion
        response
                .then()
                .body("meta.pagination.limit", equalTo(10))
                .body("meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"))
                .body("data", hasSize(10))
                .body("data.status", hasItem("active"))
                .body("data.name", hasItems("Chitrali Embranthiri CPA", "Gautama Namboothiri", "Sunita Panicker Sr."));

        JsonPath json = response.jsonPath();
        List<Object> femaleList = json.getList("data.findAll{it.gender=='female'}");
        List<Object> maleList = json.getList("data.findAll{it.gender=='male'}");

        assertTrue(femaleList.size() >= maleList.size());

        // Email bilgisi ile ID datasını çekme
        List<Integer> idList = json.getList("data.findAll{it.email=='joshi_baladitya@kulas.example'}.id");
        int id = idList.get(0);
        System.out.println(idList);
        System.out.println(id);
    }
}