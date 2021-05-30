package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    static {
        READING_LIST_PAGE_BTN = "xpath://a[@data-event-name='menu.unStar']";
        ADD_TO_READING_LIST_BTN = "css:a.mw-ui-icon-wikimedia-star-base20";
        MAIN_MENU_BTN = "xpath://label[@title='Open main menu']";
        AUTH_BTN = "xpath://span[text()='Log in']";
        DELETE_FROM_READING_LIST_BTN = "css:a.watched";
    }
    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
