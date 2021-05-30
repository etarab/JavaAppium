package lib.ui.IOS;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListPageObject extends MyListsPageObject {
    static {
        CLOSE_SYNC_POPUP = "xpath://XCUIElementTypeButton[@name='Close']";
        DELETE_FROM_RL_BTN = "id:swipe action delete";
        ARTICLE_TITLE_OOM_TPL = "xpath://XCUIElementTypeCell[{NUMBER}]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]";
        ARTICLE_TITLE_ITEM = "xpath://XCUIElementTypeStaticText[@name='{SEARCHLANG} (programming language)']";
        ARTICLE_TITLE_ON_RL = "xpath://*[contains(@name,'{TITLE}')]";
        DEFAULT_READING_LIST = "xpath://*[@resource-id='org.wikipedia:id/item_title'][contains(@text,'Saved')]";
    }
    public IOSMyListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
