package tests.uitest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseUiTest{

    @DisplayName("Check if website opened and its title = 'bWAPP, a buggy web application!'")
    @Test
    public void checkIfOpenedHomePage() throws InterruptedException {

        mainPage.openHomePage();

        assertThat(driver.getTitle()).contains("bWAPP, a buggy web application!");
    }

// ToDo Create enum of site specific text strings and create ParameterizedTests

    @DisplayName("Check if BugsPage opened and its header = 'Bugs'")
    @Test
    public void checkIfOpenedBugsPage() throws InterruptedException {

        mainPage.openBugsPage();

        assertThat(driver.findElement(By.xpath("//*[@id='main']")).getText()).contains("Bugs");
    }

    @DisplayName("Check if DownloadPage opened and its header = 'Download'")
    @Test
    public void checkIfOpenedDownloadPage() throws InterruptedException {

        mainPage.openDownloadPage();

        assertThat(driver.findElement(By.xpath("//*[@id='main']")).getText()).contains("Download");
    }
}
