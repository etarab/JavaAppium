package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject{
    protected static String
            ARTICLE_TITLE_OOM_TPL,
            ARTICLE_TITLE_ITEM,
            ARTICLE_TITLE_ON_RL,
            DEFAULT_READING_LIST,
            DELETE_FROM_RL_BTN,
            CLOSE_SYNC_POPUP,
            DELETE_FROM_RL_TPL;

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void goToDefaultReadingList(){
        this.waitForElementPresent(DEFAULT_READING_LIST,
                "Can't find expected reading list",
                10);
        this.waitForElementAndClick(DEFAULT_READING_LIST,
                "Can't find expected reading list");
    }
    private String getArticleTitleElement(String articleTitle){
        return ARTICLE_TITLE_ON_RL.replace("{TITLE}",articleTitle);
    }
    public void deleteElementFromReadingList(String articleTitle){
        if(!Platform.getInstance().isMW()){
            this.swipeElementLeft(getArticleTitleElement(articleTitle),
                    "Can't find some element for delete",
                    1000);
            if (Platform.getInstance().isIOS()){
                this.waitForElementAndClick(DELETE_FROM_RL_BTN,
                        "Cannot find delete article from reading list",
                        5);
            }
        } else {
            this.waitForElementPresent(getDeletingElementFromRL(articleTitle),
                    "Cannot find button 'delete article from reading list'",
                    5);
            this.waitForElementAndClick(getDeletingElementFromRL(articleTitle),
                    "Cannot delete article from reading list");
        }
    }
    private String getDeletingElementFromRL(String articleTitle){
        return DELETE_FROM_RL_TPL.replace("{TITLE}",articleTitle);
    }
    private String getTitleOnReadingList(String searchlang){
        return ARTICLE_TITLE_ITEM.replace("{SEARCHLANG}",searchlang);
    }
    public int countSearchResultsOnScreen(String searchlang){
        this.waitForElementPresent(getTitleOnReadingList(searchlang),
                "Can't find some search results",
                10);
        return this.countElementOnScreen(getTitleOnReadingList(searchlang));
    }
    private String getTitleItemFromList(int number_of_title){
        String number = Integer.toString(number_of_title);
        return ARTICLE_TITLE_OOM_TPL.replace("{NUMBER}",number);
    }
    public String getArticleTitleString(int number_of_title){
        WebElement title_element = this.waitForElementPresent(getTitleItemFromList(number_of_title),
                "Can't find title element for compare strings",
                10);
        if(Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getAttribute("title");
        }
    }

    public String getLangArticleDescription(int number_of_title){
        if(Platform.getInstance().isIOS()) {
            WebElement titleElement = this.waitForElementPresent(getTitleItemFromList(number_of_title) + "/following-sibling::XCUIElementTypeStaticText",
                    "Can't find title element for compare strings",
                    5);
            return titleElement.getAttribute("name");
        }else {
            WebElement titleElement = this.waitForElementPresent(getTitleItemFromList(number_of_title) + "/following-sibling::XCUIElementTypeStaticText",
                    "Can't find title element for compare strings",
                    5);
            return titleElement.getAttribute("text");
        }
    }

    public void closeRLSyncPopup(){
        waitForElementAndClick(CLOSE_SYNC_POPUP,
                "PopUp was not show on screen",
                5);
    }



}
