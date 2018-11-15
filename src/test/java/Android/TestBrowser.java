package Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBrowser {

    public AndroidDriver<AndroidElement> driver;
    public DesiredCapabilities dc = new DesiredCapabilities();
    AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();


    @BeforeSuite
    void setUp() throws IOException {
        service.start();
        Runtime.getRuntime().exec("/Users/afilippov/Library/Android/sdk/emulator/emulator -avd Nexus5 -netdelay none -netspeed full");
        //dc.setCapability(MobileCapabilityType.DEVICE_NAME,"d32d481");
    }

    @Test
    public void baseBrowser(){
        driver.get("http://griddynamics.com");
        driver.findElementByClassName("burger").click();
        driver.findElementByXPath("//a[@href='/contact']").click();
        System.out.println(driver.getCurrentUrl());
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,640)","");
        System.out.println(driver.findElementByXPath("//h2[text()='Global Offices']").getAttribute("id").contains("executive-team"));
    }

    @BeforeMethod
    void openApp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus5");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
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
