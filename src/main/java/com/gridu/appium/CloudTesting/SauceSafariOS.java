package com.gridu.appium.CloudTesting;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class SauceSafariOS {
    public static final String USERNAME = "Filbertinos";
    public static final String ACCESS_KEY = "c4c16a26-dcf2-4b1a-89f3-b2aa9a36f240";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = DesiredCapabilities.iphone();
        caps.setCapability("appiumVersion", "1.9.1");
        caps.setCapability("deviceName","iPhone XR Simulator");
        //caps.setCapability("deviceName","iPhone 6");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("platformVersion","12.0");
        //caps.setCapability("platformVersion","11.4");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("browserName", "Safari");
        WebDriver driver = new IOSDriver(new URL(URL), caps);
        driver.get("https://google.com");
        //Thread.sleep(8000L);
        driver.close();
    }
}
