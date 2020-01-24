package objectPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class header {
    @FindBy(how = How.ID, using = "welcome")
    public WebElement btnWelcome;
    @FindBy(how = How.CSS, using = "li>a[href='/index.php/auth/logout']")
    public WebElement btnLogOut;
    @FindBy(how = How.CSS, using = "img[src='/webres_5df488ddad8b23.30204013/themes/default/images/logo.png']")
    public WebElement imgLogo;
}
