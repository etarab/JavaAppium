package lib.ui.IOS;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "xpath://XCUIElementTypeButton[@name='Cancel']/preceding-sibling::XCUIElementTypeSearchField";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_PLACE_HOLDER = "Search Wikipedia";
        ONE_OF_MANY_RESULT_TITLE_TPL = "xpath://XCUIElementTypeCell[{NUMBER}}]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]";
        SEARCH_RESULT_TITLE = "xpath://XCUIElementTypeStaticText";

        ARTICLE_TITLE_RESULT_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SEARCHLANG} (programming language)')]";
        ARTICLE_TITLE_DESCRIPTION_RESULT_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]/following-sibling::XCUIElementTypeStaticText[contains(@name,'{DESCRIPTION}')]";

    }

    public IOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
