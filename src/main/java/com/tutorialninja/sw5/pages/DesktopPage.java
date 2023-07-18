package com.tutorialninja.sw5.pages;

import com.tutorialninja.sw5.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    /**
     * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
     * 1.1 Mouse hover on Desktops Tab.and click
     * 1.2 Click on “Show All Desktops”
     * 1.3 Select Sort By position "Name: Z to A"
     * 1.4 Verify the Product will arrange in Descending order.
     */
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement mouseHoverOnDesktop;
   // By mouseHoverOnDesktop = By.linkText("Desktops");
    //By clickOnShowAllDesktop = By.linkText("Show AllDesktops");
    @CacheLookup
    @FindBy(linkText = "Show AllDesktops")
    WebElement clickOnShowAllDesktop;
   // By selectSortByPosition = By.id("//select[@id='input-sort']");
    @CacheLookup
    @FindBy(id = "id(//select[@id='input-sort']")
    WebElement sSBPosition;
    //By verifyProductInDescendingOrder = (By.xpath("//h4/a"));
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement verifyProductInDescendingOrder;

    public void mouseHoverOnDesktop() {
        mouseHoverToElementAndClick(mouseHoverOnDesktop);
    }
    public void clickOnShowAllDesktop() {
        clickOnElement(clickOnShowAllDesktop);
    }
    public void SelectSortByPosition() {
        selectByVisibleTextFromDropDown(sSBPosition, "Name:Z to A");
    }
    public void VerifyProductInDescendingOrder() {
        selectByVisibleTextFromDropDown(verifyProductInDescendingOrder, "Name:Z to A");
    }
    /**
     * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
     * 2.1 Mouse hover on Desktops Tab. and click
     * 2.2 Click on “Show All Desktops”
     * 2.3 Select Sort By position "Name: A to Z"
     * 2.4 Select product “HP LP3065”
     * 2.5 Verify the Text "HP LP3065"
     * 2.6 Select Delivery Date "2022-11-30"
     * <p>
     * 2.7.Enter Qty "1” using Select class.
     * 2.8 Click on “Add to Cart” button
     * 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
     * 2.10 Click on link “shopping cart” display into success message
     * 2.11 Verify the text "Shopping Cart"
     * 2.12 Verify the Product name "HP LP3065"
     * 2.13 Verify the Delivery Date "2022-11-30"
     * 2.14 Verify the Model "Product21"
     * 2.15 Verify the Todat "£74.73"
     */

    By shortPosition = By.xpath("//select[@id='input-sort']");
    By productText = By.xpath("//h1[normalize-space()='HP LP3065']");
    By desktopText = By.xpath("//h2[normalize-space()='Desktops']");
    By calender = By.xpath("//i[@class='fa fa-calendar']");
    By monthYearElement = By.xpath("(//th[@class='picker-switch'])[1]");
    By allDatesElement = By.xpath("//*[@class='datepicker-days']//tbody//tr//td");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By shoppingCartLink = By.xpath("//a[normalize-space()='shopping cart']");
    By successfulText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By next = By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]");


    public List<String> beforeSortDesktopByPositionZtoA() throws InterruptedException {
        Thread.sleep(1000);

        List<WebElement> beforeShortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> beforeShortDesktopValue = new ArrayList<>();
        for (WebElement value : beforeShortValue) {
            beforeShortDesktopValue.add(value.getText());
        }
        Collections.sort(beforeShortDesktopValue, String.CASE_INSENSITIVE_ORDER);// Ascending order

        Collections.reverse(beforeShortDesktopValue); // descending order
        return beforeShortDesktopValue;
    }

    public List<String> afterSortDesktopByPositionZtoA() throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        Thread.sleep(1000);
        // After shorting value
        List<WebElement> afterShortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> afterShortDesktopValue = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value1 : afterShortValue) {
            afterShortDesktopValue.add(value1.getText());
        }
        return afterShortDesktopValue;
    }

    public void selectShortByPositionDropdownValue(String value) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(shortPosition, value);
    }

    public void selectProductFromList(String product) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[normalize-space()='" + product + "']"));
    }

    public String getTextOfProduct() {
        return getTextFromElement(productText);
    }

    public String getSuccessfulText() {
        return getTextFromElement(successfulText);
    }

    public void selectDate(String date, String month, String year) throws InterruptedException {

        clickOnElement(calender);
        while (true) {
            String monthYear = driver.findElement(monthYearElement).getText();
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(next);
            }
        }
        Thread.sleep(1000);
        // Select the date
        List<WebElement> allDates = driver.findElements(allDatesElement);
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
    }

    public void clickOnAddToCart() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(addToCart);
    }

    public void clickOnShoppingCartLink() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(shoppingCartLink);
    }

    public String getDesktopText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(desktopText);
    }

}


