package com.tutorialninja.sw5.testsuit;

import com.tutorialninja.sw5.customlisteners.CustomListeners;
import com.tutorialninja.sw5.pages.DesktopPage;
import com.tutorialninja.sw5.pages.Homepage;
import com.tutorialninja.sw5.pages.LaptopsAndNotebooksPage;
import com.tutorialninja.sw5.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LaptopAndNotebooksPageTest extends BaseTest {
    Homepage homePage;
    DesktopPage desktopPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new Homepage();
        desktopPage = new DesktopPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

        String menuName = "Show AllLaptops & Notebooks";
        homePage.mouseHoveOnLaptopAndNotebooks();
        homePage.selectMenu(menuName);

    }

    @Test(groups = {"sanity","smoke","regression"})
    public void atUserPlaceOrderSuccessfully() {
        homePage.mouseHoveOnLaptopAndNotebooks();
        homePage.clickOnShowAllLAPANdNOTe();
        laptopsAndNotebooksPage.ProductMacbook();
        laptopsAndNotebooksPage.verifyTheProductPrice();
        laptopsAndNotebooksPage.ProductMacbook();
        laptopsAndNotebooksPage.VerifyTextMacbook();
        laptopsAndNotebooksPage.clickOnAddToCart();

    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {
        String menuName = "Show AllLaptops & Notebooks";
        homePage.mouseHoveOnLaptopAndNotebooks();
        homePage.selectMenu(menuName);
        laptopsAndNotebooksPage.VerifyTextMacbook();

    }

}

