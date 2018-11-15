package com.gridu.appium.IOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;
import java.util.HashMap;

public class ScrollingIOS extends Base {
    public static void main(String[] args) throws MalformedURLException {
        IOSDriver<IOSElement> driver = capabilities();
/*        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.60);
        int endy = (int) (size.getHeight() * 0.10);
        driver.swipe(x, starty, x, endy);*/
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
}
