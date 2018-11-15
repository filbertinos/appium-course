package com.gridu.appium.IOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.net.MalformedURLException;

public class IOSTest extends Base {
    public static void main(String[] args) throws MalformedURLException {
        IOSDriver<IOSElement> driver =  capabilities();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//*[@value='Text Entry']").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("Hello");
        driver.findElementByName("OK").click();

    }
}
