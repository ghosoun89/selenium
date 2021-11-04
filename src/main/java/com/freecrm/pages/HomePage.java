package com.freecrm.pages;

import com.freecrm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class HomePage extends TestBase {
    public HomePage () throws IOException {
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath="//a[text()='Contacts']")
    WebElement contacts;
    @FindBy (xpath="//a[text()='Deals']")
    WebElement deals;
    @FindBy (xpath="//a[text()='Tasks']")
    WebElement tasks;
    @FindBy (xpath="//a[text()='New Contact']")
    WebElement addNewContact;
    @FindBy(xpath="//td[text()='Status']")
    WebElement contactStatus;
    @FindBy(xpath="//td[text()='Keyword']")
    WebElement dealsKeyword;
    @FindBy(xpath="//td[text()='Keyword']")
    WebElement tasksKeyword;

    public String getTitle(){
        return driver.getTitle();
    }

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }

    public void clickOnContacts(){
        contacts.click();
    }

    public void clickOnTasks(){
        tasks.click();
    }
    public boolean isContactStatusDisplayed(){
        return contactStatus.isDisplayed();
    }
    public void clickOnDeals(){
        deals.click();
    }
    public boolean isDealsKeywordDisplayed(){
        return dealsKeyword.isDisplayed();
    }

    public boolean isTasksKeywordDisplayed(){
        return tasksKeyword.isDisplayed();
    }

    public ContactPage clickOnNewContact() throws IOException {
        Actions actions = new Actions(driver);
        actions.moveToElement(contacts).build().perform();
        addNewContact.click();
        return new ContactPage();
    }
}
