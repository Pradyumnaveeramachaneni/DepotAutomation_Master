package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver(String browser, boolean headless, int implicitWait) {
        WebDriver webDriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless) options.addArguments("--headless=new");
            options.addArguments("--disable-notifications", "--start-maximized");
            webDriver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            webDriver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        webDriver.manage().window().maximize();
        driver.set(webDriver);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
