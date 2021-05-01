package com.gittigidiyor.testcase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage{
    private By priceInTheBasketBy = By.className("total-price");
    private By numberOfProductsBy = By.cssSelector("option[value='2']");
    private By totalProductBy = By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-of-type(1)");
    private By deleteProductBy = By.cssSelector("a[title='Sil']");
    private By emptyBasketBy = By.cssSelector(".gg-w-22.gg-d-22.gg-t-21.gg-m-18>:nth-child(1)");

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String priceInTheBasket(){
       return webDriver.findElement(priceInTheBasketBy).getText();
    }

    public void setNumberOfProducts(){
        click(numberOfProductsBy,10);
    }

    public String getTotalProduct(){
        return webDriver.findElement(totalProductBy).getText();
    }

    public void deleteProduct(){
        click(deleteProductBy,10);
    }

    public String isEmpty(){
        return webDriver.findElement(emptyBasketBy).getText();
    }
}
