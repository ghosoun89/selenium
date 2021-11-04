package com.freecrm.pages;

import com.freecrm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactPage extends TestBase {

    public ContactPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    @FindBy (id="first_name")
    WebElement firstName;
    @FindBy (id="surname")
    WebElement lastName;
    @FindBy (name="client_lookup")
    WebElement company;
    @FindBy (id="department")
    WebElement department;
    @FindBy (xpath="//input[@value='Save']")
    WebElement save;

    public void addNewContact(){
        firstName.sendKeys("Ghosoun");
        lastName.sendKeys("Aldabea");
        company.sendKeys("Amazon");
        department.sendKeys("QA");
        save.click();
    }
}
