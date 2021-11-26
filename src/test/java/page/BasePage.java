package page;

import static config.SystemConstants.*;
import static config.SystemProperties.*;

import config.SystemProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

abstract class BasePage {
    protected final WebDriver driver;
    protected static String baseUrl;

    public BasePage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = SystemProperties.BASE_URL;
    }

    protected void open(String path) {
        path += baseUrl;
        driver.get(path);
    }

    protected void click(By locator) {
        click(findElement(locator));
    }

    protected void click(WebElement element) {
        new WebDriverWait(driver, Duration.ofMillis(MAX_WAIT_DURATION_MILLIS))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected WebElement findElement(By locator) {
        return new WebDriverWait(driver, Duration.ofMillis(MAX_WAIT_DURATION_MILLIS))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected void typeText(String text, By locator) {
        WebElement element = findElement(locator);
        element.sendKeys(text);
    }

    protected void refresh() {
        driver.navigate().refresh();
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    protected WebElement waitElementIsVisible(WebElement element) {
        return new WebDriverWait(driver, Duration.ofMillis(MAX_WAIT_DURATION_MILLIS))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
