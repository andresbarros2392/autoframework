package com.example.autoframework;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.example.autoframework.pages.LoginPage;
import com.example.autoframework.pages.ProductsPage;
import com.example.autoframework.tests.BaseTest;

public class LoginTest extends BaseTest {



    @Test(description="Validate Success Login")
    public void loginSuccess() {
    	//Initialize Login Page and Inventory page
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        //Login into the app
        loginPage.loginToApp("standard_user", "secret_sauce");
        //Validate the user has logged in correctly
        productsPage.waitForProductsPageToLoad();
    }

    @Test(description="Validate failed Login with wrong username and password")
    public void loginFailedWrongUsernameAndPassword() {
    	//Initialize Login Page
        LoginPage loginPage = new LoginPage(driver);
        //Enter Username and Password and click on Login button
        loginPage.typeUsername("wrongusername");
        loginPage.typePassword("wrongpassword");
        loginPage.clickLoginButton();
        //Validate that error message is displayed
        assertTrue(loginPage.isElementDisplayed(loginPage.wrongLoginError), "Error message is NOT displayed");
    }
}
