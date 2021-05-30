package lib.ui.factories;

import lib.Platform;
import lib.ui.Android.AndroidWelcomePageObject;
import lib.ui.IOS.IOSWelcomePageObject;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObjectFactory {
    public static WelcomePageObject get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidWelcomePageObject(driver);
        } else {
            return new IOSWelcomePageObject(driver);
        }
    }
}
