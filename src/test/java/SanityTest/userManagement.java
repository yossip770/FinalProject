package SanityTest;

import extentions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.commonOps;
import workFlow.webFlow;
@Listeners(utilities.listeners.class)
public class userManagement extends commonOps {

    @Test(description = "Test01 - login to OrangeHRM")
    @Description("Test Description - Login to OrangeHRM web application")
    public void test01_login()
    {
        webFlow.login();
    }

    @Test(description = "Create a new user")
    @Description("Test Description - Create a new user")
    public void test02_createNewUser()
    {
        webFlow.login();
        webFlow.addNewSystemUser();
        verifications.isUserSaved(userManagement.lstUsername, getData("employeeUserName"));
    }
    @Test(description = "Delete user")
    @Description("Test Description - Delete user")
    public void test03_deleteUser()
    {
        webFlow.login();
        webFlow.deleteUsers();
        verifications.isUserDeleted(userManagement.lstUsername, getData("employeeUserName"));
    }

    @Test(description = "Verify logo")
    @Description("Test Description - Verify logo displayed")
    public void test04_verifyOrangeHRMLogo()
    {
        webFlow.login();
        verifications.verifyVisualElement(headerPage.imgLogo, "orangeHRMLogo");
    }

}
