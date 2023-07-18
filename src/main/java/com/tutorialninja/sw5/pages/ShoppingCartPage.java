package com.tutorialninja.sw5.pages;

import com.tutorialninja.sw5.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;
//By shoppingCart =By.xpath("//a[contains(text(),'shopping cart')]");
    public String getShoppingCartText(){
return getTextFromElement(shoppingCart);
    }

}
