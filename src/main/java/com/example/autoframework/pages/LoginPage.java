package com.example.autoframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name" )
    public WebElement usernameInput;
    @FindBy(id = "password" )
    public WebElement passwordInput;
    @FindBy(id = "login-button" )
    public WebElement loginButton;
    @FindBy(xpath = "//*[@data-test='error' and text()='Epic sadface: Username is required']" )
    public WebElement usernameRequiredError;
    @FindBy(xpath = "//*[@data-test='error' and text()='Epic sadface: Password is required']" )
    public WebElement passwordRequiredError;
    @FindBy(xpath = "//*[@data-test='error' and text()='Epic sadface: Username and password do not match any user in this service']" )
    public WebElement wrongLoginError;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Method to enter Username
    public void typeUsername(String username){
        this.enterText(usernameInput, username);
    }

    //Method to enter Password
    public void typePassword(String password){
        this.enterText(passwordInput, password);
    }

    //Method to click on Login button
    public void clickLoginButton(){
        this.click(loginButton);
    }

    //Method to perform login
    public void loginToApp(String username, String password){
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
    }
}
