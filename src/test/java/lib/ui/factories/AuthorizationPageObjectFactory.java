package lib.ui.factories;

import lib.Platform;
import lib.ui.Android.AndroidAuthorizationPageObject;
import lib.ui.AuthorizationPageObject;
import lib.ui.IOS.IOSAuthorizationPageObject;
import lib.ui.mobile_web.MWAuthorizationPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObjectFactory {
    public static AuthorizationPageObject get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidAuthorizationPageObject(driver);
        } else if (Platform.getInstance().isIOS()){
            return new IOSAuthorizationPageObject(driver);
        } else {
            return new MWAuthorizationPageObject(driver);
        }
    }
}
