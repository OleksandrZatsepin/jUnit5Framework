package service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
        spec = given()
                .baseUri(applicationUrl)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    private void validateResponse(Response response) throws ApiException{
        int statusCode = response.statusCode();
        if (statusCode != STATUS_CODE_OK) {
            throw new ApiException(response.statusCode(), response.body().asString());
        }
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

    public Pet findPetsById(Long id) throws ApiException {
        Response response = given(spec)
//                .patch(PET_ENDPOINT, id);
//                .queryParam("petId", id)
                .get(PET_ENDPOINT + "/", id);

        validateResponse(response);

        return response.getBody().as(Pet.class);
    }

    public Pet addPet(Pet pet) throws ApiException {
        Response response = given(spec)
                .body(pet)
                .contentType(ContentType.JSON)
                .post(PET_ENDPOINT);

        validateResponse(response);

        return response.getBody().as(Pet.class);
    }

    public ApiResponse removePetById(Long petId) {
        Response response = given(spec)
                .contentType(ContentType.JSON)
 //               .queryParam("id", petId)
                .delete(PET_ENDPOINT, petId);
        return response.getBody().as(ApiResponse.class);
    }

    public Order findOrderById(Long orderId) throws ApiException {
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(ORDER_BY_ID_ENDPOINT, orderId);
        validateResponse(response);
        return response.getBody().as(Order.class);
    }

    public Order addOrder(Order order) throws ApiException {
        Response response = given(spec)
                .body(order)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post(ORDER_ENDPOINT);
        validateResponse(response);
        return response.getBody().as(Order.class);
    }

    public Order findOrdersByStatus(Order order) throws ApiException {
        Response response = given(spec)
                .body(order)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(ORDER_ENDPOINT);
        validateResponse(response);
        return response.getBody().as(Order.class);
    }

    public ApiResponse removeOrderById(Long orderId) throws ApiException {
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .delete(ORDER_BY_ID_ENDPOINT, orderId);
        validateResponse(response);
        return response.getBody().as(ApiResponse.class);
    }

    public User findUserByUsername(String userName) throws ApiException {
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(USER_BY_USERNAME_ENDPOINT, userName);
        validateResponse(response);
        return response.getBody().as(User.class);
    }

    public ApiResponse addUser(User user) throws ApiException {
        Response response = given(spec)
                .body(user)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post(USER_ENDPOINT);
        validateResponse(response);
        return response.getBody().as(ApiResponse.class);
    }

    public ApiResponse addListOfUsers(List<User> users) throws ApiException {
        Response response = given(spec)
                .body(users)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post(LIST_OF_USERS_ENDPOINT);
        validateResponse(response);
        return response.getBody().as(ApiResponse.class);
    }

    public ApiResponse addArrayOfUsers(User[] users) throws ApiException {
        Response response = given(spec)
                .body(users)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post(ARRAY_OF_USERS_ENDPOINT);
        validateResponse(response);
        return response.getBody().as(ApiResponse.class);
    }

    public ApiResponse updateUserByUsername(User user) throws ApiException {
        Response response = given(spec)
                .body(user)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .put(USER_BY_USERNAME_ENDPOINT, user.getUsername());
        validateResponse(response);
        return response.getBody().as(ApiResponse.class);
    }

    public ApiResponse removeUserByUsername(String username) throws ApiException {
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .delete(USER_BY_USERNAME_ENDPOINT, username);
        validateResponse(response);
        return response.getBody().as(ApiResponse.class);
    }

}
