package objectPages.toDoList;

import io.appium.java_client.android.AndroidElement;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class main {
    @FindBy(how = How.ID, using = "imgFirstTask")
    public WebElement btnAddFirstTask;

    @FindBy(how = How.ID, using = "ivFAB_AddTask")
    public WebElement btnAddTask;

    @FindBy(how = How.ID, using = "imgFirstTaskByVoice")
    public WebElement btnAddFirstTaskVoice;
}
