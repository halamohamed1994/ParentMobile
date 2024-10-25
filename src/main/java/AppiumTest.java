import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class AppiumTest {
    public static void main(String[] args) {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A02");
            capabilities.setCapability("appPackage", "eu.parent.android.app");
            capabilities.setCapability("appActivity", "eu.parent.android.app.DispatchActivity");
            capabilities.setCapability("automationName", "UIAutomator2");

            AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723"), capabilities);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            MobileElement emailField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_edit_text")));

            emailField.sendKeys("democompany@parent.eu");
            MobileElement passwordField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_edit_text")));
            passwordField.sendKeys("P@rent12345678");
            MobileElement login_button = driver.findElement(By.id("login_button"));
            login_button.click();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
