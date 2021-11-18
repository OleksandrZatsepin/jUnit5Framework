package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import model.*;

import java.util.Arrays;
import java.util.List;

import static config.Endpoints.*;
import static constant.HTTPStatusCodes.*;
import static io.restassured.RestAssured.given;

public class ApiService {

    private final RequestSpecification spec;

    public ApiService(String applicationUrl) {
        getApiToken();
        spec = given()
                .baseUri(applicationUrl)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    private void getApiToken() {

    }

    public List<Pet> findPetsByStatus(PetStatus petStatus) throws ApiException {
        Response response = given(spec)
                .queryParam("status", petStatus.getStatus())
                .get(PETS_BY_STATUS_ENDPOINT);

        validateResponse(response);
        Pet[] petStatuses = response.getBody().as(Pet[].class);

        return Arrays.asList(petStatuses);
    }

    public List<Pet> findPetsByStatus() throws ApiException {
        return findPetsByStatus(null);
    }

    public Pet addPet(Pet pet) throws ApiException {
        Response response = given(spec)
                .body(pet)
                .contentType(ContentType.JSON)
                .post(PET_ENDPOINT);

        validateResponse(response);

        return response.getBody().as(Pet.class);
    }

    private void validateResponse(Response response) throws ApiException{
        int statusCode = response.statusCode();
        if (statusCode != STATUS_CODE_OK) {
            throw new ApiException(response.statusCode(), response.body().asString());
        }
    }

    public User getUserByUsername(String userName) {
        return given(spec)
                .get(USER_BY_USERNAME_ENDPOINT, userName)
                .getBody()
                .as(User.class);
    }

    public Order getOrderByValidId(Long orderId) {
        return given(spec)
                .get(ORDER_BY_ID_ENDPOINT, orderId)
                .getBody()
                .as(Order.class);
    }

//    public Order addOrder(Order order) {
//        return given(spec)
//                .body(order)
//                .post(ORDER_FOR_PET_ENDPOINT)
//                .getBody()
//                .as(Order.class);
//    }

    public Order addOrder(Order order) throws ApiException {
        Response response = given(spec)
                .body(order)
                .contentType(ContentType.JSON)
                .post(ORDER_FOR_PET_ENDPOINT);

        validateResponse(response);

        return response.getBody().as(Order.class);
    }

    public List<Order> findOrdersByStatus(OrderStatus orderStatus) throws ApiException {
        Response response = given(spec)
                .queryParam("status", orderStatus.getStatus())
                .get(ORDER_FOR_PET_ENDPOINT);

        validateResponse(response);
        Order[] orders = response.getBody().as(Order[].class);

        return Arrays.asList(orders);
    }
}
