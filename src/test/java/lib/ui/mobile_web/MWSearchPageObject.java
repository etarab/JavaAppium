package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {

    static {

        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form.search-box>input";
        SEARCH_PLACE_HOLDER = "Search Wikipedia";
        SEARCH_RESULT_TITLE = "css:a.title>h3";
        ONE_OF_MANY_RESULT_TITLE_TPL = "css:div.results-list-container>ul>li:nth-of-type({NUMBER})>a>h3";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://h3[contains(text(),'{SUBSTRING}')]";
        ARTICLE_TITLE_DESCRIPTION_RESULT_TPL = "xpath://li[@title='{TITLE}']/a/div[text()='{DESCRIPTION}']";

        ARTICLE_TITLE_RESULT_TPL = "xpath://li[@title='{SEARCHLANG} (programming language)']";

    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
