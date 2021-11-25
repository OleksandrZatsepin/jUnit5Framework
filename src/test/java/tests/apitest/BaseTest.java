package tests.apitest;

import config.SystemProperties;
import service.ApiService;

public abstract class BaseTest {

    static ApiService apiService = new ApiService(SystemProperties.APPLICATION_URL);
}
