package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.get("browser");
        
        String headless = ConfigReader.get("headless");
        int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));

        DriverFactory.initDriver(browser, Boolean.parseBoolean(headless), implicitWait);
        
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
