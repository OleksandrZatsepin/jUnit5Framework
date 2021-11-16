import model.Pet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static model.Pet.*;

public class PetsTest extends BaseTest {

    @Test
    void shouldOnlyReturnPetsByAvailableStatus() {
        final List<Pet> response = apiService.findPetsByStatus(AVAILABLE_STATUS);
        assert response.size() > 0;
        Assertions.assertThat(response.stream().filter(pet -> !Objects.equals(pet.getStatus(), AVAILABLE_STATUS))).hasSize(0);
    }

    @Test
    void shouldBeAbleToAddPet() {
        final Pet defaultPet = Pet.getDefaultPet();
        apiService.addPet(defaultPet);
    }
}
