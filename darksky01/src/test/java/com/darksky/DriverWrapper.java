package com.darksky;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverWrapper {
	public static WebDriver driver = null;
    private static String url = "https://www.darksky.com";

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void initializeWebDriver() {
        //set chromedriver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        //Initialize webdriver interface
        driver = new ChromeDriver();
        //1. Goto Facebook homepage
        driver.navigate().to(url);
    }

    @AfterClass
    public void tearDown() {
        //quit the selenium driver
        driver.quit();
    }

}