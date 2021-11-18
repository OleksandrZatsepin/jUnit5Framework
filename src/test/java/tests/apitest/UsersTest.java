package tests.apitest;

import model.User;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

@Nested@DisplayName("Users tests")
public class UsersTest extends BaseTest {

    @Test
    void shouldReturnUserByUsername() {
        final User user = apiService.getUserByUsername("user1");
        assert user.getUsername().equals("user1");
    }


}
