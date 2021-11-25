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

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void open(String baseUrl) {
        driver.get(baseUrl);
    }

    protected void click(By locator) {
        click(findElement(locator));
    }

    protected void click(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_DURATION_SEC))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected WebElement findElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_DURATION_SEC))
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
        return new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_DURATION_SEC))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
