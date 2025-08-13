package POM_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_layer.Base_Class;
import utils_Layer.Action_Utils;

public class Registration_Page  extends Base_Class {
	public Registration_Page() {
        PageFactory.initElements(getDriver(), this);
    }

    //Signup name and email
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    // Full registration form
    @FindBy(id = "id_gender1")
    private WebElement genderMr;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement dayDropdown;

    @FindBy(id = "months")
    private WebElement monthDropdown;

    @FindBy(id = "years")
    private WebElement yearDropdown;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zipcode")
    private WebElement zipCode;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    private WebElement accountCreatedText;

    // Methods
	/*
	 * public void enterSignupNameEmail(String name, String email) {
	 * signupName.sendKeys(name); signupEmail.sendKeys(email);
	 * Action_Utils.click(signupButton); }
	 */

    public void enterSignupNameEmail(String name, String email) {
        Action_Utils.sendKeys(signupName, name);
        Action_Utils.sendKeys(signupEmail, email);
        Action_Utils.click(signupButton);
    }

    public void fillRegistrationForm(String pass, String fName, String lName, String addr,
                                     String st, String ct, String zip, String mobile) {
        Action_Utils.click(genderMr);
        password.sendKeys(pass);
        Action_Utils.selectByVisibleText(dayDropdown, "10");
        Action_Utils.selectByVisibleText(monthDropdown, "May");
        Action_Utils.selectByVisibleText(yearDropdown, "1995");

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        address.sendKeys(addr);
        state.sendKeys(st);
        city.sendKeys(ct);
        zipCode.sendKeys(zip);
        mobileNumber.sendKeys(mobile);
    }

    public void clickCreateAccount() {
        Action_Utils.click(createAccountButton);
    }

    public boolean isAccountCreatedVisible() {
        return accountCreatedText.isDisplayed();
    }

}
