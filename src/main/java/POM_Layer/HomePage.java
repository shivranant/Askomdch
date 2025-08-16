package POM_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_layer.Base_Class;
import utils_Layer.Wait;


public class HomePage extends Base_Class {
	@FindBy(xpath = "//a[contains(@aria-label,'Blue Shoes')]")
	private WebElement BlueShoesItem;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void addToCart()
	{
		Wait.click(BlueShoesItem);
	}

}
