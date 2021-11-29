package page;

import org.openqa.selenium.WebDriver;

import page.bwapp.bee.BeeImage;
import page.bwapp.disclaimer.DisclaimerSection;
import page.bwapp.header.HeaderSection;
import page.bwapp.main.*;
import page.bwapp.menu.MainMenu;
import page.bwapp.menu.MainMenuXpath;
import page.bwapp.sidebar.SideBar;
import page.bwapp.sponsor.SponsorSection;

import static config.SystemProperties.BASE_URL;
import static page.bwapp.main.MainSectionPath.*;

public class MainPage extends BasePage {

    public static String baseUrl = BASE_URL;

    protected HeaderSection headerSection;
    protected MainMenu mainMenu;
    protected SponsorSection sponsorSection;
    protected SideBar sideBar;
    protected DisclaimerSection disclaimerSection;
    protected BeeImage beeImage;

    protected WebDriver driver;
    protected static MainMenuXpath mainMenuXpath;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        open(HOME_PAGE_PATH.getMainSectionPath());
        return new HomePage(driver);
    }

    public BugsPage openBugsPage() {
        open(BUGS_PAGE_PATH.getMainSectionPath());
    return new BugsPage(driver);
    }

    public DownloadPage openDownloadPage() {
        open(DOWNLOAD_PAGE_PATH.getMainSectionPath());
        return new DownloadPage(driver);
    }

    public TrainingPage openTrainingPage() {
        open(TRAINING_PAGE_PATH.getMainSectionPath());
        return new TrainingPage(driver);
    }

}
