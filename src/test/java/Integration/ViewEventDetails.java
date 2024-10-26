package Integration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        MobileElement event = helper.getElementByXpath(driver,"(//android.widget.RelativeLayout[@resource-id='eu.parent.android.app:id/container'])[3]");
        event.click();
    }

    @Then("Check the details of event is returned successfully")
    public void assertOnEventDetails() {
        //Assert institute graph displayed
        Assert.assertTrue(helper.getElementById(driver,"institute_chart_layout").isDisplayed());
        //Assert room tab displayed
        Assert.assertTrue(helper.getElementById(driver,"room_label_text_view").isDisplayed());
        //Assert groups tab displayed
        Assert.assertTrue(helper.getElementById(driver,"groups_label_text_view").isDisplayed());
        //Assert calendar icon displayed
        Assert.assertTrue(helper.getElementById(driver,"calendar").isDisplayed());
    }
}