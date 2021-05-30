package lib.ui.Android;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
                MENU_BTN = "xpath://*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']";
                EXPLORE_BTN = "xpath://*[@resource-id='org.wikipedia:id/overflow_feed']";
                ARTICLE_TITLE = "xpath://*[@resource-id='pcs']/android.view.View[1]/android.view.View[1]";
                FOOTER_BTN = "xpath://*[contains(@text,'View article in browser')]";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
