//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.ios.IOSElement;
//import io.appium.java_client.remote.AutomationName;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//public class Uicatlog {
//
//    IOSDriver<IOSElement> driver;
//
//    @Before
//
//    public void setup() throws MalformedURLException {
//
//// TODO Auto-generated method stub
//
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone XR");
//        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"IOS");
//        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//        dc.setCapability(MobileCapabilityType.APP,"/Users/afilippov/work/UICatalog.app");
//        dc.setCapability(MobileCapabilityType.NO_RESET,"true");
//        driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    }
//
////@Test
//
//    public void switches() {
//
//        //driver.scrollTo("Switches").click();
//
//        System.out.println(driver.findElements(By.className("UIASwitch")).get(0).getAttribute("value"));
//
//        driver.findElements(By.className("UIASwitch")).get(0).click();
//
//        System.out.println(driver.findElements(By.className("UIASwitch")).get(0).getAttribute("value"));
//
//    }
//
////@Test
//
//    public void Pickers() {
//
//        // driver.scrollTo("Picker View").click();
//
//        System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(0).getAttribute("value"));
//
//        driver.findElements(By.className("UIAPickerWheel")).get(0).sendKeys("85");
//
//        driver.findElements(By.className("UIAPickerWheel")).get(1).sendKeys("215");
//
//        System.out.println(driver.findElements(By.className("UIAPickerWheel")).get(0).getAttribute("value"));
//
//    }
//
//    @Test
//
//    public void Alerts() {
//
//        //driver.scrollTo("Alert Views").click();
//
//        driver.findElementByName("Simple").click();
//
//        driver.switchTo().alert().accept();
//
//    }
//
//}