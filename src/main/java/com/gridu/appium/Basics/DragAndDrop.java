package com.gridu.appium.Basics;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDrop extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
        TouchAction ta = new TouchAction(driver);
        ta.longPress(element(driver.findElementById("io.appium.android.apis:id/drag_dot_1")))
                .moveTo(element(driver.findElementById("io.appium.android.apis:id/drag_dot_3")))
                .release()
                .perform();
    }
}
