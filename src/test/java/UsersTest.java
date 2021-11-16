import model.User;

import org.junit.jupiter.api.Test;

public class UsersTest extends BaseTest {

    @Test
    void shouldReturnUserByUsername() {
        final User user = apiService.getUserByUsername("user1");
        assert user.getUsername().equals("user1");
    }


}
