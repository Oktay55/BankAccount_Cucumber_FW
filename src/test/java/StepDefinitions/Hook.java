package StepDefinitions;

import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hook {

    WebDriver driver = Driver.getDriver();

    @Before
    public void setup() {
        driver.get("https://demo.mersys.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {

            TakesScreenshot screenshot = ((TakesScreenshot) driver); // which driver to get a screenshot

            File srcFile = screenshot.getScreenshotAs(OutputType.FILE); // this is where we decide screenshot file type

            String scenarioName = scenario.getName();

            File destinationFile = new File("target/FailedScreenshots/" + scenarioName + ".png"); // this where we store screenshot

            try {
                FileUtils.copyFile(srcFile, destinationFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        Driver.quiteDriver();
    }

}
