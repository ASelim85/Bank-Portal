package Tests;

import Pages.DashboardPage;
import Pages.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("Regression Tests")
@Feature("Login Tests")
public class loginTestCases extends TestBase {
    static String Username = "Bankuser";
    static String Password = "P@ssw0rd";
    static int otp = 245345;
    @Description("Test Description: Login test with valid username and valid password.")
    @Test(priority = 0, enabled = true)
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid username and password login test")
    public static void LoginWithValidCredentials(){
        LoginPage.setUsername(Username);
        LoginPage.setPassword(Password);
        LoginPage.clickSignIn();
        LoginPage.setOTP(String.valueOf(otp));
        LoginPage.clickVerifyOTP();
        Assert.assertTrue(DashboardPage.isDashboardDisplayed());
        Assert.assertEquals(DashboardPage.getDashBoardText(), "Dashboard");
    }
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Test(priority = 1, enabled = true)
    public void LoginWithInValidCredentials() {
        LoginPage.setUsername(Username);
        LoginPage.setPassword("P@ssw0rd1");
        LoginPage.clickSignIn();
        LoginPage.GetErrorMSG();
        Assert.assertEquals(LoginPage.GetErrorMSG(), "Invalid Login");
    }
}