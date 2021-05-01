package com.gittigidiyor.testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        String baseUrl ="https://www.gittigidiyor.com/";
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log4j.info("Test is starting...");
        webDriver.get(baseUrl);
        webDriver.manage().window().maximize();
        Log4j.info("Opening Page " + baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
        Log4j.info("Test is ending.");
    }
}
