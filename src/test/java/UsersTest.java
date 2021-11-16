import model.ApiResponse;
import model.Pet;
import model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import service.ApiService;

import java.util.List;
import java.util.Objects;

import static constant.HTTPStatusCodes.*;
import static model.Pet.AVAILABLE_STATUS;

public class UsersTest extends BaseTest {

    @Test
    void shouldReturnUserByUsername() {
        final User user = apiService.getUserByUsername("user1");
        assert user.getUsername().equals("user1");
    }


}
