package com.gittigidiyor.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    By mainBy = By.className("f2lc5a-0");
    By closeCookiesButtonBy = By.className("tyj39b-3.fEwnjq");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHomePageTitle(){
        return webDriver.getTitle();
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainBy));
    }

    public void closeCookiesPopUp(){
        click(closeCookiesButtonBy,10);
    }
}
