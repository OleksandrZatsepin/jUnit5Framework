package service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.ApiResponse;

public class ApiService {

    public static final Integer STATUS_CODE_OK = 200;
    public static final Integer STATUS_CODE_CREATED = 201;
    public static final Integer STATUS_CODE_ACCEPTED = 202;
    public static final Integer STATUS_CODE_NO_CONTENT = 204;
    public static final Integer STATUS_CODE_RESET_CONTENT = 205;
    public static final Integer STATUS_CODE_PARTIAL_CONTENT = 206;
    public static final Integer STATUS_CODE_MOVED_PERMANENTLY = 301;
    public static final Integer STATUS_CODE_BAD_REQUEST = 400;
    public static final Integer STATUS_CODE_UNAUTHORIZED = 401;
    public static final Integer STATUS_CODE_FORBIDDEN = 403;
    public static final Integer STATUS_CODE_NOT_FOUND = 404;
    public static final Integer STATUS_CODE_CONFLICT = 409;
    public static final Integer STATUS_CODE_GONE = 410;
    public static final Integer STATUS_CODE_INTERNAL_SERVER_ERROR = 500;

    public static final String SERVICE_ENDPOINT = "/api/users";
    public static final String SERVICE_ENDPOINT_ONE = "/api/login";

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
