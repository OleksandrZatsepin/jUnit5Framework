package tests.uitest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import page.MainPage;

import java.time.Duration;

import static config.SystemConstants.*;

public abstract class BaseUiTest {

    protected static WebDriver driver;
    protected static MainPage mainPage;

    @BeforeEach
    void init() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(IMPLICIT_WAIT_DURATION_MILLIS));
        mainPage = new MainPage(driver);
    }

    void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        clearCookiesAndLocalStorage();
        driver.quit();
    }
}
