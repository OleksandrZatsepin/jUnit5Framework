import config.SystemProperties;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import service.ApiService;

public abstract class BaseTest {

    static ApiService apiService = new ApiService(SystemProperties.APPLICATION_URL);
}
