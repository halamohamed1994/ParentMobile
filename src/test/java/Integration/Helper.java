package Integration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Helper {
    public AndroidDriver<MobileElement> launchApp() throws MalformedURLException {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A02");
            capabilities.setCapability("appPackage", "eu.parent.android.app");
            capabilities.setCapability("appActivity", "eu.parent.android.app.DispatchActivity");
            capabilities.setCapability("automationName", "UIAutomator2");
            return new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }
    public void login(String username, String password ,AndroidDriver<MobileElement> driver ){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        MobileElement emailField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_edit_text")));
        emailField.sendKeys(username);
        MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_edit_text")));
        passwordField.sendKeys(password);
        MobileElement login_button = driver.findElement(By.id("login_button"));
        login_button.click();
    }
    public MobileElement getElementById(AndroidDriver<MobileElement> driver , String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return  (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated((By.id(elementName))));
    }
    public MobileElement getElementByXpath(AndroidDriver<MobileElement> driver , String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return  (MobileElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
    }
}
