package config;

public class SystemProperties {
    public static final String APPLICATION_URL = System.getProperty("application.url");
//    public static final String API_KEY = System.getProperty("api.key");
//    public static final String API_SECRET = System.getProperty("api.secret");
    public static final String BASE_URL = System.getProperty("testSite.url");

    private SystemProperties() {
    }
}
