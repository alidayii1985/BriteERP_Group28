package com.BriteERP.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrowserUtils {
    public static String getScreenshot(String name){

        String time= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot=(TakesScreenshot) Driver.getDriver();

        File source= takesScreenshot.getScreenshotAs(OutputType.FILE);

        String target=System.getProperty("user.dir")+"/test-output/Screenshots"+name+time+".png";
        File finalDestination=new File(target);

        try{
            FileUtils.copyFile(source,finalDestination);

        }catch (IOException io){



        }




        return target;
    }

}
