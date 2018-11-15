package Android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TestApp {

    public AndroidDriver<AndroidElement> driver;
    public DesiredCapabilities dc = new DesiredCapabilities();
    AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
    File file = new File("src");
    File fs = new File(file,"ApiDemos-debug.apk");

    @BeforeSuite
    void setUp() throws IOException {
        service.start();
        Runtime.getRuntime().exec("/Users/afilippov/Library/Android/sdk/tools/emulator -avd Nexus5 -netdelay none -netspeed full");
        //dc.setCapability(MobileCapabilityType.DEVICE_NAME,"d32d481");
    }

    @Test
    public void baseInteractionsTest() {
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementByClassName("android.widget.EditText").clear();
        driver.findElementByClassName("android.widget.EditText").sendKeys("AppiumTest");;
        driver.findElementsByClassName("android.widget.Button").get(1).click();
    }

    @Test
    public void dragAndDropTest(){
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
        TouchAction ta = new TouchAction(driver);
        ta.longPress(element(driver.findElementById("io.appium.android.apis:id/drag_dot_1")))
                .moveTo(element(driver.findElementById("io.appium.android.apis:id/drag_dot_3")))
                .release()
                .perform();
    }

    @Test
    void gesturesTest(){
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        TouchAction ta = new TouchAction(driver);
        WebElement expandList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        ta.tap(tapOptions().withElement(element(expandList))).perform();
        ta.tap(tapOptions().withElement(element(driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")")))).perform();
        ta.longPress(LongPressOptions.longPressOptions().withElement(element(driver.findElementByAndroidUIAutomator("text(\"Cat Names\")")))).perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }

    @BeforeMethod
    void openApp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus5");
        dc.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @AfterMethod
    void closeApp(){
        driver.quit();
    }

    @AfterSuite
    void killEmulatorAndStopAppium() throws IOException {
        Runtime.getRuntime().exec("adb -s Nexus5 emu kill");
        service.stop();
    }


}
