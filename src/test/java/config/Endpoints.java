package config;

public final class Endpoints {
    public static final String PET_ENDPOINT = "/pet";
    public static final String PETS_BY_STATUS_ENDPOINT = "/pet/findByStatus";
    public static final String PETS_BY_ID_ENDPOINT = "/pet/{petId}";

    public static final String USER_ENDPOINT = "/user";
    public static final String USER_BY_USERNAME_ENDPOINT = "/user/{username}";
    public static final String LIST_OF_USERS_ENDPOINT = "/user/createWithList";
    public static final String ARRAY_OF_USERS_ENDPOINT = "/user/createWithArray";
    public static final String USER_LOGIN_ENDPOINT = "/user/login";
    public static final String USER_LOGOUT_ENDPOINT = "/user/logout";

    public static final String ORDER_FOR_PET_ENDPOINT = "/store/order";
    public static final String ORDER_BY_ID_ENDPOINT = "/store/order/{orderId}";
    public static final String INVENTORIES_BY_STATUS_ENDPOINT = "/store/inventory";
}
