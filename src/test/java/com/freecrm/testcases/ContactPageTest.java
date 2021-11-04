package com.freecrm.testcases;

import com.freecrm.base.TestBase;
import com.freecrm.pages.ContactPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactPage contactPage;

    public ContactPageTest() throws IOException {
    }

    @BeforeMethod
    public void login() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.performLogin();
    }

    @Test
    public void addContact() throws IOException {
        homePage.switchToFrame();
        contactPage = homePage.clickOnNewContact();
        contactPage.addNewContact();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
