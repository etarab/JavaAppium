package lib.ui.Android;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {
    static {
        READING_LIST_PAGE_BTN = "xpath://*[@resource-id='org.wikipedia:id/smallLabel'][contains(@text,'Saved')]";
        ADD_TO_READING_LIST_BTN = "xpath://*[@resource-id='org.wikipedia:id/article_menu_bookmark'][contains(@text,'Save')]";
    }

    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
