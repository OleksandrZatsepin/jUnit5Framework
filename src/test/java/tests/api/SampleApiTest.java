package tests.api;

import model.ApiResponse;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class SampleApiTest extends BaseTest {

    @Test
    void getUserTest() {
        final ApiResponse response = apiService.getSomething();
        assert response.getType().equals("success");
        assert response.getValue() != null;
    }
}
