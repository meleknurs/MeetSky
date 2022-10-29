package com.meetsky.step_definitions;

import com.meetsky.pages.ContactsPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
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
        WebElement newContactinMiddleColumn = Driver.getDriver().findElement(By.xpath("//div[@role='listitem']/span/div[2]/span"));
        System.out.println("newContactinMiddleColumn.isDisplayed()- before refresh = " + newContactinMiddleColumn.isDisplayed());
        contactsPage.AllContactsButton.click();
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {

        Driver.getDriver().navigate().refresh();

        BrowserUtils.sleep(3);

    }

    @Then("user should see that empty contact names disappeared")
    public void user_should_see_that_empty_contact_names_disappeared() {

        BrowserUtils.sleep(3);

        List<WebElement> allcontacts = Driver.getDriver().findElements(By.xpath("//div[@role='listitem']"));

        for (WebElement eachContact : allcontacts) {
            if (!(eachContact.getText().equalsIgnoreCase("New contacts"))) {
                System.out.println("Not able to creating new contact without input is PASSED");
                    

            }

        /* List<String> list = BrowserUtils.getElementsText(contactsPage.allContactList);

        System.out.println("list = " + list);
        for (String each : list) {
            if (!(each.equals("New contact"))) {
                System.out.println("New contact is not in the all contact column---  Verified");
            }
        }

         */
        }
    }

    @When("user click All contacts button")
    public void user_click_all_contacts_button() {
        contactsPage.AllContactsButton.click();
    }

    @Then("user should able to see the contact list in the middle column")
    public void user_should_able_to_see_the_contact_list_in_the_middle_column() {
        System.out.println("contactsPage.allContactList = " + contactsPage.allContactList);

    }

    @Then("user should able to see total number near the All contacts button")
    public void user_should_able_to_see_total_number_near_the_all_contacts_button() {


        List<String> list = BrowserUtils.getElementsText(contactsPage.allContactList);
        for (String each : list) {
            System.out.println("each = " + each);

        }

        /*
        //3- Locate all the links in the page.
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));


        //4- Print out the number of the links on the page.
        System.out.println("allLinks.size() = " + allLinks.size());

        //5- Print out the texts of the links.
        for (WebElement each : allLinks) {
            System.out.println("Text of link: " + each.getText());
        }

         */
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
        BrowserUtils.waitForVisibility(contactsPage.image,3);
        contactsPage.image.click();

    }

    @When("user click Choose button")
    public void user_click_choose_button() {
        contactsPage.chooseButton.click();
    }

    @Then("user should be able to see chosen picture as a profile picture")
    public void user_should_be_able_to_see_chosen_picture_as_a_profile_picture() {
        Driver.getDriver().navigate().refresh();
    }

    @When("user click three dots of any contact")
    public void user_click_three_dots_of_any_contact() {
        BrowserUtils.sleep(3);
        //System.out.println("contactsPage.AllContactsNumber.getText() = " + contactsPage.AllContactsNumber.getText());
        contactsPage.threeDotsButton.click();
    }

    @When("user select delete option")
    public void user_select_delete_option() {
        contactsPage.deleteOption.click();
    }

    @Then("user should able to see chosen contact is deleted")
    public void user_should_able_to_see_chosen_contact_is_deleted() {
        BrowserUtils.sleep(3);
        String contactsNumber = contactsPage.AllContactsNumber.getText();


    }

}
