package Integration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

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
        MobileElement event = helper.getElementByXpath(driver,"(//android.widget.RelativeLayout[@resource-id='eu.parent.android.app:id/container'])[3]");
        event.click();
    }
    @And("Click on calendar icon and click on create event")
    public void clickOnCalendar() {
        MobileElement calendarIcon = helper.getElementById(driver,"calendar");
        calendarIcon.click();
        MobileElement addEventButton = helper.getElementById(driver,"add_button");
        addEventButton.click();
        MobileElement createEventButton = helper.getElementByXpath(driver,"//android.widget.TextView[@resource-id='eu.parent.android.app:id/label' and @text='Create event']");
        createEventButton.click();
    }

    @Then("Fill all required fields")
    public void fillCreationFields() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        helper.getElementById(driver,"event_title_edit_text").sendKeys("title test");
        helper.getElementById(driver,"event_desc_edit_text").sendKeys("description test");

        MobileElement searchField = helper.getElementById(driver,"search_edit_text");
        searchField.click();
        searchField.sendKeys("Demo institute");
         driver.hideKeyboard();
         searchField.click();

        MobileElement datePicker = helper.getElementById(driver,"eu.parent.android.app:id/date_click_captor");
        datePicker.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout")));
        MobileElement specificDate = helper.getElementByXpath(driver,"//android.view.View[@content-desc=\"30 October 2024\"]");
        specificDate.click();
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"eu.parent.android.app:id/mdtp_ok\"]")).click();

        MobileElement startTimePicker = helper.getElementById(driver,"start_time_text_view");
        startTimePicker.click();

        helper.getElementByXpath(driver,"//android.widget.LinearLayout[@resource-id=\"eu.parent.android.app:id/mdtp_time_picker_dialog\"]");


        TouchAction action = new TouchAction(driver);

        action.press(PointOption.point(400, 500))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(400, 200))
                .release()
                .perform();

        action.press(PointOption.point(400, 700))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(400, 400))
                .release()
                .perform();
        MobileElement confirmButton = driver.findElement(By.id("eu.parent.android.app:id/mdtp_ok"));
        confirmButton.click();

        MobileElement endTimePicker = helper.getElementById(driver,"end_time_text_view");
        endTimePicker.click();

        helper.getElementByXpath(driver,"//android.widget.LinearLayout[@resource-id=\"eu.parent.android.app:id/mdtp_time_picker_dialog\"]");
        action.press(PointOption.point(300, 500))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(300, 700))
                .release()
                .perform();

        action.press(PointOption.point(300, 700))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(300, 900))
                .release()
                .perform();
        MobileElement endDateConfirmButton = driver.findElement(By.id("eu.parent.android.app:id/mdtp_ok"));
        endDateConfirmButton.click();


        MobileElement addButton = driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(eu.parent.android.app:id/add_button))"
        );
        addButton.click();
    }


}
