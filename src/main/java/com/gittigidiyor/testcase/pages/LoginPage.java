package com.gittigidiyor.testcase.pages;

import com.gittigidiyor.testcase.Users.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By userNameFieldBy = By.id("L-UserNameField");
    By passwordFieldBy = By.id("L-PasswordField");
    By loginButtonBy = By.id("gg-login-enter");
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage login(User user) {
        sendKeys(userNameFieldBy, user.getEmail());
        sendKeys(passwordFieldBy, user.getPassword());
        click(loginButtonBy, 5);

        HomePage homePage = new HomePage(webDriver);
        homePage.waitForLoad();
        return homePage;
    }

}
