package Step_Definations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base_layer.Base_Class;
import POM_Layer.Landing_Page;
import POM_Layer.Registration_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils_Layer.*;

public class Registration  extends Base_Class{

	Landing_Page landingPage = new Landing_Page();
    Registration_Page regPage = new Registration_Page();

    @Given("User launches the application")
    public void user_launches_application() {
        initialization();
    }

    @When("User clicks on Signup Login")
    public void user_clicks_signup_login() {
        landingPage.clickSignupLogin();
    }

    @And("User enters name {string} and email {string} for signup")
    public void user_enters_name_and_email(String name, String email) {
        regPage.enterSignupNameEmail(name, email);
    }

    @And("User fills registration details with password {string}, first name {string}, last name {string}, address {string}, state {string}, city {string}, zip {string}, mobile {string}")
    public void user_fills_registration_form(String pass, String fname, String lname, String address,
                                             String state, String city, String zip, String mobile) {
        regPage.fillRegistrationForm(pass, fname, lname, address, state, city, zip, mobile);
    }

    @And("User clicks on Create Account button")
    public void user_clicks_create_account() {
        regPage.clickCreateAccount();
    }

    @Then("Account should be created successfully")
    public void account_should_be_created() {
    	System.out.println("Test Completed : Register");
    }
}
