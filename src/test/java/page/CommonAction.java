package page;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static config.SystemConstants.*;

public class CommonAction {

    public static WebDriver driver = null;

    public final WebDriver createDriver() {

        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "linux_chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "win_edge":
                System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "linux_edge":
                System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "win_firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "linux_firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                Assertions.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_DURATION_SEC));
        return driver;
    }
}
