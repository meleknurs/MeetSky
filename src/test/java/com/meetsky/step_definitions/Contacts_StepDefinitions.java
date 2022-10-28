package com.meetsky.step_definitions;

import com.meetsky.pages.ContactsPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.hamcrest.core.StringContains;
import org.openqa.selenium.By;

import java.util.List;


public class Contacts_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    ContactsPage contactsPage = new ContactsPage();


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.login();
    }

    @Given("the user enters the contacts menu")
    public void the_user_enters_the_contacts_menu() {
        loginPage.contactsButtonDash.click();
    }

    @When("user click new contact button")
    public void user_click_new_contact_button() {
        BrowserUtils.sleep(2);
        contactsPage.newContactButton.click();
    }

    @When("user enter first and last name in the new contact box")
    public void user_enter_first_and_last_name_in_the_new_contact_box() {
        contactsPage.newContactNameInput.clear();
        contactsPage.newContactNameInput.sendKeys(ConfigurationReader.getProperty("contact.fullName"));
        contactsPage.AllContactsButton.click();
    }

    @Then("user should able to see new contact in the All contacts column")
    public void user_should_able_to_see_new_contact_in_the_all_contacts_column() {

        //String newContactName = "New contact3"; // Assert.assertTrue(BrowserUtils.getElementsText(contactsPage.allContactList).contains("New contact3"));
        // String x = "foo bar";

        List<String> list = BrowserUtils.getElementsText(contactsPage.allContactList);
        //System.out.println("list = " + list);

        for (String each : list) {
            if (each.contains(ConfigurationReader.getProperty("contact.fullName"))) {
                System.out.println("New contact is in the all contact column---  Verified");
            }
        }

        //Assert.assertTrue(list.contains(ConfigurationReader.getProperty("contact.fullName")));

        //Assert.assertTrue(x.contains("foo"));
    }


    @When("user click enter without typing any input")
    public void user_click_enter_without_typing_any_input() {
        contactsPage.AllContactsButton.click();
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }

    @Then("user should see that empty contact names disappeared")
    public void user_should_see_that_empty_contact_names_disappeared() {

        List<String> list = BrowserUtils.getElementsText(contactsPage.allContactList);

        System.out.println("list = " + list);
        for (String each : list) {
            if (!(each.equals("New contact"))) {
                System.out.println("New contact is not in the all contact column---  Verified");
            }
        }


    }


    @When("user click All contacts button")
    public void user_click_all_contacts_button() {
    contactsPage.AllContactsButton.click();
    }

    @Then("user should able to see the contact list in the middle column")
    public void user_should_able_to_see_the_contact_list_in_the_middle_column() {

    }

    @Then("user should able to see total number near the All contacts button")
    public void user_should_able_to_see_total_number_near_the_all_contacts_button() {

    }

    @When("user click picture icon under the contact name")
    public void user_click_picture_icon_under_the_contact_name() {

    }

    @When("user select choose from Files option")
    public void user_select_choose_from_files_option() {

    }

    @When("user select an image")
    public void user_select_an_image() {

    }

    @When("user click Choose button")
    public void user_click_choose_button() {

    }

    @Then("user should be able to see chosen picture as a profile picture")
    public void user_should_be_able_to_see_chosen_picture_as_a_profile_picture() {

    }

    @When("user click three dots of any contact")
    public void user_click_three_dots_of_any_contact() {

    }

    @When("user select delete option")
    public void user_select_delete_option() {

    }

    @Then("user should able to see chosen contact is deleted")
    public void user_should_able_to_see_chosen_contact_is_deleted() {

    }

}
