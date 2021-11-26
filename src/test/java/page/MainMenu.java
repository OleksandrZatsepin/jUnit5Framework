package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static page.MainMenuItem.*;

public class MainMenu extends MainPage{

    private MainMenuItem mainMenuItem;

    public MainMenu(WebDriver driver, String baseUrl) {
        super(driver, baseUrl);
    }

    private void validate() {
        throw new IllegalStateException("Menu items are missing or not clickable");
    }



    public HomePage openHomePage() {
        driver.findElements(HOME_MENU_ITEM.getMainMenuItem());
        return new HomePage(driver, baseUrl);
    }

    public BugsPage openBugsPage() {
        driver.findElements(BUGS_MENU_ITEM.getMainMenuItem());
        return new BugsPage(driver, baseUrl);
    }
//
//    public DownloadPage openDownloadPage() {
//        findElement(DOWNLOAD_MENU_ITEM).click();
//        return new DownloadPage(driver);
//    }
//
//    public TrainingPage openTrainingPage() {
//        findElement(TRAINING_MENU_ITEM).click();
//        return new TrainingPage(driver);
//    }
//
//    public BlogPage openBlogPage() {
//        findElement(BLOG_MENU_ITEM).click();
//        return new BlogPage(driver);
//    }
}
