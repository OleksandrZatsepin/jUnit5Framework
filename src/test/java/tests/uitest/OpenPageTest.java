package tests.uitest;

import org.junit.jupiter.api.Test;

public class OpenPageTest extends BaseUiTest{

    @Test
    public void checkIfOpenedHomePage() {
        driver.get(baseUrl);
    }
}
