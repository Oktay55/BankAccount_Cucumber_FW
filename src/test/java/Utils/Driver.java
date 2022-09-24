package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        // if the driver object is equal to null (there is no active driver instance) then we'll create a new drive
        if(driver == null) { // refresh and restart the driver
            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        return driver;
    }

    public static void quiteDriver() {
        if(driver != null) {
            driver.quit();
            driver = null; // if we don't have this line next scenario will fail
            // after driver.quite we need to set driver object to null
        }
    }
}
