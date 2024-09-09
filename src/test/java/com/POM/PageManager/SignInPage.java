package com.POM.PageManager;

import HelpsPOM.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private String url = "/authentication";
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[@type='submit']");
    public DashboardPage actionsSignIn(String email, String password){
        validateHelper.verifyUrl(url);
        validateHelper.setText(inputEmail,email);
        validateHelper.setText(inputPassword,password);
        validateHelper.clickElement(buttonLogin);
        return new DashboardPage(driver);
    }
}
