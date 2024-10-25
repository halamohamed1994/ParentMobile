package Integration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class ViewEventDetails {
    AndroidDriver<MobileElement> driver ;
    Helper helper = new Helper();
    @Given("ParentAps app is launched")
    public void launchParentApp() throws MalformedURLException {
        driver = helper.launchApp();
    }

    @And("login with user credentials username {string} , password {string}")
    public void loginWithUserCredentials(String username, String password) {
        helper.login(username,password,driver);
    }

    @When("Open event from list of events")
    public void openEvent() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        MobileElement event = (MobileElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.RelativeLayout[@resource-id='eu.parent.android.app:id/container'])[3]")));
        event.click();
    }

    @Then("Check the details of event is returned successfully")
    public void assertOnEventDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
         //Assert institute graph displayed
        MobileElement instituteChartLayout = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("institute_chart_layout"))));
        Assert.assertTrue(instituteChartLayout.isDisplayed());
        //Assert room tab displayed
        MobileElement roomTextView = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("room_label_text_view"))));
        Assert.assertTrue(roomTextView.isDisplayed());
        //Assert groups tab displayed
        MobileElement groupsTextView = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("groups_label_text_view"))));
        Assert.assertTrue(groupsTextView.isDisplayed());
        //Assert calendar icon displayed
        MobileElement calendarIcon = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("calendar"))));
        Assert.assertTrue(calendarIcon.isDisplayed());
    }
    @After
    public void closeWindow(){
        driver.quit();
    }

}