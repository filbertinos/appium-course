package com.gridu.appium.Basics;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

import java.net.MalformedURLException;
import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class Swipings extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        TouchAction ta = new TouchAction(driver);
        ta.longPress(LongPressOptions.longPressOptions()
                .withElement(element(driver.findElementByXPath("//*[@content-desc='15']")))
                .withDuration(Duration.ofSeconds(2)))
                .moveTo(element(driver.findElementByXPath("//*[@content-desc='45']")))
                .release()
                .perform();


    }
}
