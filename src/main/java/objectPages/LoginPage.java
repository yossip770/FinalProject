package objectPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.ID, using = "txtUsername")
    public WebElement txtUserName;
    @FindBy(how = How.ID, using = "txtPassword")
    public WebElement txtPassword;
    @FindBy(how = How.ID, using = "btnLogin")
    public WebElement btnLogin;
    @FindBy(how = How.CSS, using = "div[id=forgotPasswordLink]>a")
    public WebElement btnForgetPassword;
}
