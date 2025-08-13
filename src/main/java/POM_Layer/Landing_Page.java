package POM_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_layer.Base_Class;
import utils_Layer.Action_Utils;

public class Landing_Page extends Base_Class {
	public Landing_Page() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li//a[@href='/login']")
    private WebElement signupLoginLink;

    public void clickSignupLogin() {
        Action_Utils.click(signupLoginLink);
    }

}
