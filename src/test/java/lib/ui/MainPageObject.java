package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class MainPageObject {
    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver){
        this.driver = driver;
    }


    public void checkMoreThanOneElementsOnScreen(String locator, String error_message) {
        By by = getLocatorString(locator);
        int count_elements = driver.findElements(by).size();
        Assert.assertTrue(error_message, count_elements>1);
    }
    public void assertElementHasText(String locator, String error_message, String expected_text){
        WebElement title_element = waitForElementPresent(locator, error_message);
        String title_text = "";
        if(Platform.getInstance().isAndroid()){
            title_text = title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            title_text = title_element.getAttribute("name");
        } else {
            title_text = title_element.getAttribute("placeholder");
        }
        Assert.assertEquals(error_message,
                expected_text,
                title_text);
    }

    public void waitForElementAndClear(String locator, String error_message){
        WebElement element = waitForElementPresent(locator, error_message);
        element.clear();
    }
    public void waitForElementAndSendKeys(String locator, String error_message, String value, long timeOut){
        WebElement element = waitForElementPresent(locator, error_message, timeOut);
        element.sendKeys(value);
    }
    public void waitForElementAndSendKeys(String locator, String error_message, String value){
        WebElement element = waitForElementPresent(locator, error_message);
        element.sendKeys(value);
    }
    public void waitForElementAndClick(String locator, String error_message){
        WebElement element = waitForElementPresent(locator, error_message);
        element.click();
    }
    public void waitForElementAndClick(String locator, String error_message,long timeOut){
        WebElement element = waitForElementPresent(locator, error_message,timeOut);
        element.click();
    }
    public WebElement waitForElementPresent(String locator, String error_message){
        return waitForElementPresent(locator, error_message, 5);
    }
    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds ){
        By by = this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    protected void swipeScreenUp(int timeOfSwipe){

        if(driver instanceof AppiumDriver){
            TouchAction action = new TouchAction((AppiumDriver)driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);
            action
                    .press(PointOption.point(x,start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x,end_y))
                    .release()
                    .perform();
        } else {
            System.out.println("Method swipeScreenUp() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }
    public boolean isElementPresent(String locator){
        return countElementOnScreen(locator) > 0;
    }
    protected void swipeUpQuick(){
        swipeScreenUp(200);
    }
        protected void swipeToFindElement(String locator, String error_message){
        By by = this.getLocatorString(locator);
        driver.findElements(by);
        driver.findElements(by).size();
        while (driver.findElements(by).size() == 0){
            swipeUpQuick();
        }
    }
    public void swipeElementLeft(String locator, String error_message, int timeOfSwipe){

        if (driver instanceof AppiumDriver){
            WebElement element = waitForElementPresent(locator, error_message);
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int up_y = element.getLocation().getY();
            int down_y = up_y + element.getSize().getHeight();
            int middle_y = (up_y + down_y) / 2;

            TouchAction action = new TouchAction((AppiumDriver) driver);
            action
                    .press(PointOption.point(right_x, middle_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(left_x, middle_y))
                    .release()
                    .perform();
        } else {
            System.out.println("Method swipeElementLeft() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
    public void scrollWebPage(){
        if(Platform.getInstance().isMW()){
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            JSExecutor.executeScript("window.scrollBy(0,250)");
        } else {
            System.out.println("Method scrollWebPage() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
    public int countElementOnScreen(String locator){
        By by = this.getLocatorString(locator);
        return (driver.findElements(by).size());
    }
    public void assertElementPresent(String locator){
        By by = this.getLocatorString(locator);
        waitForElementPresent(locator,"Cannot find title element",5);
        Assert.assertTrue("Cannot find element '"+by.toString()+"' on screen",countElementOnScreen(locator)>0);
    }
    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeOut){
        return waitForElementPresent(locator, error_message, timeOut).getAttribute(attribute);
    }

    private By getLocatorString(String locator_with_type){
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if(by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")){
            return By.id(locator);
        } else if (by_type.equals("name")){
            return By.name(locator);
        } else if (by_type.equals("css")){
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type or locator: " + locator_with_type);
        }
    }

    public void tryClickElementwithFewAttempts(String locator, String error_message, int amount_of_attempts){
        int current_attempts = 0;
        boolean need_more_attempts = true;

        while (need_more_attempts){
            try {
                waitForElementAndClick(locator, error_message,2);
                need_more_attempts = false;
            } catch (Exception e){
                if(current_attempts > amount_of_attempts){
                    waitForElementAndClick(locator,error_message,2);
                }
            }
            ++ current_attempts;
        }
    }
}


