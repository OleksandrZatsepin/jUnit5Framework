import config.SystemProperties;
import service.ApiService;

public abstract class BaseTest {

    protected ApiService apiService = new ApiService(SystemProperties.APPLICATION_URL);

}
