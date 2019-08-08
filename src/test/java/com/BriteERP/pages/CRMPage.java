package com.BriteERP.pages;


import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMPage {

    public CRMPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[@class='oe_menu_text'][contains(text(),'CRM')]")
    public WebElement crmLocator;




}



