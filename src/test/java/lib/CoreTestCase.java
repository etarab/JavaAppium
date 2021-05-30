    package lib;

    import io.appium.java_client.AppiumDriver;
    import junit.framework.TestCase;
    import org.junit.After;
    import org.junit.Before;
    import org.openqa.selenium.ScreenOrientation;
    import org.openqa.selenium.remote.RemoteWebDriver;

    import java.io.FileOutputStream;
    import java.time.Duration;
    import java.util.Properties;

    public class CoreTestCase{
        private static final String
                PLATFORM_IOS = "ios",
                PLATFORM_ANDROID = "android";
        protected RemoteWebDriver driver;


        @Before
        public void setUp() throws Exception {
            driver = Platform.getInstance().getDriver();
            this.createAllurePropertyFile();
            this.rotateScreenPortrait();
            this.openWikiWebPageForMobileWeb();
        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
        }

        protected void rotateScreenPortrait(){
            if(driver instanceof AppiumDriver){
                AppiumDriver driver = (AppiumDriver) this.driver;
                driver.rotate(ScreenOrientation.PORTRAIT);
            } else {
                System.out.println("Method rotateScreenPortrait() does nothing for platform " + Platform.getInstance().getPlatformVar());
            }
        }

        protected void rotateScreenLandscape(){
            if(driver instanceof AppiumDriver){
                AppiumDriver driver = (AppiumDriver) this.driver;
                driver.rotate(ScreenOrientation.LANDSCAPE);
            } else {
                System.out.println("Method rotateScreenLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
            }
        }

        protected void backgroundApp(int seconds){
            if(driver instanceof AppiumDriver){
                AppiumDriver driver = (AppiumDriver) this.driver;
                driver.runAppInBackground(Duration.ofMillis(seconds));
            }else {
                System.out.println("Method rotateScreenLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
            }
        }

        protected void openWikiWebPageForMobileWeb(){
            if(Platform.getInstance().isMW()){
                driver.get("https://en.m.wikipedia.org");
            } else {
                System.out.println("Method openWikiWebPageForMobileWeb () does nothing for platform " + Platform.getInstance().getPlatformVar());
            }
        }

        private void createAllurePropertyFile(){
            String path = System.getProperty("allure.results.directory");
            try {
                Properties props = new Properties();
                FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
                props.setProperty("Environments", Platform.getInstance().getPlatformVar());
                props.store(fos,"See https://github.com/allure-framework/allure-app/wiki/environment");
                fos.close();
            } catch (Exception e){
                System.err.println("IO problem when writing allure properties file");
                e.printStackTrace();
            }
        }

    }
