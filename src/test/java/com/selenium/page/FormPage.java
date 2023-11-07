package com.selenium.page;

import com.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class FormPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement fullName;
    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement phoneNum;
    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement email;
    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement qualification;
    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement passOut;
    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[6]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement location;
    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement date;
    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[8]/div/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement timeSlot;
    @FindBy(xpath = "//span[contains(text(),'Add file')]")
    WebElement addFileButton;
    @FindBy(xpath = "//span[contains(text(),'Browse')]")
    WebElement browseButton;

    public FormPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void applicationPage(String name,String phone,String mail,String education,String passYear,String place,String Date,String slot) throws InterruptedException, IOException {
        BaseClass.sendKeys(fullName, name);
        fullName.sendKeys(name);
        Thread.sleep(300);
        phoneNum.sendKeys(phone);
        Thread.sleep(300);
        email.sendKeys(mail);
        Thread.sleep(300);
        qualification.sendKeys(education);
        Thread.sleep(300);
        passOut.sendKeys(passYear);
        Thread.sleep(300);
        location.sendKeys(place);
        Thread.sleep(300);
        date.sendKeys(Date);
        Thread.sleep(300);
        timeSlot.sendKeys(slot);
        Thread.sleep(300);
        addFileButton.click();
        Thread.sleep(300);
        browseButton.click();
        Thread.sleep(300);
        Runtime.getRuntime().exec("E:\\ApplicationTest-main\\src\\main\\resources\\FileUploadScript.exe");
        Thread.sleep(10000);
    }
}
