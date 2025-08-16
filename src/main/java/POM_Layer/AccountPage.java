package POM_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_layer.Base_Class;
import utils_Layer.Wait;

public class AccountPage extends Base_Class {
	 public AccountPage() {
	        PageFactory.initElements(getDriver(), this);
	    }
	
	@FindBy(xpath = "//li[@id='menu-item-1237']")
	private WebElement AccountMenuItem;
	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement Regusername;
	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement Regemail;
	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement Regpassword;
	@FindBy(xpath = "//button[@name='register']")
	private WebElement Registerbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement Username;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement Password;
	@FindBy(xpath = "//button[@name='login']")
	private WebElement Loginbutton;

	public void clickAccountMenu() {
        AccountMenuItem.click();
    }
	
	public void New_registration(String username , String password , String Email)
	{
		Wait.sendKeys(Regusername, username);
		Wait.sendKeys(Regemail, Email);
		Wait.sendKeys(Regpassword, password);
		Wait.click(Registerbutton);
	}
	public void Login(String username , String password)
	{
		Wait.sendKeys(Username, username);
		Wait.sendKeys(Password, password);
		Wait.click(Loginbutton);
	}
	

}
