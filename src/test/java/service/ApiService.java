package service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.Order;
import model.Pet;
import model.User;

import java.util.Arrays;
import java.util.List;

import static config.Endpoints.*;
import static constant.HTTPStatusCodes.*;

public class ApiService {

    private final RequestSpecification spec;

    public ApiService(String applicationUrl) {
        spec = RestAssured.given()
                .baseUri(applicationUrl)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    public List<Pet> findPetsByStatus(String status) {
        final Pet[] statuses = RestAssured.given(spec)
                .queryParam("status", status)
                .get(PETS_BY_STATUS_ENDPOINT)
                .getBody()
                .as(Pet[].class);
       return Arrays.asList(statuses);
    }

    public List<Pet> findPetsByStatus() {
        return findPetsByStatus(null);
    }

    public Pet addPet(Pet pet) {
        return RestAssured.given(spec)
                .body(pet)
                .post(PET_ENDPOINT)
                .getBody()
                .as(Pet.class);
    }

    public User getUserByUsername(String userName) {
        return RestAssured.given(spec)
                .get(USER_BY_USERNAME_ENDPOINT, userName)
                .getBody()
                .as(User.class);
    }

    public Order getOrderByValidId(Long orderId) {
        return RestAssured.given(spec)
                .get(ORDER_BY_ID_ENDPOINT, orderId)
                .getBody()
                .as(Order.class);
    }

    public Order addOrder(Order order) {
        return RestAssured.given(spec)
                .body(order)
                .post(ORDER_FOR_PET_ENDPOINT)
                .getBody()
                .as(Order.class);
    }
}
