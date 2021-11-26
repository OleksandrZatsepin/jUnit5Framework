package tests.uitest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.*;

public class SampleUiTest extends BaseUiTest{

    @Test
    public void checkIfOpenedHomePage() {
        driver.get(baseUrl);
        assertThat(driver.getTitle()).contains("bWAPP, a buggy web application!");
    }
}
