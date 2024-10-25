package Integration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        features = {"src/test/resources/features/ViewEventDetails.feature"},
        plugin = {"pretty", "html:target/cucumber-reports"})

public class Runner {
}
