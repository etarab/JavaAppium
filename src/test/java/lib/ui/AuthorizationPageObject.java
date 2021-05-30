package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class AuthorizationPageObject extends MainPageObject{
    protected static String
        LOG_IN_INPUT,
        PASSWORD_INPUT,
        LOG_IN_BTN,
        AUTH_BTN;

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void authToWiki(String log_in,String password){
        this.waitForElementPresent(LOG_IN_INPUT,
                "Cannot find field for log in input",
                5);
        this.waitForElementAndSendKeys(LOG_IN_INPUT,
                "Cannot send keys to field for log in input",
                log_in);
        this.waitForElementPresent(PASSWORD_INPUT,
                "Cannot find field for password input",
                5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT,
                "Cannot send keys to field for password input",
                password);
        this.waitForElementAndClick(LOG_IN_BTN,
                "Cannot find log in button",
                5);
    }
}
