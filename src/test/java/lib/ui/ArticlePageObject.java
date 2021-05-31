package lib.ui;

import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject{

    protected static String
        MENU_BTN,
        EXPLORE_BTN,
        ARTICLE_TITLE,
        FOOTER_BTN;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Переход на главную страницу")
    public void returnToMainPage(){
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementPresent(MENU_BTN,
                    "Can't find three dots",
                    10);
            this.waitForElementAndClick(MENU_BTN,
                    "Can't find three dots");
        }
        this.waitForElementAndClick(EXPLORE_BTN,
                "Can't find Explore button");
    }
    @Step("Получение текста заголовка")
    public  String getArticleTitleString(){
        this.waitForElementPresent(ARTICLE_TITLE,
                "Cannot find title by attribute",
                10);
        return this.waitForElementAndGetAttribute(ARTICLE_TITLE,
                "text",
                "Cannot take title by attribute",
                10);
    }
    @Step("Сравнение текста заголовка с ожидаемым результатом")
    public void checkArticleTitlePresent(){
        this.waitForElementPresent(ARTICLE_TITLE,"Cannot find title element",10);
        this.assertElementPresent(ARTICLE_TITLE);
    }
    public void swipePageDown(int timeOfSwipe){
        this.swipeScreenUp(timeOfSwipe);
    }
    @Step("Свайп до конца страницы")
    public void swipeToFooter(){
        this.swipeToFindElement(FOOTER_BTN, "Cannot find footer");
    }
}
