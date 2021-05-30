package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import lib.ui.factories.WelcomePageObjectFactory;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
    @Test
    public void testPassThroughWelcome(){
        if (Platform.getInstance().isAndroid()){
            return;
        }
        WelcomePageObject WelcomePageObject = WelcomePageObjectFactory.get(driver);
        WelcomePageObject.waitForPresentFreeEncyclopediaText();
        WelcomePageObject.clickNextBtn();
        WelcomePageObject.waitForPresentNewWaysText();
        WelcomePageObject.clickNextBtn();
        WelcomePageObject.waitForPresentSearchLangText();
        WelcomePageObject.clickNextBtn();
        WelcomePageObject.waitForPresentHelpMakeBetterText();
        WelcomePageObject.clickGetStartedBtn();
    }
}
