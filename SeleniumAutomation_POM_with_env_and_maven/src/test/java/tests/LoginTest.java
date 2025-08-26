package tests;

import base.BaseTest;
import base.DriverFactory;

import java.time.Duration;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {
    	String baseurl= ConfigReader.get("baseUrl");
    	DriverFactory.getDriver().get(baseurl);
    	int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));
    	DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    	String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(username, password);
        
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        System.out.println("Page Title: " + DriverFactory.getDriver().getTitle());
    }
}
