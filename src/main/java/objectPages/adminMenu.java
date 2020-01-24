package objectPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class adminMenu {
    @FindBy(how = How.XPATH, using = "//div[@class='menu']/ul/li/a/b[text()='Admin']")
    public WebElement adminMainDashboard;
    @FindBy(how = How.ID, using = "menu_admin_UserManagement")
    public WebElement userManagement;
    @FindBy(how = How.ID, using = "menu_admin_viewSystemUsers")
    public WebElement viewSystemUsers;
}
