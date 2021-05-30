package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        ARTICLE_TITLE = "xpath://h3[contains(text(),'Java')]";
    }
    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
