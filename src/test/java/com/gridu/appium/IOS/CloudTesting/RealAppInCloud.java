package com.gridu.appium.IOS.CloudTesting;

import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class RealAppInCloud {
    public static final String USERNAME = "";
    public static final String ACCESS_KEY = "";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public IOSDriver<IOSElement> driver;

    @BeforeSuite
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.iphone();
        caps.setCapability("appiumVersion", "1.9.1");
        caps.setCapability("deviceName","iPhone XR Simulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("platformVersion","12.0");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("browserName", "");
        caps.setCapability("app","sauce-storage:UICatalog.zip");
        driver = new IOSDriver<IOSElement>(new URL(URL), caps);
    }
    @Test
    public void RealAppTesting(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: swipe", scrollObject);
        driver.findElementByAccessibilityId("Steppers").click();
        for(int i = 0; i<=10;i++){
            driver.findElementByAccessibilityId("Increment").click();
        }
        driver.findElementByAccessibilityId("Decrement").click();
        driver.findElementByAccessibilityId("Decrement").click();
        driver.findElementByAccessibilityId("Decrement").click();
        System.out.println("Result must be 7, and it is: "+driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
        driver.navigate().back();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: swipe", scrollObject);
        driver.findElementByAccessibilityId("Picker View").click();
        driver.findElementByName("Green color component value").sendKeys("225");
        driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
        driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("145");
        driver.navigate().back();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: swipe", scrollObject);
        driver.findElementByAccessibilityId("Switches").click();
        driver.findElementsByClassName("XCUIElementTypeSwitch").get(0).click();
        driver.navigate().back();
        driver.findElementByAccessibilityId("Sliders").click();
        driver.findElementByClassName("XCUIElementTypeSlider").sendKeys("1");
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
