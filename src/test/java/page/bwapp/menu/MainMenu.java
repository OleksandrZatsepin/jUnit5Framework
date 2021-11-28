package page.bwapp.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.bwapp.main.*;
import page.MainPage;
import page.bwapp.sidebar.SideBar;

import static page.bwapp.menu.MainMenuItem.*;

public class MainMenu extends MainPage {

//    protected static MainMenuItem mainMenuItem;

    By homeMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[1]/a");
    By bugsMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[2]/a");
    By downloadMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[3]/a");
    By trainingMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[4]/a");
    By blogMenuItem = By.xpath("//*[@id='menu']/table/tbody/tr/td[5]/a");

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    private void validate() {
        throw new IllegalStateException("Menu items are missing or not clickable");
    }

//    public HomePage openHomePage() {
//
//        findElement(homeMenuItem).click();
//        return new HomePage(driver);
//    }
//
//    public BugsPage openBugsPage() {
////        driver.get(baseUrl);
//        findElement(bugsMenuItem).click();
//    return new BugsPage(driver);
//    }
//
//    public DownloadPage openDownloadPage() {
////        driver.get(baseUrl);
//        findElement(downloadMenuItem).click();
//        return new DownloadPage(driver);
//    }
//
//    public TrainingPage openTrainingPage() {
//        driver.get(baseUrl);
//        findElement(trainingMenuItem).click();
//        return new TrainingPage(driver);
//    }
//
//    public BlogPage openBlogPage() {
//        driver.get(baseUrl);
//        findElement(blogMenuItem).click();
//        return new BlogPage(driver);
//    }

    public void chooseMainMenuItem(MainMenuItem mainMenuItem) {
        switch (mainMenuItem) {
            case HOME_MENU_ITEM:
                driver.get(baseUrl + "index.htm");
                break;
            case BUGS_MENU_ITEM:
                driver.get(baseUrl + "bugs.htm");
                break;
            case DOWNLOAD_MENU_ITEM:
                driver.get(baseUrl + "download.htm");
                break;
            case TRAINING_MENU_ITEM:
                driver.get(baseUrl + "training.htm");
                break;
            case BLOG_MENU_ITEM:
                driver.get("http://itsecgames.blogspot.com/");
                break;
            default:
                validate();
                break;
        }
    }
}


