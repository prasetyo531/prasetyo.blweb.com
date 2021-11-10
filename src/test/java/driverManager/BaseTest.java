package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public WebDriver getDriver(String browser) {
        try {
            switch (browser) {

                case "firefox":
                    // code
                    if (null == driver) {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }
                    break;

                case "chrome":

                    if (null == driver) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("Unable to load browser: " + e.getMessage());
        }
        return driver;
    }

    @AfterTest
    public void quitDriver(){
        this.driver.close();
    }
}
