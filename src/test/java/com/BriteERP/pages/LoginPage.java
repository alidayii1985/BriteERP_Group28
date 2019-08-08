package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver = Driver.getDriver();


    public LoginPage(){
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(css = "#login")
    public WebElement userNameElement;

    @FindBy(css = "#password")
    public WebElement passwordElement;

    @FindBy(css = "[type='submit']")
    public WebElement loginButtonElement;

    @FindBy(xpath = "//a[contains(text(),\"Don't have an account?\")]")
    public WebElement dontHaveAnAccountElement;

    @FindBy(xpath = "//a[contains(text(),'Reset Password')]")
    public WebElement resetPasswordElement;











}

