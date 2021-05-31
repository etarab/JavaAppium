package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Search tests")
public class SearchTests extends CoreTestCase {
    @Test
    @DisplayName("Тест проверка текста плейсхолдера")
    @Description("Тап в строку поиска и сравнение плейсхолдера с ожидаемым текстом")
    @Step("Start testCompareText")
    @Feature(value = "Search line")
    @Severity(value = SeverityLevel.MINOR)
    public void testCompareText(){


        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.checkSearchFieldText();
    }

    @Test
    @DisplayName("Тест проверка очистки поиска")
    @Description("Ввод текста в строку поиска и очистка строки поиска")
    @Step("Start testClearSearch")
    @Feature(value = "Search line")
    @Severity(value = SeverityLevel.MINOR)
    public void testClearSearch(){
        String searchWord = "Appium";

        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.searchArticle(searchWord);
        SearchPageObject.checkMoreThanOneElementsOnResult();
        SearchPageObject.searchInputClear();


    }

    @Test
    @DisplayName("Тест проверка результатов поиска")
    @Description("Проверка результатов поиска по сравнению заголовков")
    @Step("Start testCheckSearchResultsTitles")
    @Features(value = {@Feature(value = "Search line"),@Feature(value = "Search")})
    @Severity(value = SeverityLevel.CRITICAL)
    public void testCheckSearchResultsTitles(){
        String searchWord = "java";
        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.searchArticle(searchWord);
        int amount_search_results = SearchPageObject.countSearchResultsOnScreen();
        for (int i = 1; i <= amount_search_results; i++) {
            String result_title = SearchPageObject.getSearchResultTitleString(i);
            Assert.assertTrue("'"+result_title+"' not contain searching word '"+searchWord+"'",
                    result_title.contains(searchWord));
        }
    }

    @Test
    @DisplayName("Тест проверка поиска")
    @Description("Проверка функционала поиска")
    @Step("Start testSearch")
    @Feature(value = "Search")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearch(){
        String searchWord = "Java";
        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(searchWord);
        SearchPageObject.waitForSearchResult("Java (programming language)");
    }
    @Test
    @DisplayName("Тест проверка поиска по заголовку и описанию")
    @Description("Сравнение результатов поиска с учетом заголовков и описаний")
    @Step("Start testSearchByTitleAndDescription")
    @Features(value = {@Feature(value = "Search results"),@Feature(value = "Search")})
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSearchByTitleAndDescription(){
        String searchWord = "Java";
        if(!Platform.getInstance().isMW()){
            WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
            WelcomePageObject.skipFirstScreen();
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(searchWord);
        SearchPageObject.waitForElementByTitleAndDescription("Java", "Indonesian island");
        SearchPageObject.waitForElementByTitleAndDescription("JavaScript", "High-level programming language");
        SearchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");
    }
}
