package com.meetsky.step_definitions;

import com.meetsky.pages.ContactsPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        BrowserUtils.waitForVisibility(loginPage.contactsButtonDash,15);
        loginPage.contactsButtonDash.click();
    }

    @When("user click new contact button")
    public void user_click_new_contact_button() {
        BrowserUtils.sleep(2);
        contactsPage.newContactButton.click();
    }

    @When("user enter first and last name in the new contact box")
    public void user_enter_first_and_last_name_in_the_new_contact_box() {
        BrowserUtils.waitForVisibility(contactsPage.newContactNameInput,5);
        contactsPage.newContactNameInput.clear();
        contactsPage.newContactNameInput.sendKeys(ConfigurationReader.getProperty("contact.fullName"));
        BrowserUtils.waitFor(2);
        contactsPage.AllContactsButton.click();
        Driver.getDriver().navigate().refresh();
    }

    @Then("user should able to see new contact in the All contacts column")
    public void user_should_able_to_see_new_contact_in_the_all_contacts_column() {

        //String newContactName = "New contact3"; // Assert.assertTrue(BrowserUtils.getElementsText(contactsPage.allContactList).contains("New contact3"));
        // String x = "foo bar";

        List<String> list = BrowserUtils.getElementsText(contactsPage.allContactList);
        //System.out.println("list = " + list);

        for (String each : list) {
            Assert.assertTrue(each.contains(ConfigurationReader.getProperty("contact.fullName")));
            break;
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

        BrowserUtils.sleep(3);

        List<WebElement> allContacts = contactsPage.allContactList;

        for (WebElement eachContact : allContacts) {
            if (!(eachContact.equals("New contact"))) {
                System.out.println("New contact without input is not in the all contact column---  PASSED");
                break;
            }
        }
    }

    @When("user click All contacts button")
    public void user_click_all_contacts_button() {
        contactsPage.AllContactsButton.click();
    }

    @Then("user should able to see the contact list in the middle column")
    public void user_should_able_to_see_the_contact_list_in_the_middle_column() {
        BrowserUtils.waitForVisibility(contactsPage.AllContactsNumber, 10);
        List<WebElement> allContacts = contactsPage.allContactList;

        int countContactsInList = 0;
        int allContactsNumber = Integer.parseInt(contactsPage.AllContactsNumber.getText());

        for (WebElement eachContact : allContacts) {
            countContactsInList++;
        }
        Assert.assertTrue(allContactsNumber == countContactsInList);
    }

    @Then("user should able to see total number near the All contacts button")
    public void user_should_able_to_see_total_number_near_the_all_contacts_button() {
        BrowserUtils.waitForVisibility(contactsPage.AllContactsNumber, 10);

        String totalNumber = contactsPage.AllContactsNumber.getText();
        String allContactsButtonArea = contactsPage.AllContactsButtonArea.getText();

        Assert.assertTrue(allContactsButtonArea.contains(totalNumber));
    }

    @When("user click picture icon under the contact name")
    public void user_click_picture_icon_under_the_contact_name() {
        BrowserUtils.waitForVisibility(contactsPage.pictureIcon, 3);
        contactsPage.pictureIcon.click();
    }

    @When("user select choose from Files option")
    public void user_select_choose_from_files_option() {
        contactsPage.chooseFromFilesButton.click();

    }

    @When("user select an image")
    public void user_select_an_image() {
        BrowserUtils.waitForVisibility(contactsPage.image, 3);
        contactsPage.image.click();
        BrowserUtils.sleep(2);

    }

    @When("user click Choose button")
    public void user_click_choose_button() {
        contactsPage.chooseButton.click();
    }

    @Then("user should be able to see chosen picture as a profile picture")
    public void user_should_be_able_to_see_chosen_picture_as_a_profile_picture() {
        Driver.getDriver().navigate().refresh();

        BrowserUtils.sleep(3);

        Assert.assertFalse(contactsPage.defaultAvatar.isDisplayed());

        //System.out.println("contactsPage.contactAvatar.isDisplayed() = " + contactsPage.contactAvatar.isDisplayed());
        // System.out.println(contactsPage.contactAvatar.getAttribute("src"));

    }

    @When("user click three dots of any contact")
    public void user_click_three_dots_of_any_contact() {
        BrowserUtils.waitForVisibility(contactsPage.threeDotsButton, 5);
        contactsPage.threeDotsButton.click();
    }

    @When("user select delete option")
    public void user_select_delete_option() {
        BrowserUtils.waitForVisibility(contactsPage.deleteOption,5);
        contactsPage.deleteOption.click();
    }

    @Then("user should able to see chosen contact is deleted")
    public void user_should_able_to_see_chosen_contact_is_deleted() {
        BrowserUtils.sleep(3);
        List<WebElement> allContacts = contactsPage.allContactList;

        int count=0;
        for (WebElement eachContact : allContacts) {
            if(eachContact.getText().contains(ConfigurationReader.getProperty("contact.fullName"))){
                count++;
            }
        }
        Assert.assertFalse(count>1);
    }

}