import model.ApiResponse;
import model.User;

import org.junit.jupiter.api.*;
import service.ApiException;

import java.util.ArrayList;
import java.util.List;

import static config.SystemConstants.*;
import static constant.HTTPStatusCodes.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("User tests:")
public class UsersTest extends BaseTest {

    static List<User> users = new ArrayList<>();

    @DisplayName("Find user with default username = 'user1'")
    @org.junit.jupiter.api.Order(1)
    @Test
    void shouldReturnDefaultUserByUsername() throws ApiException {
        User response = apiService.findUserByUsername(DEFAULT_USERNAME);
        assertThat(response).matches(user -> user.getUsername().equals(DEFAULT_USERNAME));
        System.out.println("User with username " + response.getUsername() + " has Id " + response.getId());
    }

    @DisplayName("Update user with default username = 'user1'")
    @org.junit.jupiter.api.Order(2)
    @Test
    void shouldUpdateDefaultUserId() throws ApiException {
        User user = new User();
        user.setUsername(DEFAULT_USERNAME);
        user.setId(123L);
        ApiResponse response = apiService.updateUserByUsername(user);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        assertThat(response.getMessage()).isEqualTo(user.getId().toString());
        System.out.println("User with username " + user.getUsername() + " changed Id to " + response.getMessage());
    }

    @DisplayName("Remove Test User with default username = 'user1'")
    @org.junit.jupiter.api.Order(3)
    @Test
    void shouldRemoveDefaultUserByUsername() throws ApiException {
        ApiResponse response = apiService.removeUserByUsername(DEFAULT_USERNAME);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        assertThat(response.getMessage()).isEqualTo(DEFAULT_USERNAME);
        System.out.println("User with username " + DEFAULT_USERNAME + " removed successfully");
    }

    @DisplayName("Add random test user")
    @org.junit.jupiter.api.Order(4)
    @Test
    void shouldAddTestUser() throws ApiException {
        User user = User.getDefaultUser();
        ApiResponse response = apiService.addUser(user);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        assertThat(response.getMessage()).isEqualTo(user.getId().toString());
        System.out.println("Test User with username " + user.getUsername() + " and Id " + user.getId() + " created successfully");
    }

    @DisplayName("Throws exception, when try to remove random User")
    @org.junit.jupiter.api.Order(5)
    @Test
    void shouldThrowExceptionWhenTryRemoveRandomUser() {
        User user = User.getDefaultUser();
        assertThrows(ApiException.class, () -> apiService.removeUserByUsername(user.getUsername()), "throws when User not found");
        System.out.println("Test User with userName " + user.getUsername() + " was not found");
    }

    @DisplayName("Create several test users with input ArrayList")
    @org.junit.jupiter.api.Order(6)
    @Test
    void shouldAddListOfUsersWithList() throws ApiException {
        for (int i = 0; i < DEFAULT_ARRAY_LENGTH; i++) {
            User user = User.getDefaultUser();
            users.add(user);
            System.out.println("Test User with username " + user.getUsername() + " and Id " + user.getId() + " added to List of Users");
        }
        ApiResponse response = apiService.addListOfUsers(users);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        System.out.println("List of Test Users created successfully");
    }

    @DisplayName("Create several test users with input Array")
    @org.junit.jupiter.api.Order(7)
    @Test
    void shouldAddListOfUsersWithArray() throws ApiException {
        User[] users = new User[DEFAULT_ARRAY_LENGTH];
        for (int i = 0; i < DEFAULT_ARRAY_LENGTH; i++) {
            User user = User.getDefaultUser();
            users[i] = user;
            System.out.println("Test User with username " + user.getUsername() + " and Id " + user.getId() + " added to Array of Users");
        }
        ApiResponse response = apiService.addArrayOfUsers(users);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        System.out.println("Array of Test Users created successfully");
    }

    @DisplayName("User logs into system")
    @org.junit.jupiter.api.Order(8)
    @Test
    void shouldLoginUser() throws ApiException {
        User user = User.getDefaultUser();
        String username = user.getUsername();
        String password = user.getPassword();
        ApiResponse response = apiService.loginUser(username, password);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        System.out.println("Test User with username " + user.getUsername() + " logged in successfully: " + response.getMessage());
    }

    @DisplayName("User logs out")
    @org.junit.jupiter.api.Order(9)
    @Test
    void shouldLogoutUser() throws ApiException {
        User user = User.getDefaultUser();
        ApiResponse response = apiService.logoutUser();
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        assertThat(response.getMessage()).isEqualTo("ok");
        System.out.println("Test User with username " + user.getUsername() + " logged out successfully");
    }
}
