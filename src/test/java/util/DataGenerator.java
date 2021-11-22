package util;

import com.github.javafaker.Faker;
import config.SystemConstants;

public class DataGenerator {
    static Faker faker = new Faker();

    public static Long randomId() {
        return faker.random().nextLong();
    }

    public static String randomPetName() {
        return SystemConstants.TEST_NAME_PREFIX + faker.funnyName().name();
    }

    public static String randomAnimalTag() {
        return SystemConstants.TEST_NAME_PREFIX + faker.animal().name();
    }

    public static String randomAnimalCategory() {
        return SystemConstants.TEST_NAME_PREFIX + faker.animal();
    }

    public static String randomUrl() {
        return faker.internet().url();
    }

    public static String randomEmailAddress() {
        return faker.internet().emailAddress();
    }

    public static String randomPassword() {
        return faker.internet().password();
    }

    public static String randomPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String randomUserName() {
        return SystemConstants.TEST_NAME_PREFIX + faker.name().username();
    }

    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

}
