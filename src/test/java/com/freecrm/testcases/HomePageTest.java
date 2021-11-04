package com.freecrm.testcases;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest() throws IOException {
    }


    @Test
    public void clickOnContactsTest(){
        homePage.switchToFrame();
        homePage.clickOnContacts();
        boolean actualResult = homePage.isContactStatusDisplayed();
        Assert.assertTrue(actualResult, "The status label is not display");
    }

    @Test
    public void clickOnDealsTest(){
        homePage.switchToFrame();
        homePage.clickOnDeals();
        boolean actualResult = homePage.isDealsKeywordDisplayed();
        Assert.assertTrue(actualResult, "The keyword isn't display");
    }

    @Test
    public void clickOnTasksTest(){
        homePage.switchToFrame();
        homePage.clickOnTasks();
        boolean actualResult = homePage.isTasksKeywordDisplayed();
        Assert.assertTrue(actualResult, "The task keyword isn't display");

    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.performLogin();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
