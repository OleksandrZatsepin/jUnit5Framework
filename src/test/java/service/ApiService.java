package service;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import model.PetStatus;

import java.util.Arrays;
import java.util.List;

import static config.Endpoints.*;
import static constant.HTTPStatusCodes.*;

public class ApiService {

//    public static final String PET_ENDPOINT = "/pet";
//    public static final String PETS_BY_STATUS_ENDPOINT = "/pet/findByStatus";
    private final RequestSpecification specification;

    public ApiService(String applicationUrl) {
        specification = RestAssured.given().baseUri(applicationUrl);
    }

    public List<Pet> findPetsByStatus(String status) {
        final Pet[] statuses = RestAssured.given(specification)
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
        return RestAssured.given(specification)
                .body(pet)
                .post(PET_ENDPOINT)
                .getBody()
                .as(Pet.class);
    }
}
