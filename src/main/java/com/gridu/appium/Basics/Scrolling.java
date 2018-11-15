package com.gridu.appium.Basics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class Scrolling extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
       driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
       driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"))");
       //driver.findElementByAndroidUIAutomator("text(\"Radio Group\")").click();

    }
}
