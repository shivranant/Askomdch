package POM_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_layer.Base_Class;
import utils_Layer.*;

public class Login_Page  extends Base_Class{

    // Constructor to initialize PageFactory
    public Login_Page() {
        PageFactory.initElements(getDriver(), this);
    }

    // WebElements
    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElement signupLoginLink;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailField;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordField;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedInText;

    // Page Actions

    public void clickSignupLoginLink() {
        Action_Utils.click(signupLoginLink);
    }

	/*
	 * public void enterLoginEmail(String email) { loginEmailField.sendKeys(email);
	 * }
	 * 
	 * public void enterLoginPassword(String password) {
	 * loginPasswordField.sendKeys(password); }
	 */
    
    public void enterLoginEmail(String email) {
        Action_Utils.sendKeys(loginEmailField, email);
    }

    public void enterLoginPassword(String password) {
        Action_Utils.sendKeys(loginPasswordField, password);
    }


    public void clickLoginButton() {
        Action_Utils.click(loginButton);
    }

    public boolean isLoginSuccessful() {
        //return loggedInText.isDisplayed();
    	return Action_Utils.isElementVisible(loggedInText);

    }

    public String getLoggedInUserText() {
        return loggedInText.getText();
    }

}
