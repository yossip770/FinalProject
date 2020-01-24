package objectPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class addNewUser {
    @FindBy(how = How.ID, using = "btnAdd")
    public WebElement btnAddUser;
    @FindBy(how = How.ID, using = "systemUser_userType")
    public WebElement selectUserRole;
    @FindBy(how = How.ID, using = "systemUser_employeeName_empName")
    public WebElement txtEmployeeName;
    @FindBy(how = How.ID, using = "systemUser_userName")
    public WebElement txtUserName;
    @FindBy(how = How.ID, using = "systemUser_status")
    public WebElement selectStatus;
    @FindBy(how = How.ID, using = "systemUser_password")
    public WebElement txtPassword;
    @FindBy(how = How.ID, using = "systemUser_confirmPassword")
    public WebElement txtConfirmPassword;
    @FindBy(how = How.CSS, using = "input[class='addbutton']")
    public WebElement btnSave;
    @FindBy(how = How.ID, using = "systemUser_password_strength_meter")
    public WebElement alertPassStrength;
}
