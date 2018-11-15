package com.gridu.appium.Basics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;

public class Mics extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
        driver.findElementByAndroidUIAutomator("text(\"WebView\")").click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        System.out.println(driver.getContext()+" "+driver.getOrientation()+" "+driver.currentActivity());
    }
}
