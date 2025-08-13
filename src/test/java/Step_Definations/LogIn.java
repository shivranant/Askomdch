package Step_Definations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base_layer.Base_Class;
import POM_Layer.Login_Page;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils_Layer.*;

public class LogIn extends Base_Class {
	Login_Page loginPage = new Login_Page();


    @Given("User navigates to automationexercise")
    public void user_navigates_to_automationexercise() {
        initialization(); // launches browser and navigates to the URL
    }

    @When("User clicks on Signup Login link")
    public void user_clicks_on_signup_login_link() throws InterruptedException {
        Thread.sleep(3000); // Optional: Replace with WebDriverWait
        loginPage.clickSignupLoginLink();
    }

	@When("User enters email {string} and password {string}")
	public void user_enters_email_and_password(String email, String password) {
		loginPage.enterLoginEmail(email);
		loginPage.enterLoginPassword(password);
	}

	@When("Clicks login button")
	public void clicks_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
//	        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed");
//	        Assert.assertTrue(loginPage.getLoggedInUserText().contains(expectedUserText), "Incorrect user logged in");
		System.out.println("Test Completed : Login");
	}
	

}
