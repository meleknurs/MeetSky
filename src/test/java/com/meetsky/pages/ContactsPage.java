
package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage {

    public ContactsPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id="new-contact-button")
    public WebElement newContactButton;

    @FindBy(id="contact-fullname")
    public WebElement newContactNameInput;

    @FindBy(xpath="//div[@role='listitem']")
    public List<WebElement> allContactList;

    @FindBy(xpath="//span[@title='All contacts']")
    public WebElement AllContactsButton;

    @FindBy(id = "everyone")
    public WebElement AllContactsButtonArea;

    @FindBy(xpath= "//*[@id=\"notgrouped\"]/div/div[1]/div")
    public WebElement AllContactsNumber;


    @FindBy(xpath = "(// button[@type='button'])[9]")
    public WebElement pictureIcon;

    @FindBy(xpath = "//*[.='Choose from Files']")
    public WebElement chooseFromFilesButton;

    @FindBy(xpath = "//*[.='willo']")
    public WebElement image;

    @FindBy(xpath = "(//div[@class='unknown'])[3]")
    public WebElement defaultAvatar;

    @FindBy(xpath = "//button[.='Choose']")
    public WebElement chooseButton;

   @FindBy(xpath ="(//span[@role='img'])[15]" )
    public WebElement threeDotsButton;

   @FindBy(xpath = "(//*[.='Delete'])[5]")
    public WebElement deleteOption;



    







}
