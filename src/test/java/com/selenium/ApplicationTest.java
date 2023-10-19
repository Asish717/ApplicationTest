package com.selenium;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class ApplicationTest {
    public static WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    @BeforeTest
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://forms.gle/g78zBjUhqTzDYSEg6");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void application() throws IOException {
        File src=new File("E:\\DataDrivenApplicationTask\\src\\main\\resources\\Test data.xlsx");
        FileInputStream input=new FileInputStream(src);
        workbook=new XSSFWorkbook(input);
        sheet=workbook.getSheetAt(0);
        for (int i=1;i<=sheet.getLastRowNum();i++){
            cell=sheet.getRow(i).getCell(1);
            ;
            driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys(cell.getStringCellValue());
            cell=sheet.getRow(i).getCell(2);
            driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys(cell.getStringCellValue());
            cell=sheet.getRow(i).getCell(3);
            driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys(cell.getStringCellValue());
            cell=sheet.getRow(i).getCell(4);
            driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys(cell.getStringCellValue());
            cell=sheet.getRow(i).getCell(5);
            driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys(cell.getStringCellValue());
            cell=sheet.getRow(i).getCell(6);
            driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[6]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys(cell.getStringCellValue());
            cell=sheet.getRow(i).getCell(7);
            driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys(cell.getStringCellValue());
            cell=sheet.getRow(i).getCell(8);
            driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div[1]/div/div[1]/input")).sendKeys(cell.getStringCellValue());

            driver.findElement(By.xpath("//span[contains(text(),'Add file')]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Browse')]")).click();
            Runtime.getRuntime().exec("E:\\DataDrivenApplicationTask\\src\\main\\resources\\FileUploadScript.exe");
        }
    }
}