/*
  Some tests for training.
 */

package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static constants.HTTPStatusCodes.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class SampleTest extends BaseTest {

    final String SERVICE_ENDPOINT_ONE = "/api/login";
    final String SERVICE_ENDPOINT_TWO = "/api/users";

    @BeforeEach
    public void setUp() {
        baseURI = "https://reqres.in";
    }

    @Test
    void getListUsersTest() {
        given()
        .when()
                .get(SERVICE_ENDPOINT_TWO + "?page=2")
        .then()
                .contentType("application/json")
                .statusCode(STATUS_CODE_OK)
                .body("data[0].id", equalTo(7))
                .body("data[0].first_name", equalTo("Michael"))
                .body("data[0].last_name", equalTo("Lawson"));
    }

    @Test
    void getSingleUserTest() {
        given()
        .when()
                .get(SERVICE_ENDPOINT_TWO + "/2")
        .then()
                .contentType("application/json")
                .statusCode(STATUS_CODE_OK)
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"));
    }

    @Test
    void getSingleUserNotFoundTest() {
        given()
        .when()
                .get(SERVICE_ENDPOINT_TWO + "/23")
        .then()
                .statusCode(STATUS_CODE_NOT_FOUND);
    }

    @Test
    public void postCreateUserTest() {
        final String json = "{\"name\": \"morpheus\", \"job\": \"leader\"}";

        given()
                .contentType("application/json")
                .body(json)
        .when()
                .post(SERVICE_ENDPOINT_TWO)
        .then()
                .statusCode(STATUS_CODE_CREATED)
                .contentType("application/json")
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));
    }

    @Test
    public void postCreateFakerUserTest() {
        Faker user = new Faker();
        String name = user.name().firstName();
        String job = user.job().title();
        final String json = "{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}";

//        System.out.println("name: " + name + ", job: " + job);

        given()
                .contentType("application/json")
                .body(json)
        .when()
                .post(SERVICE_ENDPOINT_TWO)
        .then()
                .statusCode(STATUS_CODE_CREATED)
                .contentType("application/json")
                .body("name", equalTo(name))
                .body("job", equalTo(job));
    }

    @Test
    void getDeleteUserTest() {
        given()
        .when()
                .delete(SERVICE_ENDPOINT_TWO + "/2")
        .then()
                .statusCode(STATUS_CODE_NO_CONTENT);
    }

    @Test
    void getLoginSuccessfulTest() {
        final String json = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";
        given()
                .contentType("application/json")
                .body(json)
        .when()
                .post(SERVICE_ENDPOINT_ONE)
        .then()
                .statusCode(STATUS_CODE_OK)
                .contentType("application/json")
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void getLoginUnsuccessfulTest() {
        final String json = "{\"email\": \"peter@klaven\"}";
        given()
                .contentType("application/json")
                .body(json)
        .when()
                .post(SERVICE_ENDPOINT_ONE)
        .then()
                .statusCode(STATUS_CODE_BAD_REQUEST)
                .contentType("application/json")
                .body("error", equalTo("Missing password"));
    }
}
