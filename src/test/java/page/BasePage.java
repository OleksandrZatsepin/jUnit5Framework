package page;

import static config.SystemConstants.*;
import static config.SystemProperties.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

abstract class BasePage {

    protected WebDriver driver;
    protected static String baseUrl = BASE_URL;


    protected BasePage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String path) {
        driver.get(baseUrl + path);
    }

    public void click(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_DURATION_MILLIS))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public WebElement findElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_DURATION_MILLIS))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void typeText(String text, By locator) {
        WebElement element = findElement(locator);
        element.sendKeys(text);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }
}
