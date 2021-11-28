package page.bwapp.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public enum MainMenuItem {

    HOME_MENU_ITEM(By.xpath("//*[@id='menu']/table/tbody/tr/td[1]/a")),
    BUGS_MENU_ITEM(By.xpath("//*[@id='menu']/table/tbody/tr/td[2]/a")),
    DOWNLOAD_MENU_ITEM(By.xpath("//*[@id='menu']/table/tbody/tr/td[3]/a")),
    TRAINING_MENU_ITEM(By.xpath("//*[@id='menu']/table/tbody/tr/td[4]/a")),
    BLOG_MENU_ITEM(By.xpath("//*[@id='menu']/table/tbody/tr/td[5]/a"));

    private final By mainMenuItem;

    MainMenuItem(By mainMenuItem) {
        this.mainMenuItem = (By) mainMenuItem;
    }

    public By getMainMenuItem() {
        return (By) mainMenuItem;
    }
}