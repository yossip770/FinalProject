package workFlow;

import extentions.uiActions;
import extentions.verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.commonOps;

public class webFlow extends commonOps {
    @Step("Login OrangeHRM")
    public static void login()
    {
        uiActions.updateText(loginPage.txtUserName, getData("userName"));
        uiActions.updateText(loginPage.txtPassword, getData("password"));
        uiActions.click(loginPage.btnLogin);
        verifications.isElementPresent(headerPage.btnWelcome);
    }

    @Step("Add new system user")
    public static void addNewSystemUser()
    {
        uiActions.mouseHoverAndClick(adminMenu.adminMainDashboard, adminMenu.userManagement, adminMenu.viewSystemUsers);
        uiActions.click(addNewUser.btnAddUser);
        uiActions.select(addNewUser.selectUserRole, getData("employeeRole"));
        uiActions.updateText(addNewUser.txtEmployeeName, getData("employeeName"));
        uiActions.updateText(addNewUser.txtUserName, getData("employeeUserName"));
        uiActions.select(addNewUser.selectStatus, getData("employeeStatus"));
        uiActions.updateText(addNewUser.txtPassword, getData("employeePassword"));
        wait.until(ExpectedConditions.visibilityOf(addNewUser.alertPassStrength));
        uiActions.updateText(addNewUser.txtConfirmPassword, getData("employeePassword"));
        uiActions.click(addNewUser.btnSave);
    }
    @Step("Delete user")
    public static void deleteUsers()
    {
        actions.moveToElement(adminMenu.adminMainDashboard).moveToElement(adminMenu.userManagement).moveToElement(adminMenu.viewSystemUsers).click().build().perform();
        uiActions.updateText(userManagement.searchBox, getData("employeeUserName"));
        uiActions.click(userManagement.btnSearch);
        uiActions.click(userManagement.checkbox);
        uiActions.click(userManagement.btnDelete);
        uiActions.click(userManagement.btnConfirmDelete);
    }
    @Step("Log out")
    public static void logOut()
    {
        uiActions.click(headerPage.btnWelcome);
        uiActions.click(headerPage.btnLogOut);
    }
}
