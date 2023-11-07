package com.selenium;

import com.selenium.base.BaseClass;
import com.selenium.page.FormPage;
import com.selenium.utility.DataProviderLogic;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApplicationTest extends BaseClass {
    FormPage formPage;
    @BeforeMethod
    public void start(){
        setup();
        formPage=new FormPage(driver);
    }
    @Test(dataProvider = "testData", dataProviderClass = DataProviderLogic.class)
    public void application(String name,String phone,String mail,String education,String passYear,String place,String Date,String slot) throws IOException, InterruptedException {
        formPage.applicationPage(name,phone,mail,education,passYear,place,Date,slot);
    }
    @AfterMethod
    public void end(){
        driver.close();
    }
}