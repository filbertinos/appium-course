package com.gridu.appium.BaseChrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
        AndroidDriver <AndroidElement> driver;
//        File file = new File("src");
//        File fs = new File(file,"ApiDemos-debug.apk");
        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setCapability(MobileCapabilityType.DEVICE_NAME,"d32d481");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus5");
        //dc.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        dc.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver <AndroidElement> driver = capabilities();
        driver.get("http://griddynamics.com");
        driver.findElementByClassName("burger").click();
        driver.findElementByXPath("//a[@href='/contact']").click();
        System.out.println(driver.getCurrentUrl());
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,640)","");
        System.out.println(driver.findElementByXPath("//h2[text()='Global Offices']").getAttribute("id").contains("executive-team"));

    }
}
