import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import service.ApiService;
import util.SystemProperties;

public abstract class BaseTest {
    ApiService apiService = new ApiService(SystemProperties.APPLICATION_URL);
}
