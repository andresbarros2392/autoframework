package com.example.autoframework;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import com.example.autoframework.pages.LoginPage;
import com.example.autoframework.pages.ProductsPage;
import com.example.autoframework.pages.ShoppingCartPage;
import com.example.autoframework.tests.BaseTest;

public class ProductsTest extends BaseTest {


	@Test(description="Validate add to cart functionality")
    public void addToCartProductFunctionality() {
		//Initialize Login Page, Inventory page and Shopping Cart page
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        //Login into the app
        loginPage.loginToApp("standard_user", "secret_sauce");
        productsPage.waitForProductsPageToLoad();
        //Set product name to be added
        String productName = "Sauce Labs Backpack";
        //Add product to cart
        productsPage.addProductToCart(productName);
        //Validate that Add To Cart button is no longer visible for the product
        assertTrue(productsPage.isAddToCartButtonHiddenForProduct(productName), "Add to Cart button is not expected for " + productName + " product");
        //Validate that Remove button is visible after adding product
        assertTrue(productsPage.isRemoveButtonDisplayedForProduct(productName), "Remove button should be visible for "+ productName);
        //Validate that red bubble is displayed on the cart icon and it contains text "1"
        assertTrue(productsPage.isElementDisplayed(productsPage.shoppingCartBubble), "Shopping Cart bubble should be visible");
        assertEquals(productsPage.shoppingCartBubble.getText(), "1", "The qty of products in the cart does not match with the qty of products added");
        //Navigate to Shopping cart
        productsPage.clickShoppingCart();
        shoppingCartPage.waitForShoppingCartPageToLoad();
        //Validate that product added is displayed
        assertTrue(shoppingCartPage.isProductListed(productName), productName+" Product was not added to the cart");
        //Validate that cart items qty is equal to 1
        assertEquals(shoppingCartPage.cartItems.size(), 1, "Expected to have 1 item in the shopping cart");
    }

	@Test(description="Validate remove product from cart")
    public void removeProductFunctionality() {
		//Initialize Login Page, Inventory page and Shopping Cart page
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        //Login into the app
        loginPage.loginToApp("standard_user", "secret_sauce");
        productsPage.waitForProductsPageToLoad();
        //Set product name to be added
        String productName = "Sauce Labs Backpack";
        //Add product to cart
        productsPage.addProductToCart(productName);
        //Remove product to cart
        productsPage.removeProductFromCart(productName);
        //Validate that Remove button is no longer visible for the product
        assertTrue(productsPage.isRemoveButtonHiddenForProduct(productName), "Remove button is not expected for " + productName + " product");
        //Validate that Add to cart button is visible after removing product
        assertTrue(productsPage.isAddToCartButtonDisplayedForProduct(productName), "Add to Cart button should be visible after removing for "+ productName);
        //Validate that red bubble is no longer visible for shopping cart
        assertTrue(productsPage.waitForElementToBeHidden(productsPage.shoppingCartBubble), "Shopping Cart bubble should NOT be visible");
        //Readding product to cart to make the test fails
        productsPage.addProductToCart(productName);
        //Navigate to Shopping cart
        productsPage.clickShoppingCart();
        shoppingCartPage.waitForShoppingCartPageToLoad();
        //Validate that the qty of cart items is equal to 0
        assertEquals(shoppingCartPage.cartItems.size(), 0, "No products should be listed in the Shopping Cart");
    }
}
