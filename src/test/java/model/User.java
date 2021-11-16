package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.javafaker.Faker;

import java.util.Random;

@JsonPropertyOrder({
        "id",
        "username",
        "firstName",
        "lastName",
        "email",
        "password",
        "phone",
        "userStatus"
})
public class User {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public static User getDefaultUser() {
        final Faker faker = new Faker();
        final User user = new User();
        user.setId(new Random().nextLong());
        user.setUsername("asd");
        user.setFirstName("zxc");
        user.setLastName("qwe");
        user.setEmail("qaz");
        user.setPassword("wsx");
        user.setPhone("edc");
//        user.setUsername(faker.name().username());
//        user.setFirstName(faker.name().firstName());
//        user.setLastName(faker.name().lastName());
//        user.setEmail(faker.internet().emailAddress());
//        user.setPassword(faker.internet().password());
//        user.setPhone(faker.phoneNumber().cellPhone());
        user.setUserStatus(new Random().nextInt());
        return user;
    }
}