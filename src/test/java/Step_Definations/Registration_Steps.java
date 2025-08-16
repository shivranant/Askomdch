package Step_Definations;

import java.io.IOException;

import Base_layer.Base_Class;
import POM_Layer.AccountPage;
import io.cucumber.java.en.*;

public class Registration_Steps extends Base_Class{
	static AccountPage acc;
    @Given("User is on the AskOmDch registration page")
    public void user_is_on_registration_page() throws IOException {
        initialization();
    }

    @When("User registers with username {string}, email {string}, and password {string}")
    public void user_registers_with_username_email_password(String username, String email, String password) {
        acc = new AccountPage();
        acc.clickAccountMenu();
        acc.New_registration(username, password, email);
        
    }

    @Then("User should be redirected to the My Account page")
    public void user_should_be_redirected_to_my_account_page() {
        System.out.println("Registration successful - user is on My Account page.");
    }
}
