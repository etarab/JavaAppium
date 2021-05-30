package lib.ui.Android;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListPageObject extends MyListsPageObject {
    static {
        ARTICLE_TITLE_OOM_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][{NUMBER}]";
        ARTICLE_TITLE_ITEM = "id:org.wikipedia:id/page_list_item_title";
        ARTICLE_TITLE_ON_RL = "xpath://*[contains(@text,'{TITLE}')]";
        DEFAULT_READING_LIST = "xpath://*[@resource-id='org.wikipedia:id/item_title'][contains(@text,'Saved')]";
    }
    public AndroidMyListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
