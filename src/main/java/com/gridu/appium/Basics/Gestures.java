package com.gridu.appium.Basics;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        TouchAction ta = new TouchAction(driver);
        WebElement expandList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        ta.tap(tapOptions().withElement(element(expandList))).perform();
        ta.tap(tapOptions().withElement(element(driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")")))).perform();
        ta.longPress(LongPressOptions.longPressOptions().withElement(element(driver.findElementByAndroidUIAutomator("text(\"Cat Names\")")))).perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());

    }
}
