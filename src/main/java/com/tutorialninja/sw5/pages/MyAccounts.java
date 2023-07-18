package com.tutorialninja.sw5.pages;

import com.tutorialninja.sw5.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class MyAccounts extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myaccount;
    //By myaccount =By.xpath("//span[contains(text(),'My Account')]");
    public void selectMyAccountOptions(String options)  {
        List<WebElement> option = driver.findElements(By.xpath("//nav[@id='top']"));
        clickOnElement(By.linkText(options));
    }
    public void clickOnMyAccount(){
        clickOnElement(myaccount);
    }
    public void VerifyRegister(){
        String expectedMessage = "Register Account";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        Assert.assertEquals("Register page not displayed", expectedMessage, actualMessage);
    }
    public void enterdetail(String fname,String lname,String email,String mobile,String password,String confirmpass){
        sendTextToElement(By.id("input-firstname"),fname);
        sendTextToElement(By.id("input-lastname"), lname);
        sendTextToElement(By.id("input-email"), email);
        sendTextToElement(By.id("input-telephone"),mobile);
        sendTextToElement(By.id("input-password"),password);
        sendTextToElement(By.id("input-confirm"),confirmpass);

    }


    }


