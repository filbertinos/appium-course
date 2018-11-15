package com.gridu.appium.GmailTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
        AndroidDriver <AndroidElement> driver;
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus5");
        //dc.setCapability(MobileCapabilityType.DEVICE_NAME,"d32d481");
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"25");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.google.android.gm");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"ConversationListActivityGmail");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver <AndroidElement> driver = capabilities();
        driver.findElementById("com.google.android.gm:id/welcome_tour_got_it").click();
        driver.findElementById("com.google.android.gm:id/owner").click();
        driver.findElementById("com.google.android.gm:id/action_done").click();
//        driver.findElementById("com.google.android.gm:id/compose_button").click();
//        driver.findElementById("com.google.android.gm:id/to").setValue("example@example.com");
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        driver.findElementById("com.google.android.gm:id/subject").setValue("AppiumTest");
//        driver.findElementById("com.google.android.gm:id/composearea_tap_trap_bottom").setValue("Hello, this is test email from automated appium script");
//        driver.findElementById("com.google.android.gm:id/send").click();
        driver.findElementByXPath("//*[@content-desc='Open navigation drawer']").click();
        driver.findElementByXPath("//*[@text='Sent']").click();
        Point point = driver.findElementsByClassName("android.view.View").get(1).getCenter();
        TouchAction ta = new TouchAction(driver);
        ta.tap(PointOption.point(point.x+400,point.y)).perform();

//        String partialText = "AppiumTest";
//        int size =  driver.findElementsByAndroidUIAutomator("new UiSelector().textContains(\""+partialText+"\")").size();
//        System.out.println(size);
//        if(driver.findElementById("android:id/parentPanel").isDisplayed()){
//            driver.findElementById("android:id/button1").click();
//            driver.findElementById("com.google.android.gm:id/to").sendKeys("afilippov@griddynamics.com");
//            driver.pressKey(new KeyEvent(AndroidKey.BACK));
//            driver.findElementById("com.google.android.gm:id/send").click();
//        }
//        else {
//            System.out.println("All ok");
//        }
    }
}
