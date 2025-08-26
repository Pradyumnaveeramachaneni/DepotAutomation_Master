package pages;

import base.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

//    @FindBy(id = "username")
//    private WebElement usernameField;
//
//    @FindBy(id = "password")
//    private WebElement passwordField;
//
//    @FindBy(id = "loginBtn")
//    private WebElement loginButton;
	@FindBy(name = "EmailAddress")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@class='login-btn']")
	private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }
}
