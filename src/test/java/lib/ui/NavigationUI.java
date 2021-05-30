package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject{

    protected static String
            READING_LIST_PAGE_BTN,
            MAIN_MENU_BTN,
            AUTH_BTN,
            ADD_TO_READING_LIST_BTN,
            DELETE_FROM_READING_LIST_BTN;
    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
    public void goToAuthFromMainMenu(){
        this.openMainMenuOnMW();
        this.tryClickElementwithFewAttempts(AUTH_BTN,
                "cannot click auth button",
                20);
    }
    public void addingToReadingList(){
        this.waitForElementPresent(ADD_TO_READING_LIST_BTN,
                "Can't find save article button",
                10);
        this.waitForElementAndClick(ADD_TO_READING_LIST_BTN,
                "Can't click save article button",5);
    }
    public void deletingArticleFromRL(){
        if (this.isElementPresent(DELETE_FROM_READING_LIST_BTN)) {
            this.waitForElementPresent(DELETE_FROM_READING_LIST_BTN,
                    "Can't find delete article button",
                    5);
            this.waitForElementAndClick(DELETE_FROM_READING_LIST_BTN,
                    "Can't find delete article button",
                    5);
        }
        waitForElementPresent(ADD_TO_READING_LIST_BTN,
                "Cannot find add to RL button after removing article from RL",
                2);
    }
    public void openMainMenuOnMW(){
        this.waitForElementPresent(MAIN_MENU_BTN,
                "cannot find main menu button",
                5);
        this.waitForElementAndClick(MAIN_MENU_BTN,
                "cannot click main menu button",
                5);
    }
    public void goToSavedArticlesPage(){
        this.waitForElementPresent(READING_LIST_PAGE_BTN,
                "Can't find way to saved articles",
                10);
        this.tryClickElementwithFewAttempts(READING_LIST_PAGE_BTN,
                "Can't find way to saved articles (CLICK)",
                5);
    }
}
