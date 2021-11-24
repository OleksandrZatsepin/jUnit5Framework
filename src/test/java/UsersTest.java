import model.ApiResponse;
import model.User;

import org.junit.jupiter.api.*;
import service.ApiException;

import java.util.ArrayList;
import java.util.List;

import static config.Endpoints.*;
import static config.SystemConstants.*;
import static constant.HTTPStatusCodes.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("User tests:")
public class UsersTest extends BaseTest {

    static List<User> users = new ArrayList<>();

    @Nested
    @DisplayName("Endpoint: " + USER_ENDPOINT + ", method: POST")
    class UserTestsForPostMethod {
        @Nested
        @DisplayName("Positive tests")
        class PositiveUserTestsForPostMethod {
            @DisplayName("Add random test user")
            @Test
            void shouldAddTestUser() throws ApiException {
                User user = User.getDefaultUser();
                ApiResponse response = apiService.addUser(user);
                assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
                assertThat(response.getMessage()).isEqualTo(user.getId().toString());
                System.out.println("Test User with username " + user.getUsername() + " and Id " + user.getId() + " created successfully");
            }
        }

        @Nested
        @DisplayName("Negative tests")
        class NegativeUserTestsForPostMethod {
        }
    }

    @Nested
    @DisplayName("Endpoint: " + LIST_OF_USERS_ENDPOINT + ", method: POST")
    class UsersListTestsForPostMethod {
        @Nested
        @DisplayName("Positive tests")
        class PositiveUsersListTestsForPostMethod {
            @DisplayName("Create several test users with input ArrayList")
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
        }

        @Nested
        @DisplayName("Negative tests")
        class NegativeUsersListTestsForPostMethod {
        }
    }

    @Nested
    @DisplayName("Endpoint: " + ARRAY_OF_USERS_ENDPOINT + ", method: POST")
    class UsersArrayTestsForPostMethod {
        @Nested
        @DisplayName("Positive tests")
        class PositiveUsersArrayTestsForPostMethod {
            @DisplayName("Create several test users with input Array")
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
        }

        @Nested
        @DisplayName("Negative tests")
        class NegativeUsersArrayTestsForPostMethod {
        }
    }

    @Nested
    @DisplayName("Endpoint: " + USER_BY_USERNAME_ENDPOINT + ", method: GET")
    class UserTestsForGetMethod {
        @Nested
        @DisplayName("Positive tests")
        class PositiveUserTestsForGetMethod {
            @DisplayName("Find user with default username = 'user1'")
            @Test
            void shouldReturnDefaultUserByUsername() throws ApiException {
                User response = apiService.findUserByUsername(DEFAULT_USERNAME);
                assertThat(response).matches(user -> user.getUsername().equals(DEFAULT_USERNAME));
                System.out.println("User with username " + response.getUsername() + " has Id " + response.getId());
            }

        }

        @Nested
        @DisplayName("Negative tests")
        class NegativeUserTestsForGetMethod {
        }
    }

    @Nested
    @DisplayName("Endpoint: " + USER_LOGIN_ENDPOINT + ", method: GET")
    class UserLoginTestsForGetMethod {
        @Nested
        @DisplayName("Positive tests")
        class PositiveUserLoginTestsForPostMethod {
            @DisplayName("User logs into system")
            @Test
            void shouldLoginUser() throws ApiException {
                User user = User.getDefaultUser();
                String username = user.getUsername();
                String password = user.getPassword();
                ApiResponse response = apiService.loginUser(username, password);
                assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
                System.out.println("Test User with username " + user.getUsername() + " logged in successfully: " + response.getMessage());
            }
        }

        @Nested
        @DisplayName("Negative tests")
        class NegativeUserLoginTestsForPostMethod {
        }
    }

    @Nested
    @DisplayName("Endpoint: " + USER_LOGOUT_ENDPOINT+ ", method: GET")
    class UserLogoutTestsForGetMethod {
        @Nested
        @DisplayName("Positive tests")
        class PositiveUserLogoutTestsForPostMethod {
            @DisplayName("User logs out")
            @Test
            void shouldLogoutUser() throws ApiException {
                User user = User.getDefaultUser();
                ApiResponse response = apiService.logoutUser();
                assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
                assertThat(response.getMessage()).isEqualTo("ok");
                System.out.println("Test User with username " + user.getUsername() + " logged out successfully");
            }
        }

        @Nested
        @DisplayName("Negative tests")
        class NegativeUserLogoutTestsForPostMethod {
        }
    }

    @Nested
    @DisplayName("Endpoint: " + USER_BY_USERNAME_ENDPOINT +", method: PUT")
    class UserTestsForPutMethod {
        @Nested
        @DisplayName("Positive tests")
        class PositiveUserTestsForPutMethod {
            @DisplayName("Update user with default username = 'user1'")
            @Test
            void shouldUpdateDefaultUserId() throws ApiException {
                User user = new User();
                user.setUsername(DEFAULT_USERNAME);
                user.setId(123L);
                ApiResponse response = apiService.updateUserByUsername(user);
                assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
                assertThat(response.getMessage()).isEqualTo(user.getId().toString());
                System.out.println("User with username " + user.getUsername()
                        + " changed Id to " + response.getMessage());
            }
        }

        @Nested
        @DisplayName("Negative tests")
        class NegativeUserTestsForPutMethod {
        }
    }

    @Nested
    @DisplayName("Endpoint: " + USER_BY_USERNAME_ENDPOINT +", method: DELETE")
    class UserTestsForDeleteMethod {
        @Nested
        @DisplayName("Positive tests")
        class PositiveUserTestsForDeleteMethod {
            @DisplayName("Remove Test User with default username = 'user1'")
            @Test
            void shouldRemoveDefaultUserByUsername() throws ApiException {
                ApiResponse response = apiService.removeUserByUsername(DEFAULT_USERNAME);
                assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
                assertThat(response.getMessage()).isEqualTo(DEFAULT_USERNAME);
                System.out.println("User with username " + DEFAULT_USERNAME
                        + " removed successfully");
            }
        }

        @Nested
        @DisplayName("Negative tests")
        class NegativeUserTestsForDeleteMethod {
            @DisplayName("Throws exception, when try to remove random User")
            @Test
            void shouldThrowExceptionWhenTryRemoveRandomUser() {
                User user = User.getDefaultUser();
                assertThrows(ApiException.class, () -> apiService.removeUserByUsername(user.getUsername()), "throws when User not found");
                System.out.println("Test User with userName " + user.getUsername()
                        + " was not found");
            }
        }
    }
}
