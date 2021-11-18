package tests;

import config.SystemProperties;
import service.ApiService;

public abstract class BaseTest {

    public static ApiService apiService = new ApiService(SystemProperties.APPLICATION_URL);

}
