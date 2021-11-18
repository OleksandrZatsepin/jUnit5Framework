package tests.apitest;

import model.Pet;
import model.PetStatus;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import service.ApiException;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Pets tests")
public class PetsTest extends BaseTest {

    static List<Pet> pets = new ArrayList<>();
    @BeforeAll
    static void addTestPets() throws ApiException {
        for (PetStatus status : PetStatus.values()) {
            Pet pet = Pet.getDefaultPet(status);
            pets.add(pet);
            apiService.addPet(pet);
        }
    }

    @ParameterizedTest
    @MethodSource ("getAllPetStatuses")
    void shouldOnlyReturnPetsByAvailableStatus(PetStatus status) throws ApiException {
        List<Pet> response = apiService.findPetsByStatus(status);
        assertThat(response).hasSizeGreaterThan(0);
        assertThat(response).allMatch(pet -> pet.getStatus().equals(status));
    }

//    @Test
//    void shouldBeAbleToAddPet() {
//        final Pet defaultPet = Pet.getDefaultPet();
//        apiService.addPet(defaultPet);
//        assertThat(pet)
//    }

    static Stream<PetStatus> getAllPetStatuses() {
        return Arrays.stream(PetStatus.values());
    }

//    @AfterAll
//    static void deleteTestPets() {
//        for (Pet pet : pets) {
//            apiService.removePet(pet);
//        }
//    }
}
