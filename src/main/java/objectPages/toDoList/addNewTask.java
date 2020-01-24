package objectPages.toDoList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class addNewTask {
    @FindBy(how = How.ID, using = "edtTaskName")
    public WebElement txtTaskName;

    @FindBy(how = How.ID, using = "edtDueD")
    public WebElement btnDatePicker;

    @FindBy(how = How.ID, using = "day_picker_view_pager")
    public List<WebElement> lstDatePicker;

    @FindBy(how = How.ID, using = "button1")
    public WebElement btnSaveDate;

    @FindBy(how = How.ID, using = "date_picker_header_year")
    public WebElement year;

    @FindBy(how = How.ID, using = "text1")
    public List<WebElement> listYear;

    @FindBy(how = How.ID, using = "action_save_task")
    public WebElement btnSaveTask;
}
