package com.gittigidiyor.testcase;

import com.gittigidiyor.testcase.BaseTest;
import com.gittigidiyor.testcase.Users.User;
import com.gittigidiyor.testcase.pages.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class TestCase extends BaseTest {
    @Test
    public void gittiGidiyorTest() throws InterruptedException {
        String title = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String email = "test7883932@gmail.com";
        String password = "7883932.Ru";

        HomePage homePage = new HomePage(webDriver);
        String webDriverTitle = homePage.getHomePageTitle();

        Log4j.info("Title: " + webDriverTitle);
        assertEquals(webDriverTitle, title);

        Log4j.info("Go to Login Page");
        LoginPage loginPage = homePage.getLoginPage();
        Log4j.info("email: " + email + ", password: " + password);
        User user = new User(email, password);
        loginPage.login(user);
        Log4j.info("Go to Home Page");
        String accountButtonText = homePage.getAccountText();
        Log4j.info("The text written on the My Account button is: " + accountButtonText);
        assertTrue(accountButtonText.contains("Hesabım"));

        Log4j.info("The word 'bilgisayar' is entered in the search box.");
        SearchResultPage searchResultPage = homePage.search("bilgisayar");
        searchResultPage.scrollToPage("7200");
        Log4j.info("The page selected from the search results page opens.");
        searchResultPage.choosePage("2");
        assertTrue(webDriver.getCurrentUrl().contains("2"));

        Log4j.info("Go to Product details page");
        ProductDetailsPage productDetailsPage = searchResultPage.goToProductDetails();

        Log4j.info("Product price information is received.");
        String productPrice = productDetailsPage.productPrice();
        productDetailsPage.scrollToPage("1000");
        Log4j.info("The selected product is added to the basket.");
        productDetailsPage.addToBasket();

        Log4j.info("Go to my cart page.");
        BasketPage basketPage = productDetailsPage.goToBasket();
        Log4j.info("The price on the product page is compared with the price of the product in the basket.");
        assertEquals(productPrice, basketPage.priceInTheBasket());

        Log4j.info("The number of products is increased.");
        basketPage.setNumberOfProducts();
        Thread.sleep(2000);
        assertTrue(basketPage.getTotalProduct().contains("2 Adet"));
        Log4j.info("The product is deleted from the basket.");
        basketPage.deleteProduct();
        Thread.sleep(2000);
        String basketMessage = "Sepetinizde ürün bulunmamaktadır.";
        Log4j.info("Check if the basket is empty");
        assertEquals(basketMessage, basketPage.isEmpty());

    }

}
