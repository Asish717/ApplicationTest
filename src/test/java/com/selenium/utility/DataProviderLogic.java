package com.selenium.utility;

import org.testng.annotations.DataProvider;

public class DataProviderLogic {
    @DataProvider(name="testData")
    public Object[][] getData(){
        ReadExcelData readExcelData=new ReadExcelData();
        int rows=readExcelData.getRowCount();

        Object[][] details=new Object[rows][8];
        for (int i=0;i<rows;++i){
            for (int j=0;j<2;j++){
                details[i][0]=readExcelData.getData(i,0);
                details[i][1]=readExcelData.getData(i,1);
                details[i][2]=readExcelData.getData(i,2);
                details[i][3]=readExcelData.getData(i,3);
                details[i][4]=readExcelData.getData(i,4);
                details[i][5]=readExcelData.getData(i,5);
                details[i][6]=readExcelData.getData(i,6);
                details[i][7]=readExcelData.getData(i,7);
            }
        }
        return details;
    }
}
