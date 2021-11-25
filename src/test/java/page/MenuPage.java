package page;

import org.openqa.selenium.WebDriver;

import static page.MenuPageLocators.*;

public class MenuPage extends MainPage{

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    private void validate() {
        throw new IllegalStateException("Menu items are missing or not clickable");
    }

    public HomePage openHomePage() {
        findElement(HOME_MENU_ITEM).click();
        return new HomePage(driver);
    }

    public BugsPage openBugsPage() {
        findElement(BUGS_MENU_ITEM).click();
        return new BugsPage(driver);
    }

    public DownloadPage openDownloadPage() {
        findElement(DOWNLOAD_MENU_ITEM).click();
        return new DownloadPage(driver);
    }

    public TrainingPage openTrainingPage() {
        findElement(TRAINING_MENU_ITEM).click();
        return new TrainingPage(driver);
    }

    public BlogPage openBlogPage() {
        findElement(BLOG_MENU_ITEM).click();
        return new BlogPage(driver);
    }
}
