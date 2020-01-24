package objectPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import java.util.List;

public class userManagement {
    @FindBy(how = How.XPATH, using = "//td[@class='left']/a")
    public List<WebElement> lstUsername;
    @FindBy(how = How.CSS, using = "input[class='delete']")
    public WebElement btnDelete;
    @FindBy(how = How.ID, using ="dialogDeleteBtn")
    public WebElement btnConfirmDelete;
    @FindBy(how = How.CSS, using ="input[type='checkbox']")
    public WebElement checkbox;
    @FindBy(how = How.ID, using = "searchSystemUser_userName")
    public WebElement searchBox;
    @FindBy(how = How.ID, using = "searchBtn")
    public WebElement btnSearch;
}
