package com.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public void setup(){
//        var options=new ChromeOptions();
//        options.addArguments("'--disable-web-security','--user-data-dir','--allow-running-insecure-content'");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--enable-incognito");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://forms.gle/g78zBjUhqTzDYSEg6");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.findElement(By.id("identifierId")).sendKeys("asishkumar717");
        driver.findElement(By.xpath("//*[text()='Next']")).click();

    }
    /*
    Method used for send text value in webelemwnt
    @param WebElement
    @param Key required text
     */
    public static void sendKeys (WebElement ele, String key) throws InterruptedException {
        try{
            Thread.sleep(1);

        ele.sendKeys(key);
        Thread.sleep(1);
        System.out.println("Added a value in "+ele.getText()+ key);}
        catch (Exception e){
            System.out.println("unable to add value in "+ele.getText()+ key+"Exception =="+e);
        }

    }
}