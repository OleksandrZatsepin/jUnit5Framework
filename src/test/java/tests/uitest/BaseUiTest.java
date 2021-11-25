package tests.uitest;

import config.SystemProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import page.CommonAction;
import page.HomePage;
import page.MainPage;
import service.ApiService;

import static config.SystemConstants.*;
import static config.SystemProperties.*;

public abstract class BaseUiTest {
    protected static WebDriver driver;
    static ApiService apiService = new ApiService(SystemProperties.APPLICATION_URL);
//    protected MainPage mainPage = new MainPage(driver);
//    protected HomePage homePage = new HomePage(driver);

    @BeforeEach
    void setup() {
        driver = CommonAction.driver;
    }

    @AfterEach
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("windows.sessionStorage.clear()");
        }
    }

    @AfterAll()
    public static void done() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }


}
