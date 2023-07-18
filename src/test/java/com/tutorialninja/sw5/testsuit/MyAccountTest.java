package com.tutorialninja.sw5.testsuit;

import com.tutorialninja.sw5.customlisteners.CustomListeners;
import com.tutorialninja.sw5.pages.Homepage;
import com.tutorialninja.sw5.pages.MyAccounts;
import com.tutorialninja.sw5.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class MyAccountTest extends BaseTest {
    Homepage homePage;
    MyAccounts myAccounts;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new Homepage();
        myAccounts = new MyAccounts();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccounts.clickOnMyAccount();
        myAccounts.selectMyAccountOptions("Register");
        myAccounts.VerifyRegister();
    }
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccounts.clickOnMyAccount();
        myAccounts.selectMyAccountOptions("Login");
        myAccounts.enterdetail("Hina","Doshi","hDoshi123@gmail.com","04878484883","hdoshi123","hdoshi123");
    }
}
