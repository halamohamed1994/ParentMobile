package Integration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class CreateEvent {
    AndroidDriver<MobileElement> driver ;
    Helper helper = new Helper();
    @Given("ParentAps app is launched successfully")
    public void launchParentApp() throws MalformedURLException {
        driver = helper.launchApp();
    }
    @And("login with user credentials username {string} and password {string}")
    public void loginWithUserCredentials (String username, String password){
        helper.login(username,password,driver);
    }
    @When("Select event from list of events")
    public void openEvent () {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        MobileElement event = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("(//android.widget.RelativeLayout[@resource-id='eu.parent.android.app:id/container'])[3]")));
        MobileElement event = helper.getElementByXpath(driver,"(//android.widget.RelativeLayout[@resource-id='eu.parent.android.app:id/container'])[3]");
        event.click();
    }
    @And("Click on calendar icon and click on create event")
    public void clickOnCalendar() {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        MobileElement calendarIcon = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("calendar"))));
        MobileElement calendarIcon = helper.getElementById(driver,"calendar");
        calendarIcon.click();
//        MobileElement addEventButton = driver.findElement(By.id("add_button"));
        MobileElement addEventButton = helper.getElementById(driver,"add_button");
        addEventButton.click();
//        MobileElement createEventButton = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//android.widget.TextView[@resource-id='eu.parent.android.app:id/label' and @text='Create event']")));
        MobileElement createEventButton = helper.getElementByXpath(driver,"//android.widget.TextView[@resource-id='eu.parent.android.app:id/label' and @text='Create event']");
        createEventButton.click();
    }

    @And("Fill all required fields")
    public void fillCreationFields() {

    }

    @Then("Event will be created successfully")
    public void eventWillBeCreatedSuccessfully() {
    }
    @After
    public void closeWindow(){
        driver.quit();
    }
}
