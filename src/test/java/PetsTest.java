import model.ApiResponse;
import model.Pet;
import model.PetStatus;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import service.ApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static constant.HTTPStatusCodes.STATUS_CODE_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Pet tests")
public class PetsTest extends BaseTest {

    static List<Pet> pets = new ArrayList<>();
    static List<Long> ids = new ArrayList<>();

//    @BeforeAll
//    static void addTestPets() throws ApiException {
//        for (PetStatus status : PetStatus.values()) {
//            Pet pet = Pet.getDefaultPet(status);
//            pets.add(pet);
//            ids.add(pet.getId());
//            apiService.addPet(pet);
//        }
//    }

    @DisplayName("Find test pets with different statuses")
    @ParameterizedTest
    @MethodSource("getAllPetStatuses")
    void shouldOnlyReturnPetsByAvailableStatus(PetStatus status) throws ApiException {
        List<Pet> response = apiService.findPetsByStatus(status);
        assertThat(response).hasSizeGreaterThan(0);
        assertThat(response).allMatch(pet -> pet.getStatus().equals(status));
    }

    static Stream<PetStatus> getAllPetStatuses() {
        return Arrays.stream(PetStatus.values());
    }

//   @AfterAll
//     static void deleteTestPets(Long id) {
//       for (Long petId: ids) {
//           ApiResponse response = apiService.removePetById(petId);
//           assertThat(response).matches(apiResponse -> apiResponse.getCode().equals(STATUS_CODE_OK));
//           System.out.println("Deleted Pet with Id = " + response.getMessage());
//       }
//    }
}
