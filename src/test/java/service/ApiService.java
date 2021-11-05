package service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.ApiResponse;

import static constants.HTTPStatusCodes.STATUS_CODE_OK;

public class ApiService {

    public static final String SERVICE_ENDPOINT = "/api/random";

    private final RequestSpecification specification;

    public ApiService(String applicationUrl) {
        specification = RestAssured.given().baseUri(applicationUrl);
    }

    public ApiResponse getSomething() {
        final Response response = RestAssured.given(specification).get(SERVICE_ENDPOINT);
        response.then().statusCode(STATUS_CODE_OK);
        return response.as(ApiResponse.class);
    }
}
