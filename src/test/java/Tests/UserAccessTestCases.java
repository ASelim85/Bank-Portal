package Tests;

import Pages.RolesAccessPage;
import Pages.UserAccessPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAccessTestCases extends TestBase {


    @Test(priority = 0, enabled = true)
    public void addNewUser() throws InterruptedException {
        RolesAccessTestCases.addNewRole();
        String roleName = RolesAccessPage.getRoleNameText();
//        loginTestCases.LoginWithValidCredentials();
        UserAccessPage.clickUserAccess();
        UserAccessPage.clickUsers();
        Assert.assertEquals(UserAccessPage.getUsersTextTitle(), "Users");
        UserAccessPage.clickAddNewUser();
        UserAccessPage.fillUserName();
        UserAccessPage.selectRole();
        UserAccessPage.fillFirstNameField();
        UserAccessPage.fillLastNameField();
        UserAccessPage.fillEmailField();
        UserAccessPage.fillNIDField();
        UserAccessPage.fillNIDExpiryDate();
        UserAccessPage.selectGender();
        UserAccessPage.selectBirthDate();
        UserAccessPage.fillMobNum();
        UserAccessPage.selectGovernorate();
        UserAccessPage.selectCity();
        UserAccessPage.fillAddress();
        UserAccessPage.clickSubmit();
        Assert.assertEquals(UserAccessPage.getNotificationMsg(), "User added successfully");
        Assert.assertEquals(UserAccessPage.getNotificationDesc(),"An email was sent to aselim@axisapp.com");
    }
}