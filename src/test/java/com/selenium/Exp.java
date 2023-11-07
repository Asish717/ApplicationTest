package com.selenium;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Exp {
    public static WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    @Test
    public void setup() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        String testData="E:\\ApplicationTest-main\\src\\main\\resources\\Test.xlsx";
//        FileInputStream input= new FileInputStream(testData);
//        workbook= new XSSFWorkbook(input);
//        sheet=workbook.getSheet("Sheet1");
//        Object[][] object=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//        for (int i=0;i<sheet.getLastRowNum();i++){
//            for (int j=0;j<sheet.getRow(0).getLastCellNum();j++){
//                object[i][j]=sheet.getRow(i+1).getCell(j).toString();
//                driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
//            }
//        }


        File src = new File("E:\\ApplicationTest-main\\src\\main\\resources\\Test.xlsx");
        FileInputStream input = new FileInputStream(src);
        workbook = new XSSFWorkbook(input);
        sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            cell = sheet.getRow(i).getCell(1);
            DataFormatter formatter = new DataFormatter();
            formatter.formatCellValue(cell);
            String data = cell.getStringCellValue();
            driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
            cell = sheet.getRow(i).getCell(2);
            String data2 = cell.getStringCellValue();
            driver.findElement(By.id("pass")).sendKeys(cell.getStringCellValue());
            driver.findElement(By.id("loginbutton")).click();

        }
    }
//    @DataProvider(name="testdata")
//    public void getString(){
//
//    }
}
