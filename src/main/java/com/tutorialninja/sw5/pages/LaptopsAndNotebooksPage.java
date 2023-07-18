package com.tutorialninja.sw5.pages;

import com.tutorialninja.sw5.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {


By MacBook =By.xpath("//h1[contains(text(),'MacBook')]");
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement mousMacBookHoverOnDesktop;
//By addtocart =By.xpath("//button[@id='button-cart']");
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addtocart;
//By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;
//By Message = By.("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
   public void verifyTheProductPrice(){
       // Get all the products price and stored into array list
       List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
       List<Double> originalProductsPrice = new ArrayList<>();
       for (WebElement e : products) {
           System.out.println(e.getText());
           String[] arr = e.getText().split("Ex Tax:");
           originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
       }
       System.out.println(originalProductsPrice);
       // Sort By Reverse order
       Collections.sort(originalProductsPrice, Collections.reverseOrder());
       System.out.println(originalProductsPrice);
       //1.3 Select Sort By "Price (High > Low)"
       selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
       // After filter Price (High > Low) Get all the products price and stored into array list
       products = driver.findElements(By.xpath("//p[@class ='price']"));
       ArrayList<Double> afterSortByPrice = new ArrayList<>();
       for (WebElement e : products) {
           String[] arr = e.getText().split("Ex Tax:");
           afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
       }
       System.out.println(afterSortByPrice);
       //1.4 Verify the Product price will arrange in High to Low order.
       Assert.assertEquals(originalProductsPrice,afterSortByPrice,"Product not sorted by price High to Low");
   }
   public void SortByPriceHighToLow(){
       List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
       List<Double> originalProductsPrice = new ArrayList<>();
       for (WebElement e : products) {
           System.out.println(e.getText());
           String[] arr = e.getText().split("Ex Tax:");
           originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
       }
       System.out.println(originalProductsPrice);
       // Sort By Reverse order
       Collections.sort(originalProductsPrice, Collections.reverseOrder());
       System.out.println(originalProductsPrice);
       //1.3 Select Sort By "Price (High > Low)"
       selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
       // After filter Price (High > Low) Get all the products price and stored into array list
       products = driver.findElements(By.xpath("//p[@class ='price']"));
       ArrayList<Double> afterSortByPrice = new ArrayList<>();
       for (WebElement e : products) {
           String[] arr = e.getText().split("Ex Tax:");
           afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
       }
       System.out.println(afterSortByPrice);

       Assert.assertEquals(afterSortByPrice,products,"both prices are not equal");
   }
public void ProductMacbook(){
    clickOnElement(MacBook);
}
public  void clickOnAddToCart(){
       clickOnElement(addtocart);
}
public  void ClickOnShoppingCart(){
       clickOnElement(shoppingCart);
}
public void VerifyTextMacbook(){
    Assert.assertEquals(getTextFromElement(MacBook),"MacBook", "Both text are not equal");
}


}



