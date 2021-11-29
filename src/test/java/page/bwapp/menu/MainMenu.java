package page.bwapp.menu;

import org.openqa.selenium.WebDriver;
import page.MainPage;

import static page.bwapp.menu.MainMenuXpath.*;

public class MainMenu extends MainPage {

    protected static MainMenuXpath mainMenuXpath;

    public MainMenu(WebDriver driver) {
        super(driver);
    }
// ToDo: Check opening page by click on menu item.
    private void validate() {
        throw new IllegalStateException("Menu items are missing or not clickable");
    }

    public void chooseMainMenuItemByXpath(MainMenuXpath mainMenuXpath) {
        switch (mainMenuXpath) {
            case HOME_MENU_ITEM_XPATH:
                driver.findElement(HOME_MENU_ITEM_XPATH.getMainMenuXpath()).click();
                break;
            case BUGS_MENU_ITEM_XPATH:
                driver.findElement(BUGS_MENU_ITEM_XPATH.getMainMenuXpath()).click();
                break;
            case DOWNLOAD_MENU_ITEM_XPATH:
                driver.findElement(DOWNLOAD_MENU_ITEM_XPATH.getMainMenuXpath()).click();
                break;
            case TRAINING_MENU_ITEM_XPATH:
                driver.findElement(TRAINING_MENU_ITEM_XPATH.getMainMenuXpath()).click();
                break;
            case BLOG_MENU_ITEM_XPATH:
                driver.get("http://itsecgames.blogspot.com/");
                break;
            default:
                validate();
                break;
        }
    }
}


