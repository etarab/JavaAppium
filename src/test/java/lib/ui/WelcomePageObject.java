package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class WelcomePageObject extends MainPageObject{

    protected static String

            NEXT_BTN,
            LEARN_MORE_TEXT,
            WELCOME_SCREEN_TEXT,
            WELCOME_SECOND_SCREEN_TEXT,
            WELCOME_THRD_SCREEN_TEXT,
            WELCOME_FRTH_SCREEN_TEXT,
            GET_STARTED_BTN,
            HELLO_TEXT_ELEMENT,
            SKIP_BTN;


    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }
    public void skipFirstScreen(){
        this.waitForElementAndClick(
                SKIP_BTN,
                "Can't find SKIP button on start screen");
    }
    public void waitForPresentFreeEncyclopediaText(){
        this.waitForElementPresent(WELCOME_SCREEN_TEXT,
                "Cannot find 'Free Encyclopedia' text");
    }
    public void waitForPresentNewWaysText(){
        this.waitForElementPresent(WELCOME_SECOND_SCREEN_TEXT,
                "Cannot find 'new ways' text");
    }
    public void waitForPresentSearchLangText(){
        this.waitForElementPresent(WELCOME_THRD_SCREEN_TEXT,
                "Cannot find 'search in over 300 languages' text");
    }
    public void waitForPresentHelpMakeBetterText(){
        this.waitForElementPresent(WELCOME_FRTH_SCREEN_TEXT,
                "Cannot find 'Help make the app better' text");
    }
    public void clickNextBtn(){
        this.waitForElementAndClick(NEXT_BTN,
                "Cannot find 'NEXT' button");
    }
    public void clickGetStartedBtn(){
        waitForElementAndClick(GET_STARTED_BTN,
                "Cannot find 'get started' button"
        );
    }




}
