package StepDefinitions;

import POM.DialogContentElements;
import POM.LoginPageElements;
import POM.NavigationBarElements;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BankAccountSteps {

    LoginPageElements lp = new LoginPageElements();
    NavigationBarElements nb = new NavigationBarElements();
    DialogContentElements dc = new DialogContentElements();


    @Given("User is on login page")
    public void user_is_on_login_page() {
        lp.validateUserLoginPage();

    }
    @When("User enter admin credentials")
    public void user_enter_admin_credentials() {
        lp.userEnterAdminCredentials();

    }
    @Then("User should login successfully")
    public void user_should_login_successfully() {
        lp.validateUserSuccessfullyLoggedIn();

    }
    @Then("User click Setup on Navigation Bar")
    public void user_click_setup_on_navigation_bar() {
        nb.setupOnNavigationBar();

    }
    @Then("User click on Parameters under Setup")
    public void user_click_on_parameters_under_setup() {
        nb.clickOnParametersUnderSetup();

    }
    @Then("User click on the Bank Account")
    public void user_click_on_the_bank_account() {
        nb.clickOnTheBankAccount();


    }
    @Then("User click on plus sign to add {string}, {string}, {string} and {string} and click save button")
    public void user_click_on_plus_sign_to_add_and_and_click_save_button(String name, String iban, String currency, String integrationCode) {
        dc.userCreateBankAccount(name, iban, currency, integrationCode);
    }
    @Then("Success create message should be displayed")
    public void success_create_message_should_be_displayed() {
        dc.validateCreateSuccessMessage();

    }
    @Then("User click on plus sign to add same data {string}, {string}, {string} and {string} and click save button")
    public void user_click_on_plus_sign_to_add_same_data_and_and_click_save_button(String name, String iban, String currency, String integrationCode) {
        dc.userCreateBankAccount(name, iban, currency, integrationCode);
    }
    @Then("Unsuccessful message should display")
    public void unsuccessful_message_should_display() {
        dc.validateUnsuccessfulMessage();

    }
    @Then("User search for {string} and click search")
    public void user_search_for_and_click_search(String name) {
        dc.searchNameAndClickSearch(name);
    }

    @Then("User edit current Bank name and change it to {string}")
    public void user_edit_bank_account_and_change_it_to(String newName) {
       dc.editBankAccountName(newName);

    }

    @Then("Success edit message should be displayed")
    public void success_edit_message_should_be_displayed() {
        dc.editSuccessMessage();

    }
    @Then("User search for {string}")
    public void user_search_for(String name) {
        dc.searchNameToDelete(name);

    }
    @Then("User delete Bank Account")
    public void user_delete_bank_account() {
        dc.deleteBankAccountName();

    }
    @Then("Success delete message should be displayed")
    public void success_delete_message_should_be_displayed() {
        dc.deleteSuccessMessage();

    }
    @Then("User search deleted data {string}")
    public void user_search_deleted_data(String name) {
        dc.searchDeletedData(name);

    }
    @Then("User should see no data to display message")
    public void user_should_see_no_data_to_display_message() {
        dc.noDataMessage();

    }

}
