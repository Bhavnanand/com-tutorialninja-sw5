package com.tutorialninja.sw5.testsuit;

import com.tutorialninja.sw5.customlisteners.CustomListeners;
import com.tutorialninja.sw5.pages.Homepage;
import com.tutorialninja.sw5.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class HomePageTest extends BaseTest {
    Homepage  homepage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homepage =new Homepage();
    }
    @Test(groups = {"sanity","regression"})
    public  void verifyPageNavigation(){
        homepage.selectMenu("Computer");

    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homepage.mouseHoverAndClickOnDeskTop();
       // homepage.clickOnShowAlldeskTop();
        homepage.clickOnShowAllDeskTop();
    }
@Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
homepage.mouseHoverAndClickOnDeskTop();
    //2.2 call selectMenu method and pass the menu“Show All Laptops & Notebooks”
   // homepage.selectMenu("Show All Laptops & Notebooks");
}
@Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
//3.1 Mouse hover on “Components” Tab and click
    homepage.mousehoveronComponents();
//3.2 call selectMenu method and pass the menu = “Show All Components”
   homepage.selectMenu("Show All Components)");
        //    3.3 Verify the text ‘Components’
 }
}
