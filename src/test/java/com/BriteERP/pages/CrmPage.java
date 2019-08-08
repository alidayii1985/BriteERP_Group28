package com.BriteERP.pages;


import com.BriteERP.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CrmPage {

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    public CrmPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(css = "[accesskey=l]")
    public WebElement listMenuButton;

    @FindBy(css = ".o_data_row>td>div>input")
    public WebElement firstCheckbox;


    @FindBy(xpath = "//*[@name='planned_revenue']/input")
    public WebElement formExpectedRevenue;



    @FindBy(xpath = "//*[@aria-label='pivot']")
    public WebElement pivotMenuButton;


    public String getRevenueByRowNumber(int i){
        return Driver.getDriver().findElement(By.xpath("//table//tr["+i+"]//td[2]")).getText();

    }




    @FindBy(xpath = "//*[@class='o_pivot_header_cell_opened']")
    public WebElement pivotMenuTotalOpened;


    @FindBy(xpath = "//*[@class='o_pivot_header_cell_closed']")
    public WebElement pivotMenuTotalClosed;


    @FindBy(xpath = "//a[.='Opportunity']")
    public WebElement pivotMenuOpportunitySelection;

    @FindBy(xpath = "//table//tr//td[2]")
    public List<WebElement> pivotMenuOpportunityTableExpectedRevenueColumn;




    @FindBy(xpath = "//*[contains(text(),'Action')]")
    public WebElement actionButton;

    @FindBy(xpath = "//*[contains(text(),'Delete')]")
    public WebElement actionMenuDelete;

    @FindBy(xpath = "//*[contains(text(),'Ok')]")
    public WebElement deletePopUpOkButton;

    @FindBy(xpath = "//*[contains(text(),'Create')]")
    public WebElement createButton;

    @FindBy(css = "[placeholder='e.g. Product Pricing']")
    public WebElement opportunityTextBox;

    @FindBy(xpath = "//*[contains(text(),'Save')]")
    public WebElement opportunitySaveButton;


    @FindBy(css = ".table-responsive")
    public WebElement listViewTable;



/////////////////Test/////////////


    @FindBy(xpath = "//*[@class='dropdown-toggle btn']")
    public WebElement threePointsMenu;



    @FindBy(xpath = "(//*[@title='Very High'])[2]")
    public WebElement threeStarsSelection;








}

