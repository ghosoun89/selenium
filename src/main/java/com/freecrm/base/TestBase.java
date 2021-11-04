package com.freecrm.base;

import com.freecrm.pages.LoginPage;
import com.freecrm.util.WebdriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
//    public LoginPage loginPage;

    // to connect the test base with webDriverListener class
    public static EventFiringWebDriver e_driver;
    public static WebdriverListener webdriverListener;

    public TestBase() throws IOException {
       prop = new Properties();
        FileInputStream file = new FileInputStream("/home/test/Desktop/udemyCamp/src/main/java/com/freecrm/config/config.properties");
        prop.load(file);

    }

     public static void initialization(){
         System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
         driver = new ChromeDriver();
         // connecting the listener to e_driver
         e_driver = new EventFiringWebDriver(driver);
         webdriverListener = new WebdriverListener();
         e_driver.register(webdriverListener);
         driver = e_driver;

         driver.get(prop.getProperty("URL"));
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

}
