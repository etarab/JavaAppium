package lib.ui.factories;

import lib.Platform;
import lib.ui.Android.AndroidMyListPageObject;
import lib.ui.IOS.IOSMyListPageObject;
import lib.ui.MyListsPageObject;
import lib.ui.mobile_web.MWMyListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class MyListPageObjectFactory {
    public static MyListsPageObject get(RemoteWebDriver driver){
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMyListPageObject(driver);
        } else if(Platform.getInstance().isIOS()) {
            return new IOSMyListPageObject(driver);
        } else {
            return new MWMyListPageObject(driver);
        }
    }
}
