package com.example.autoframework.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.*;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//div[@class='app_logo' and text()='Swag Labs']" )
    public WebElement appTitle;
    @FindBy(id = "shopping_cart_container" )
    public WebElement shoppingCart;
    @FindBy(xpath = "//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']" )
    public WebElement shoppingCartBubble;
    @FindBy(xpath = "//div[@class='inventory_list']" )
    WebElement productsList;


    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForProductsPageToLoad(){
        assertTrue(isElementDisplayed(appTitle), "App Title is NOT displayed");
        assertTrue(isElementDisplayed(shoppingCart), "Shopping Cart is NOT displayed");
        assertTrue(isElementDisplayed(productsList), "Products list is NOT displayed");
    }

    public void addProductToCart(String productName){
        WebElement productToBeAdded = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Add to cart']"));
        waitForElementToBeVisible(productToBeAdded);
        click(productToBeAdded);
        waitForElementToBeHidden(productToBeAdded);
    }

    public boolean isAddToCartButtonDisplayedForProduct(String productName){
        WebElement addToCartForProduct = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Add to cart']"));
        return isElementDisplayed(addToCartForProduct);
    }

    public void removeProductFromCart(String productName){
        WebElement productToBeRemoved = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Remove']"));
        waitForElementToBeVisible(productToBeRemoved);
        click(productToBeRemoved);
        waitForElementToBeHidden(productToBeRemoved);
    }

    public boolean isRemoveButtonDisplayedForProduct(String productName){
        WebElement removeButtonForProduct = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Remove']"));
        return isElementDisplayed(removeButtonForProduct);
    }

    public void clickShoppingCart(){
        click(shoppingCart);
    }
}
