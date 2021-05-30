package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Locale;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            ONE_OF_MANY_RESULT_TITLE_TPL,
            SEARCH_RESULT_TITLE,
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_PLACE_HOLDER,
            ARTICLE_TITLE_RESULT_TPL,
            ARTICLE_TITLE_DESCRIPTION_RESULT_TPL;


    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
    }

    public void initSearchInput(){
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,"Cannot search input after click",5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,"Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT,"Cannot search input after click",10);
    }

    public void typeSearchLine(String search_line){

        this.waitForElementPresent(SEARCH_INPUT,"Cannot find search input",10);
        this.waitForElementAndSendKeys(SEARCH_INPUT,"Cannot find and type to search input",search_line,5);
    }

    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring, 5);
    }

    public void checkSearchFieldText(){
        this.assertElementHasText(SEARCH_INPUT,
                "Unexpected text. Compare search field text finished with failed",
                SEARCH_PLACE_HOLDER);
    }
    public void checkMoreThanOneElementsOnResult(){
        this.waitForElementPresent(SEARCH_RESULT_TITLE,
                "Search results not found",5);
        this.checkMoreThanOneElementsOnScreen(SEARCH_RESULT_TITLE,
                "Just one element on screen");
    }
    public void searchInputClear(){
        this.waitForElementAndClear(
                SEARCH_INPUT,
                "can't find search field");
        this.assertElementHasText(SEARCH_INPUT,
                "Search field clearing is not works",
                "Search Wikipedia");
    }
    public int countSearchResultsOnScreen(){
        this.waitForElementPresent(SEARCH_RESULT_TITLE,
                "Can't find some search results",10);
        return this.countElementOnScreen(SEARCH_RESULT_TITLE);
    }
    private String getItemFromResultList(int number_of_title){
        String number = Integer.toString(number_of_title);
        return ONE_OF_MANY_RESULT_TITLE_TPL.replace("{NUMBER}",number);
    }

    public String getSearchResultTitleString(int number_of_title){
        WebElement title_element = this.waitForElementPresent(getItemFromResultList(number_of_title),
                "Can't find title element for compare strings",10);

        if(!Platform.getInstance().isMW()){
            return title_element.getAttribute("text");
        } else {
            return title_element.getText().toLowerCase(Locale.ROOT);
        }
    }

    public String getItemFromResultListByTitle(String searchLang){
        return ARTICLE_TITLE_RESULT_TPL.replace("{SEARCHLANG}",searchLang);
    }
    public void openLanguageArticlePage(String searchLang){
        this.waitForElementAndClick(getItemFromResultListByTitle(searchLang),
                "Can't find "+ searchLang +" page",5);
    }

    public String getLangArticleTitle(String searchLang){
        WebElement titleElement = this.waitForElementPresent(getItemFromResultListByTitle(searchLang),
                "Cannot find article with "+searchLang+" programming lang",
                5);
        if(Platform.getInstance().isAndroid()) {
            return titleElement.getAttribute("text");
        }else if(Platform.getInstance().isIOS()) {
            return titleElement.getAttribute("name");
        } else {
            return titleElement.getAttribute("title");
        }
    }
    public String getLangArticleDescription(String searchLang){
        if(Platform.getInstance().isIOS()) {
            WebElement titleElement = this.waitForElementPresent(getItemFromResultListByTitle(searchLang) + "/following-sibling::XCUIElementTypeStaticText",
                    "Cannot find article with " + searchLang + " programming lang",
                    5);
            return titleElement.getAttribute("name");
        }else if(Platform.getInstance().isAndroid()) {
            WebElement titleElement = this.waitForElementPresent(getItemFromResultListByTitle(searchLang) + "/following-sibling::XCUIElementTypeStaticText",
                    "Cannot find article with " + searchLang + " programming lang",
                    5);
            return titleElement.getAttribute("text");
        } else {
            WebElement titleElement = this.waitForElementPresent(getItemFromResultListByTitle(searchLang) + "/a/div[@class = 'wikidata-description']",
                    "Cannot find article with " + searchLang + " programming lang",
                    5);
            return titleElement.getText();
        }
    }
    public String getItemFromResultListByTitleDescription(String search_title, String search_description){
        return ARTICLE_TITLE_DESCRIPTION_RESULT_TPL.replace("{TITLE}",search_title).replace("{DESCRIPTION}",search_description);
    }
    public void waitForElementByTitleAndDescription(String search_title, String search_description){
        this.waitForElementPresent(getItemFromResultListByTitleDescription(search_title,search_description),
                "Can't find title '"+ search_title +"' or description of article '"+search_description+"' in search results",10);
    }
    public void searchArticle(String searching_word){
        this.initSearchInput();
        this.typeSearchLine(searching_word);
    }
}
