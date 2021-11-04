package com.freecrm.pages;

import com.freecrm.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginPage extends TestBase {

    public LoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath="//img[@src='https://classic.freecrm.com/img/logo.png']")
    WebElement logo;
    @FindBy (name="username")
    WebElement loginTextBox;
    @FindBy (name="password")
    WebElement passwordTestBox;
    @FindBy (xpath="//input[@value='Login']")
    WebElement loginButton;

    public String getTitle(){
        String actualTitle = driver.getTitle();
        return  actualTitle;
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public boolean logoIsDisplayed(){
        return logo.isDisplayed();
    }

    public HomePage LoginValidUser(String userName, String password) throws IOException {
        loginTextBox.sendKeys(userName);
        passwordTestBox.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }

    public HomePage performLogin() throws IOException {
        loginTextBox.sendKeys(prop.getProperty("userName"));
        passwordTestBox.sendKeys(prop.getProperty("password"));
        loginButton.click();
        return new HomePage();
    }

}
