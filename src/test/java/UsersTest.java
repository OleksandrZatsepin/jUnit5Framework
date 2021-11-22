import model.ApiResponse;
import model.User;

import org.assertj.core.api.Assertions;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import service.ApiException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static config.SystemConstants.*;
import static constant.HTTPStatusCodes.*;
import static org.assertj.core.api.Assertions.*;
import static org.awaitility.Awaitility.await;

@DisplayName("User tests:")
public class UsersTest extends BaseTest {

    static List<User> users = new ArrayList<>();
    static String[] userNames = new String[DEFAULT_ARRAY_LENGTH];

//    @BeforeAll
//    static void addTestUsers() throws ApiException {
//        for (int i = 0; i < DEFAULT_ARRAY_LENGTH; i++) {
//            User user = User.getDefaultUser();
//            users.add(user);
//            userNames[i] = user.getUsername();
//            System.out.println(userNames[i]);
//            ApiResponse response = apiService.addUser(user);
//            assertThat(response.getCode().equals(STATUS_CODE_OK));
//            assertThat(response.getMessage().equals(user.getId().toString()));
//        }
//    }


    @DisplayName("Find user with default username = 'user1'")
    @Test
    void shouldReturnUserByUsername() throws ApiException {
        User response = apiService.findUserByUsername(DEFAULT_USERNAME);
        assertThat(response).matches(user -> user.getUsername().equals(DEFAULT_USERNAME));
        System.out.println("User with username " + response.getUsername() + " has Id " + response.getId());
    }

    @DisplayName("Update user with default username = 'user1'")
    @Test
    void shouldUpdateUserId() throws ApiException {
        User user = User.getDefaultUser();
        user.setUsername(DEFAULT_USERNAME);
        user.setId(123L);
        ApiResponse response = apiService.updateUserByUsername(user);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        assertThat(response.getMessage()).isEqualTo(user.getId().toString());
        System.out.println("User with username " + user.getUsername() + " has Id " + user.getId());
    }

//    @Disabled("Doesn't work yet")
//    @DisplayName("Find test users by their usernames")
//    @ParameterizedTest()
//    @MethodSource ("getListOfTestUsersByUsername")
//    void shouldFindUsersWithTestUsernames(String[] userNames) throws ApiException {
//        for (String userName : userNames) {
//            User response = apiService.findUserByUsername(userName);
//            assertThat(response).matches(user -> user.getUsername().equals(userName));
//        }
//    }
//    static Stream<String> getListOfTestUsersByUsername() {
//        return Stream.of(userNames);
//    }

    @DisplayName("Add random test user")
    @Test
    void addTestUser() throws ApiException {
        User user = User.getDefaultUser();
        ApiResponse response = apiService.addUser(user);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
        assertThat(response.getMessage()).isEqualTo(user.getId().toString());
        System.out.println("TestUser with username " + user.getUsername() + " has Id " + user.getId());
    }

    @Disabled("Doesn't work correctly yet")
    @DisplayName("Remove previously created TestUser by username")
    @RepeatedTest(10)
    void removeTestUser() throws ApiException {
        User user = User.getDefaultUser();
        String testUserName = user.getUsername();
        ApiResponse responseOne = apiService.addUser(user);
        assertThat(responseOne.getCode()).isEqualTo(STATUS_CODE_OK);
        System.out.println("User with username " + testUserName + " successfully created ");

        ApiResponse responseTwo = apiService.removeUserByUsername(testUserName);
        assertThat(responseTwo.getCode()).isEqualTo(STATUS_CODE_OK);
        assertThat(responseTwo.getMessage()).isEqualTo(testUserName);
        System.out.println("User with username " + testUserName + " successfully removed ");
    }

    @DisplayName("Create several test users with input ArrayList")
    @Test
    void addListOfUsersWithList() throws ApiException {
        for (int i = 0; i < DEFAULT_ARRAY_LENGTH; i++) {
            User user = User.getDefaultUser();
            users.add(user);
            System.out.println("User with username " + user.getUsername() + " has Id " + user.getId());
        }
        ApiResponse response = apiService.addListOfUsers(users);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
    }

    @DisplayName("Create several test users with input Array")
    @Test
    void addListOfUsersWithArray() throws ApiException {
        User[] users = new User[DEFAULT_ARRAY_LENGTH];
        for (int i = 0; i < DEFAULT_ARRAY_LENGTH; i++) {
            User user = User.getDefaultUser();
            users[i] = user;
            System.out.println("User with username " + user.getUsername() + " has Id " + user.getId());
        }
        ApiResponse response = apiService.addArrayOfUsers(users);
        assertThat(response.getCode()).isEqualTo(STATUS_CODE_OK);
    }


}
