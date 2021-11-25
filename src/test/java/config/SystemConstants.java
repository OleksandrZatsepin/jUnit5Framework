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
    public static final Long IMPLICIT_WAIT_DURATION_SEC = 0L;
    public static final Long MAX_WAIT_DURATION_SEC = 5L;

    /**
     * Platform and browser constant.
     * Uncomment only one of them.
     * public static final String PLATFORM_AND_BROWSER = "win_chrome";
     * public static final String PLATFORM_AND_BROWSER = "linux_chrome";
     * public static final String PLATFORM_AND_BROWSER = "win_edge";
     * public static final String PLATFORM_AND_BROWSER = "linux_edge";
     * public static final String PLATFORM_AND_BROWSER = "win_firefox";
     * public static final String PLATFORM_AND_BROWSER = "linux_firefox";
     * TODO - add other platforms and drivers
     */
    public static final String PLATFORM_AND_BROWSER = "linux_chrome";

    /**
     * Clear browser cookies after each iteration
     * if true - clear cookies
     */
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;

    /**
     * To close the browser after test suite
     * if true - browser close
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;

    /**
     * URL for testing
     */
    public static class Urls {
        public static final String SITE_HOME_PAGE = "http://www.itsecgames.com/index.htm";
    }

    private SystemConstants() {
    }
}
