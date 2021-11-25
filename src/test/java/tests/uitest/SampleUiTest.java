package tests.uitest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.CommonAction;

public class SampleUiTest {

    @Test
    public void checkIfOpenedHomePage() {
       WebDriver driver = new CommonAction().createDriver();
       driver.get("http://www.itsecgames.com/index.htm");
    }
}
