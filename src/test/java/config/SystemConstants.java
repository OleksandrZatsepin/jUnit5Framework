package config;

public class SystemConstants {

    /**
     * Constants for API tests.
     */
    public static final int DEFAULT_ARRAY_LENGTH = 3;
    public static final String TEST_NAME_PREFIX = "FUNC_TEST_";
    public static final String DEFAULT_USERNAME = "user1";

    /**
     * Timeout constants in seconds.
     * Implicit and Explicit wait.
     */
    public static final Long IMPLICIT_WAIT_DURATION_MILLIS = 1L;
    public static final Long MAX_WAIT_DURATION_MILLIS = 10L;

    /**
     * Browser constant.
     * Uncomment only one string.
     * It works with BROWSER = "Chrome" now.
     *
     * public static final String BROWSER = "Chrome";
     * public static final String BROWSER = "Firefox";
     * public static final String BROWSER = "Edge";
     * public static final String BROWSER = "Opera";
     * public static final String BROWSER = "Safari";
     * public static final String BROWSER = "Internet Explorer";
     *
     * TODO Create a Browser Factory with WebDriverManager
     * ( www.eliasnogueira.com/create-a-browser-factory-with-webdrivermanager/ )
     */

    /**
     * Clear browser cookies after each iteration
     * if true - clear cookies
     */
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;

    private SystemConstants() {
    }
}
