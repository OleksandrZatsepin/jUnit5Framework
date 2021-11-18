package config;

public class SystemProperties {
    public static final String APPLICATION_URL = System.getProperty("application.url");
    public static final String API_KEY = System.getProperty("api.key");
    public static final String API_SECRET = System.getProperty("api.secret");
    public static final int DEFAULT_ARRAY_LENGTH = 3;
    public static final String TEST_NAME_PREFIX = "TEST_";
    public static final int MAX_WAIT_TIME_SEC = 5;


    private SystemProperties() {
    }
}
