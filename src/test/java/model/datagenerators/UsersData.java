package model.datagenerators;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.github.javafaker.Faker;

import java.util.HashMap;

@JsonAutoDetect
public class UsersData {
    public UsersData() {}

    public static HashMap<String, String> generateNewUser() {
        Faker faker = new Faker();

        HashMap<String, String> user = new HashMap<>();
        user.put("name", faker.name().firstName());
        user.put("job", faker.job().title());
        return user;
    }
}
