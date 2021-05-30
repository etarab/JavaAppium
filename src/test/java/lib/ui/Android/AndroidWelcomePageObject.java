package lib.ui.Android;

import lib.ui.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidWelcomePageObject extends WelcomePageObject {

    static {
        //IOS
        NEXT_BTN = "id:org.wikipedia:id/fragment_onboarding_forward_button";
        WELCOME_SCREEN_TEXT = "xpath://*[contains(@text,'The Free Encyclopedia')]";
        WELCOME_SECOND_SCREEN_TEXT = "xpath://*[contains(@text,'New ways to explore')]";
        GET_STARTED_BTN = "id:org.wikipedia:id/fragment_onboarding_done_button";

        WELCOME_THRD_SCREEN_TEXT = "id:Search in over 300 languages";
        WELCOME_FRTH_SCREEN_TEXT = "id:Help make the app better";
        LEARN_MORE_TEXT = "name:Learn more about Wikipedia";
        //Android
        HELLO_TEXT_ELEMENT = "id:org.wikipedia:id/primaryTextView";

        SKIP_BTN = "xpath://*[contains(@text,'SKIP')]";
    }
    public AndroidWelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
