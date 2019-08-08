package com.BriteERP.tests.components.crm;

import com.BriteERP.utilities.BrowserUtils;
import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.Driver;
import com.BriteERP.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.*;

public class OpportunityFunctionality extends TestBase {

    @Test
    public void createOpportunityPreCondition(){
        //Pre condition: At least one opportunity created before test
        //

        extentLogger=report.createTest("Create Opportunity");

        extentLogger.info("Open URL");

        pages.login().open();

        pages.login().signInButton.click();

        pages.login().login(ConfigurationReader.getProperty("usernameCRM"),
                ConfigurationReader.getProperty("passwordCRM"));
        BrowserUtils.waitPlease(3);


        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().crmTab));
        extentLogger.info("Click on CRM Tab");
        pages.homePage().crmTab.click();

        wait.until(ExpectedConditions.elementToBeClickable(pages.crmPage().listMenuButton));
        extentLogger.info("Click on List Menu Button");
        pages.crmPage().listMenuButton.click();


        BrowserUtils.waitPlease(2);
        int numOfOpportunityAdded=5;
        for(int i=1;i<=numOfOpportunityAdded;i++)
        {
            pages.crmPage().createButton.click();

            wait.until(ExpectedConditions.visibilityOf(pages.crmPage().opportunityTextBox));
            pages.crmPage().opportunityTextBox.sendKeys("product" + i);
            Random rand = new Random(); int random = rand.nextInt(10)*1000;
            pages.crmPage().formExpectedRevenue.click();

            pages.crmPage().formExpectedRevenue.clear();
            pages.crmPage().formExpectedRevenue.sendKeys(""+random);


            pages.crmPage().opportunitySaveButton.click();
            BrowserUtils.waitPlease(2);
        }
        extentLogger.pass(numOfOpportunityAdded+" Opportunity Created");

    }

    @Ignore
    @Test
    public void wipTest(){

        extentLogger=report.createTest("Try");

        extentLogger.info("Open URL");

        pages.login().open();

        pages.login().signInButton.click();

        pages.login().login(ConfigurationReader.getProperty("usernameCRM"),
                ConfigurationReader.getProperty("passwordCRM"));
        BrowserUtils.waitPlease(3);


        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().crmTab));
        extentLogger.info("Click on CRM Tab");
        pages.homePage().crmTab.click();


        actions.moveToElement(pages.crmPage().threePointsMenu).perform();
        wait.until(ExpectedConditions.visibilityOf(pages.crmPage().threePointsMenu));
        pages.crmPage().threePointsMenu.click();

        pages.crmPage().createButton.click();
        BrowserUtils.waitPlease(2);
        pages.crmPage().threeStarsSelection.click();



        extentLogger.pass(" Opportunity Created");

    }



    @Test
    public void deleteOpportunityTest(){

        //User Story :
        //As a user, when I already created an opportunity in CRM module of Bribe ERP application, I want to be able to delete it.

        //Acceptance Criteria :
        //Verify that user should be able to see the list view.
        //Verify that user should be able to delete the opportunity from action drop down list .


        extentLogger=report.createTest("Delete Opportunity Test");

        extentLogger.info("Open URL");
        pages.login().open();

        extentLogger.info("Click on Sign in Button");
        pages.login().signInButton.click();

        extentLogger.info("Login by CRM Manager credentials");
        pages.login().login(ConfigurationReader.getProperty("usernameCRM"),
                ConfigurationReader.getProperty("passwordCRM"));
        BrowserUtils.waitPlease(3);


        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().crmTab));
        extentLogger.info("Click on CRM Tab");
        pages.homePage().crmTab.click();

        wait.until(ExpectedConditions.elementToBeClickable(pages.crmPage().listMenuButton));
        extentLogger.info("Click on List Menu Button");
        pages.crmPage().listMenuButton.click();

        extentLogger.info("Verify List View is displayed");
        BrowserUtils.waitPlease(1);
        Assert.assertTrue(pages.crmPage().listViewTable.isDisplayed());

        int countOfCheckBoxBeforeDelete= Driver.getDriver().findElements(By.cssSelector(".o_data_row>td>div>input")).size();

        extentLogger.info("Click on first Opportunity checkbox");
        wait.until(ExpectedConditions.elementToBeClickable(pages.crmPage().firstCheckbox));
        pages.crmPage().firstCheckbox.click();

        extentLogger.info("Click on Action Button");
        wait.until(ExpectedConditions.visibilityOf(pages.crmPage().actionButton));
        pages.crmPage().actionButton.click();


        extentLogger.info("Click on Delete Option");
        wait.until(ExpectedConditions.visibilityOf(pages.crmPage().actionMenuDelete));
        pages.crmPage().actionMenuDelete.click();

        extentLogger.info("Click on OK to Delete");
        wait.until(ExpectedConditions.visibilityOf(pages.crmPage().deletePopUpOkButton));
        pages.crmPage().deletePopUpOkButton.click();

        BrowserUtils.waitPlease(2);
        extentLogger.info("Verify Opportunity Deleted");
        int countOfCheckBoxAfterDelete= Driver.getDriver().findElements(By.cssSelector(".o_data_row>td>div>input")).size();

        //System.out.println("Before "+countOfCheckBoxBeforeDelete+" After "+countOfCheckBoxAfterDelete);

        Assert.assertTrue(countOfCheckBoxAfterDelete==countOfCheckBoxBeforeDelete-1);


        extentLogger.pass("Pass-Delete Opportunity Test");
    }


    @Test
    public void totalExpectedRevenueTest(){

        //User story: The system should display the correct information for each opportunity on the view list page and the pivot table.
        //Acceptance Criteria: 2. Verify that on the pivot table, the total expected revenue should be the sumof all opportunities’ expected revenue.
        //Pre-condition one: each CRM manager user should create at least 3 opportunities on the CRM module.
        //Pre-condition two: on Pivot table expand totaland select opportunity from the dropdown.



        extentLogger=report.createTest("Total Expected Revenue Test");

        extentLogger.info("Open URL");
        pages.login().open();

        extentLogger.info("Click on Sign in Button");
        pages.login().signInButton.click();

        extentLogger.info("Login by CRM Manager credentials");
        pages.login().login(ConfigurationReader.getProperty("usernameCRM"),
                ConfigurationReader.getProperty("passwordCRM"));
        BrowserUtils.waitPlease(3);


        wait.until(ExpectedConditions.elementToBeClickable(pages.homePage().crmTab));
        extentLogger.info("Click on CRM Tab");
        pages.homePage().crmTab.click();

        wait.until(ExpectedConditions.elementToBeClickable(pages.crmPage().pivotMenuButton));
        extentLogger.info("Click on Pivot Menu Button");
        pages.crmPage().pivotMenuButton.click();
        extentLogger.info("Click on Total Button to select Opportunity");
        pages.crmPage().pivotMenuTotalOpened.click();

        pages.crmPage().pivotMenuTotalClosed.click();

        extentLogger.info("Click on Opportunity");
        pages.crmPage().pivotMenuOpportunitySelection.click();

        BrowserUtils.waitPlease(5);



        double expectedTotal=0;

        for(int i=2;i<=pages.crmPage().pivotMenuOpportunityTableExpectedRevenueColumn.size();i++)
        {
            String revenue= pages.crmPage().getRevenueByRowNumber(i);
            double rev=Double.parseDouble(revenue.substring(0,revenue.length()-1).replaceAll(",",""));
            expectedTotal+=rev;
        }
        String totalRevenue=pages.crmPage().getRevenueByRowNumber(1);
        double actualTotal=Double.parseDouble(totalRevenue.substring(0,totalRevenue.length()-1).replaceAll(",",""));



        extentLogger.info("Verify Total Revenue is Equal to Sum of Revenues");
        Assert.assertEquals(actualTotal,expectedTotal);
        extentLogger.pass("Pass-Opportunity Expected Revenue Total Test");
    }


}
