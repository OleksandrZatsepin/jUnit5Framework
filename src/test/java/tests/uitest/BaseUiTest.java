package tests.uitest;

import config.SystemProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import page.MainPage;

import java.time.Duration;

import static config.SystemConstants.*;

public abstract class BaseUiTest {

    protected static WebDriver driver;
    protected static String baseUrl;
    protected static MainPage mainPage;
    protected HomePage homePage = new HomePage(driver,baseUrl);

    @BeforeAll
    public static void setup() {
        baseUrl = SystemProperties.BASE_URL;
    }

    @BeforeEach
    void init() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(IMPLICIT_WAIT_DURATION_MILLIS));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
