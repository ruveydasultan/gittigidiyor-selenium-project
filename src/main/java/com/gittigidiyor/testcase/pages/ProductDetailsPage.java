package com.gittigidiyor.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    private By lowProductPriceBy  = By.id("sp-price-lowPrice");
    private By highProductPriceBy = By.id("sp-price-highPrice");
    private By addToBasketButtonBy = By.id("add-to-basket");
    private By goToBasketButtonBy = By.className("robot-header-iconContainer-cart");
    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String productPrice(){
        String productPrice = webDriver.findElement(lowProductPriceBy).getText();
        if (productPrice.isEmpty()) {
            return getText(highProductPriceBy);
        }
        return getText(lowProductPriceBy);
    }

    public void addToBasket(){
        click(addToBasketButtonBy,30);
    }
    public BasketPage goToBasket(){
        click(goToBasketButtonBy,10);
        return new BasketPage(webDriver);
    }
}
