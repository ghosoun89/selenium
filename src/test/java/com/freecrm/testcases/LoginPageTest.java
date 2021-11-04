package com.freecrm.testcases;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginPageTest extends TestBase {
    public LoginPageTest() throws IOException {
        super();
    }
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void titleTest(){
        String expectedResults= "CRMPRO - CRM software for customer relationship management, sales, and support.";
        String actualResult = loginPage.getTitle();
        Assert.assertEquals(actualResult, expectedResults, "the title isn't correct");
    }

    @Test
    public void urlCheck(){
        String expectedResult= "https://classic.crmpro.com/index.html";
        String actualResult = loginPage.getURL();
        Assert.assertEquals(actualResult, expectedResult, "The URL isn't correct");
    }

    @Test
    public void logoTest(){
        boolean actualResult = loginPage.logoIsDisplayed();
        Assert.assertTrue(actualResult, "The logo isn't display");
    }

    @Test
    public void loginTest() throws IOException {
    homePage = loginPage.performLogin();
    String actualResult = "CRMPRO";
    String expectedResult = homePage.getTitle();
    Assert.assertEquals(actualResult, expectedResult, "Username or password is wrong");

    }
    @Test(dataProvider = "myData")
    public void loginUseDataProviderTest(String userName, String password) throws IOException {
        homePage = loginPage.LoginValidUser(userName, password);
        String actualResult = "CRMPRO";
        String expectedResult = homePage.getTitle();
        Assert.assertEquals(actualResult, expectedResult, "Username or password is wrong");

    }
    @DataProvider
    public Object[][] myData(){
        Object[][] data = new Object[4][2];
        data[0][0]="QA_test";
        data[0][1]="Test@123";
        data[1][0]="QA_test";
        data[1][1]="Test123";
        data[2][0]="Qa";
        data[2][1]="Test@123";
        data[3][0]="QA";
        data[3][1]="Test123";
        return data;
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
