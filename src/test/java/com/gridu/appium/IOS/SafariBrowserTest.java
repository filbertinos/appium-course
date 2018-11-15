package com.gridu.appium.IOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SafariBrowserTest {
    IOSDriver driver;
    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"IOS");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone XR");
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        //dc.setCapability(MobileCapabilityType.APP,"/Users/afilippov/work/UICatalog.app");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");
        dc.setCapability(MobileCapabilityType.NO_RESET,"true");
        driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void goToPageAndNavigateToContacts(){
        driver.get("http://griddynamics.com");
        driver.findElementByClassName("burgericon").click();
        driver.findElementByXPath("//*[@href='/contact']").click();
    }

    //@Test
    public void gmailLogin(){
        driver.get("http://gmail.com");
        driver.findElementByName("Email").sendKeys("randomkeys");
        driver.findElementByName("Passwd").sendKeys("randomkeys");
        driver.findElementByName("signIn").click();
    }
}
