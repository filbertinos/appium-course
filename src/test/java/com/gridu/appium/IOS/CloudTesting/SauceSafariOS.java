package com.gridu.appium.IOS.CloudTesting;

import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class SauceSafariOS {
    public static final String USERNAME = "Filbertinos";
    public static final String ACCESS_KEY = "c4c16a26-dcf2-4b1a-89f3-b2aa9a36f240";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public WebDriver driver;

    @BeforeSuite
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.iphone();
        caps.setCapability("appiumVersion", "1.9.1");
        caps.setCapability("deviceName","iPhone XR Simulator");
        //caps.setCapability("deviceName","iPhone 6");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("platformVersion","12.0");
        //caps.setCapability("platformVersion","11.4");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("browserName", "Safari");
        //caps.setCapability("app","sauce-storage:myapp.zip");
        driver = new IOSDriver(new URL(URL), caps);
    }
    @Test
    public void navigateToGoogleinCloud(){
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("qwerty");
        driver.findElement(By.className("Tg7LZd")).click();
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
