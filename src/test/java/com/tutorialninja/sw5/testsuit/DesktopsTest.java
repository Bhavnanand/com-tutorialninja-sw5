package com.tutorialninja.sw5.testsuit;

import com.tutorialninja.sw5.customlisteners.CustomListeners;
import com.tutorialninja.sw5.pages.DesktopPage;
import com.tutorialninja.sw5.pages.Homepage;
import com.tutorialninja.sw5.pages.ShoppingCartPage;
import com.tutorialninja.sw5.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    Homepage homepage;
    DesktopPage desktopPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() throws InterruptedException {
        homepage = new Homepage();

        desktopPage = new DesktopPage();
        shoppingCartPage = new ShoppingCartPage();
    }

        @Test(groups = {"sanity","regression"})
        public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
            homepage.clickOnCurrencyChange();
            String menuName = "Show AllDesktops";
            homepage.mouseHoverAndClickOnDeskTop();
            homepage.selectMenu(menuName);
            String excepted = desktopPage.beforeSortDesktopByPositionZtoA().toString();
            String actual = desktopPage.afterSortDesktopByPositionZtoA().toString();
            Assert.assertTrue(excepted.contains(actual));
        }
    }
