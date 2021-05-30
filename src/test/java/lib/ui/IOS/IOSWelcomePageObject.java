package lib.ui.IOS;

import lib.ui.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSWelcomePageObject extends WelcomePageObject {
    static {
                //IOS
                NEXT_BTN = "name:Next";
                LEARN_MORE_TEXT = "name:Learn more about Wikipedia";
                WELCOME_SCREEN_TEXT = "id:The free encyclopedia";
                WELCOME_SECOND_SCREEN_TEXT = "id:New ways to explore";
                WELCOME_THRD_SCREEN_TEXT = "id:Search in over 300 languages";
                WELCOME_FRTH_SCREEN_TEXT = "id:Help make the app better";
                GET_STARTED_BTN = "name:Get started";
                HELLO_TEXT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='The free encyclopedia']";
                SKIP_BTN = "name:Skip";
    }

    public IOSWelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
