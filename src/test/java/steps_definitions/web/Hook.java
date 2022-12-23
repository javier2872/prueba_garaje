package steps_definitions.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Hook {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver aDriver) {
        driver = aDriver;
    }

    @Before("@WEB")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After("@WEB")
    public void teardown(Scenario aScenario) {
        if (getDriver() != null) {
            if (aScenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                aScenario.attach(screenshot, "image/png", aScenario.getName()); //stick it in the report
            }
            getDriver().quit();
        }
    }

}