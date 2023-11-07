package com.selenium.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelData {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    String testData="E:\\ApplicationTest-main\\src\\main\\resources\\Test data.xlsx";
    public ReadExcelData() {
        FileInputStream input= null;
        try {
            input = new FileInputStream(testData);
            this.workbook=new XSSFWorkbook(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getData(int row,int column){
        this.sheet=this.workbook.getSheetAt(0);
        DataFormatter formatter=new DataFormatter();
        Cell cell= this.sheet.getRow(row).getCell(column);
        String data=formatter.formatCellValue(cell);
        return data;
    }
    public int getRowCount(){
        int rowNum=this.workbook.getSheetAt(0).getLastRowNum();
        ++rowNum;
        return rowNum;
    }
}