package tests.apitest;

import model.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import service.ApiException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Pet tests:")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetsTest extends BaseTest {

    @DisplayName("Add Pets with different statuses")
    @org.junit.jupiter.api.Order(1)
    @ParameterizedTest
    @EnumSource(PetStatus.class)
    void addTestPets(PetStatus status) throws ApiException {
        Pet response = apiService.addPet(Pet.getDefaultPet(status));
        assertThat(response).matches(pet -> pet.getStatus().equals(response.getStatus()));
        System.out.println("Pet with Id "+ response.getId().toString() + " was created successfully");
    }

    @DisplayName("Find test pets with different statuses")
    @org.junit.jupiter.api.Order(2)
    @ParameterizedTest
    @MethodSource("getAllPetStatuses")
    void shouldOnlyReturnPetsByAvailableStatus(PetStatus status) throws ApiException {
        List<Pet> response = apiService.findPetsByStatus(status);
        assertThat(response).hasSizeGreaterThan(0);
        assertThat(response).allMatch(pet -> pet.getStatus().equals(status));
        System.out.println("Pet with status " + status + " was found successfully");
    }
    static Stream<PetStatus> getAllPetStatuses() {
        return Arrays.stream(PetStatus.values());
    }
}
