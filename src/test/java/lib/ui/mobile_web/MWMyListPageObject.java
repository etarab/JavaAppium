package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListPageObject extends MyListsPageObject {
    static {
        ARTICLE_TITLE_OOM_TPL = "xpath://li[contains(@class,'page-summary with-watchstar')][{NUMBER}]";
        ARTICLE_TITLE_ITEM = "xpath://li[contains(@title,'{SEARCHLANG}')]";
        ARTICLE_TITLE_ON_RL = "xpath://li[@title='{TITLE}']";
        DELETE_FROM_RL_TPL = "xpath://li[@title='{TITLE}']/a[contains(@class,'watched')]";
    }
    public MWMyListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
