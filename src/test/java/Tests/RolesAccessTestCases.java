package Tests;

import Pages.RolesAccessPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RolesAccessTestCases extends TestBase {

    @Test(priority = 0, enabled = true)
    public static void addNewRole() throws InterruptedException {
        loginTestCases.LoginWithValidCredentials();
        RolesAccessPage.clickUserAccess();
        RolesAccessPage.clickRoles();
        Assert.assertEquals(RolesAccessPage.getRolesTextTitle(), "Roles");
        RolesAccessPage.clickAddNewRole();
        RolesAccessPage.fillRoleNameEN();
        RolesAccessPage.fillRoleNameAR();
        RolesAccessPage.selectDashboard();
        RolesAccessPage.selectMoneyPool();
        RolesAccessPage.selectKYCS();
        RolesAccessPage.selectWallets();
        RolesAccessPage.selectUserAccess();
        RolesAccessPage.selectReports();
        RolesAccessPage.selectSMEs();
        RolesAccessPage.clickSubmitBtn();
        Assert.assertEquals(RolesAccessPage.getRolesDetailsTextTitle(), "Role Details");



    }
}