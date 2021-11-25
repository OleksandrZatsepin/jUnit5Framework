package page;

import org.openqa.selenium.By;

public class MenuPageLocators {

    protected static final By HOME_MENU_ITEM = By.xpath("//*[@id='menu']/table/tbody/tr/td[1]/a");
    protected static final By BUGS_MENU_ITEM = By.xpath("//*[@id='menu']/table/tbody/tr/td[2]/a");
    protected static final By DOWNLOAD_MENU_ITEM = By.xpath("//*[@id='menu']/table/tbody/tr/td[3]/a");
    protected static final By TRAINING_MENU_ITEM = By.xpath("//*[@id='menu']/table/tbody/tr/td[4]/a");
    protected static final By BLOG_MENU_ITEM = By.xpath("//*[@id='menu']/table/tbody/tr/td[5]/a");

    private MenuPageLocators() {
    }
}
