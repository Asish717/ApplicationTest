package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Exp {
    public static WebDriver driver;
    @Test
    public void setup() throws IOException {
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://forms.gle/g78zBjUhqTzDYSEg6");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//span[contains(text(),'Add file')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Browse')]")).click();
        Runtime.getRuntime().exec("E:\\DataDrivenApplicationTask\\src\\main\\resources\\FileUploadScript.exe");
    }
}
