package com.example.autoframework.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    //Method to validate that Products page is loaded
    public void waitForProductsPageToLoad(){
        assertTrue(isElementDisplayed(appTitle), "App Title is NOT displayed");
        assertTrue(isElementDisplayed(shoppingCart), "Shopping Cart is NOT displayed");
        assertTrue(isElementDisplayed(productsList), "Products list is NOT displayed");
    }
    
    //Method to add a product to the cart
    public void addProductToCart(String productName){
        WebElement productToBeAdded = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Add to cart']"));
        waitForElementToBeVisible(productToBeAdded);
        click(productToBeAdded);
        waitForElementToBeHidden(productToBeAdded);
    }
    
    //Method to validate if Add to cart button is displayed for a product
    public boolean isAddToCartButtonDisplayedForProduct(String productName){
        WebElement addToCartForProduct = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Add to cart']"));
        return isElementDisplayed(addToCartForProduct);
    }
    
    //Method to validate that Add to cart button is hidden for a product
    public boolean isAddToCartButtonHiddenForProduct(String productName){
    	try {
    		WebElement addToCartForProduct = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Add to cart']"));
            return false;
        	} catch (NoSuchElementException e) {
                return true;
            }
    }

  //Method to remove product from a cart
    public void removeProductFromCart(String productName){
        WebElement productToBeRemoved = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Remove']"));
        waitForElementToBeVisible(productToBeRemoved);
        click(productToBeRemoved);
        waitForElementToBeHidden(productToBeRemoved);
    }
    
  //Method to validate if Remove button is displayed for a product
    public boolean isRemoveButtonDisplayedForProduct(String productName){
        WebElement removeButtonForProduct = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Remove']"));
        return isElementDisplayed(removeButtonForProduct);
    }
    
    //Method to validate that Remove button is hidden for a product
    public boolean isRemoveButtonHiddenForProduct(String productName) throws NoSuchElementException{
    	try {
        WebElement removeButtonForProduct = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='"+productName+"']/../../..//button[text()='Remove']"));
        return false;
    	} catch (NoSuchElementException e) {
            return true;
        }
    }

    //Method to click on Shopping Cart icon
    public void clickShoppingCart(){
        click(shoppingCart);
    }
}
