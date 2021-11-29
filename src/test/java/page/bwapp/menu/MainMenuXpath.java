package page.bwapp.menu;

import org.openqa.selenium.By;

public enum MainMenuXpath {

    HOME_MENU_ITEM_XPATH(By.xpath("//*[@id='menu']/table/tbody/tr/td[1]")),
    BUGS_MENU_ITEM_XPATH(By.xpath("//*[@id='menu']/table/tbody/tr/td[2]")),
    DOWNLOAD_MENU_ITEM_XPATH(By.xpath("//*[@id='menu']/table/tbody/tr/td[3]")),
    TRAINING_MENU_ITEM_XPATH(By.xpath("//*[@id='menu']/table/tbody/tr/td[4]")),
    BLOG_MENU_ITEM_XPATH(By.xpath("//*[@id='menu']/table/tbody/tr/td[5]"));

    private final By mainMenuXpath;

    MainMenuXpath(By mainMenuXpath) {
        this.mainMenuXpath = (By) mainMenuXpath;
    }

    public By getMainMenuXpath() {
        return (By) mainMenuXpath;
    }
}