package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.bwapp.bee.BeeImage;
import page.bwapp.disclaimer.DisclaimerSection;
import page.bwapp.header.HeaderSection;
import page.bwapp.main.*;
import page.bwapp.main.MainSection;
import page.bwapp.menu.MainMenu;
import page.bwapp.menu.MainMenuItem;
import page.bwapp.sidebar.SideBar;
import page.bwapp.sponsor.SponsorSection;

import static config.SystemProperties.BASE_URL;

public class MainPage extends BasePage {

    public static String baseUrl = BASE_URL;

    protected HeaderSection headerSection;
    public MainMenu mainMenu;
//    protected MainSection mainSection;
    protected SponsorSection sponsorSection;
    protected SideBar sideBar;
    protected DisclaimerSection disclaimerSection;
    protected BeeImage beeImage;

    protected WebDriver driver;
    protected static MainMenuItem mainMenuItem;

    By homeMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[1]");
    By bugsMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[2]");
    By downloadMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[3]");
    By trainingMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[4]");
    By blogMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[5]");

// ToDo Create MainMenu and enum MainMenuItem

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        open("index.htm");
        findElement(homeMenuItem).click();
        return new HomePage(driver);
    }

    public BugsPage openBugsPage() {
        open("bugs.htm");
        findElement(bugsMenuItem).click();
    return new BugsPage(driver);
    }

    public DownloadPage openDownloadPage() {
        open("download.htm");
        findElement(downloadMenuItem).click();
        return new DownloadPage(driver);
    }
}
