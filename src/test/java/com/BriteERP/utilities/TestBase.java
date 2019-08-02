package com.BriteERP.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;


    protected static ExtentReports report;
    private static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;



    @BeforeMethod
    public void setUpMethod(){

        driver=Driver.getDriver();



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);


    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {

        if(result.getStatus()==ITestResult.FAILURE){
            String screenshotLocation=BrowserUtils.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());
        }
        else if (result.getStatus()==ITestResult.SKIP){
            extentLogger.skip("Test Case Skipped: "+result.getName());

        }

        Driver.closeDriver();



    }


    @BeforeTest
    public void setUpTest(){
        report =new ExtentReports();

        String filePath=System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(filePath);

        report.attachReporter(htmlReporter);

        report.setSystemInfo("Browser",ConfigurationReader.getProperty("browser"));
        report.setSystemInfo("QA Engineer","Group28");


        htmlReporter.config().setDocumentTitle("Brite ERP Reports");


    }



    @AfterTest
    public void endReport() {
        report.flush();
    }


}

