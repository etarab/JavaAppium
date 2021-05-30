package lib.ui.mobile_web;

import lib.ui.AuthorizationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWAuthorizationPageObject extends AuthorizationPageObject {
    static {
        LOG_IN_INPUT = "css:input#wpName1";
        PASSWORD_INPUT = "css:input#wpPassword1";
        LOG_IN_BTN = "css:button#wpLoginAttempt";
    }
    public MWAuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
