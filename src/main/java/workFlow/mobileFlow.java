package workFlow;

import extentions.uiActions;
import extentions.verifications;
import io.qameta.allure.Step;
import objectPages.toDoList.main;
import org.openqa.selenium.By;
import utilities.commonOps;

public class mobileFlow extends commonOps {
    @Step("Create task")
    public static void createTask()
    {

        uiActions.click(mainToDoList.btnAddTask);
        uiActions.updateText(addNewTask.txtTaskName, getData("taskName"));
        //uiActions.updateDateField(addNewTask.btnDatePicker, getData("dueDate"));
        uiActions.click(addNewTask.btnDatePicker);
        uiActions.click(addNewTask.year);
        uiActions.click(addNewTask.listYear.get(Integer.parseInt(getData("yearIndex"))));
        //uiActions.selectFromDatePicker(5);
        uiActions.click(addNewTask.btnSaveTask);
    }
}
