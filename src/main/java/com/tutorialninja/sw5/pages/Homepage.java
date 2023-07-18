package com.tutorialninja.sw5.pages;


import com.tutorialninja.sw5.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class Homepage extends Utility {

   // By desktoplink = By.xpath("//a[text()='Desktops']");
    @CacheLookup
    @FindBy(xpath ="//a[text()='Desktops']")
    WebElement desktoplink;
   // By showAllDesktop = By.xpath("//a[contains(text(),'Show AllDesktops')]");
   @CacheLookup
   @FindBy(xpath ="//a[contains(text(),'Show AllDesktops')]")
   WebElement showAllDesktop;
   // By laptopAndDesktopLink = By.linkText("Laptops & Notebooks");
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndDesktopLink ;
 //   By showAllLaptopsAndNotebooks=By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]");
   // By AllLaptopAndNotebooks=By.linkText("Show AllLaptops & Notebooks");
    @CacheLookup
    @FindBy(linkText ="Show AllLaptops & Notebooks")
    WebElement AllLaptopAndNotebooks;
   // By componentsLink = By.linkText("Components");
    @CacheLookup
    @FindBy(linkText ="Components")
    WebElement componentsLink;
   // By showAllComponent =By.xpath("//h2[contains(text(),'Components')]");
    @CacheLookup
    @FindBy(xpath ="//h2[contains(text(),'Components')]")
    WebElement showAllComponent;
   // By accountLogout = By.xpath("//h1[normalize-space()='Account Logout']");
    @CacheLookup
    @FindBy(xpath ="//h1[normalize-space()='Account Logout']")
    WebElement accountLogout;
   // By myAccount = By.xpath("//h2[normalize-space()='My Account']");
    @CacheLookup
    @FindBy(xpath ="//h2[normalize-space()='My Account']")
    WebElement myAccount;

    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By currencyPound= By.xpath("//button[contains(text(),'£Pound Sterling')]");
    public void selectMenu(String menu) {

            List<WebElement> topMenuList = getListOfElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
            try {
                for (WebElement element : topMenuList) {
                    if (element.getText().equalsIgnoreCase(menu)) {
                        element.click();
                    }
                }
            } catch (StaleElementReferenceException e) {
                topMenuList = getListOfElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
            }
        }


    public void clickOnCurrencyChange(){

        clickOnElement(currency);
        clickOnElement(currencyPound);
    }

    public void mouseHoverAndClickOnDeskTop()  {

        mouseHoverToElementAndClick(desktoplink);
    }

    public void clickOnShowAllDeskTop()  {

        mouseHoverToElementAndClick(showAllDesktop);
    }

    public void mouseHoveOnLaptopAndNotebooks() {
        mouseHoverToElementAndClick(laptopAndDesktopLink);
    }
    public void clickOnShowAllLAPANdNOTe(){
        clickOnElement(AllLaptopAndNotebooks);
    }


    public void verifyTextDestop() {
        String actual = getTextFromElement(desktoplink);
        String expected = "Desktops";
        Assert.assertEquals(actual,"Desktops","Both textare not equal");

    }
    public void PassShowAllComponents(){
        selectMenu("Show All Components");
    }
    public void mousehoveronComponents() {
        mouseHoverToElementAndClick(componentsLink);
    }
    public void verifyComponents(){
        String actual =getTextFromElement(By.xpath("//li[@class='dropdown']//a[text()='Components']"));
        Assert.assertEquals(actual,"Components","Both text are not equal");
    }
    public String getAccountLogoutText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(accountLogout);
    }

    public String getMyAccountText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(myAccount);
    }

}
