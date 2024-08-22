package com.example.autoframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

import java.util.List;

public class ShoppingCartPage extends BasePage{

    @FindBy(xpath = "//div[@data-test='secondary-header']/span[text()='Your Cart']" )
    public WebElement shoppingCartTitle;
    @FindBy(id = "cart_contents_container" )
    public WebElement shoppingCartContainer;
    @FindBy(id = "checkout" )
    public WebElement checkoutButton;
    @FindBy(id = "continue-shopping" )
    public WebElement continueShoppingButton;
    @FindAll({@FindBy(xpath = "//div[@class='cart_item']")})
    public List<WebElement> cartItems;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Method to validate that Shopping cart page is loaded
    public void waitForShoppingCartPageToLoad(){
        assertTrue(isElementDisplayed(shoppingCartTitle), "Your Cart is NOT displayed");
        assertTrue(isElementDisplayed(shoppingCartContainer), "Shopping Cart container is NOT displayed");
        assertTrue(isElementDisplayed(checkoutButton), "Checkout button is NOT displayed");
        assertTrue(isElementDisplayed(continueShoppingButton), "Continue Shopping button is NOT displayed");
    }

    //Method to validate if a product is displayed in the list
    public boolean isProductListed(String productName){
        WebElement productListed = driver.findElement(By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name' and text()='"+productName+"']"));
        return isElementDisplayed(productListed);
    }
}
