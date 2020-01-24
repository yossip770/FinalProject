package utilities;

import objectPages.*;
import objectPages.toDoList.addNewTask;
import objectPages.toDoList.main;
import org.openqa.selenium.support.PageFactory;

public class managePages extends base{
    public static void init()
    {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        headerPage = PageFactory.initElements(driver, header.class);
        adminMenu = PageFactory.initElements(driver, adminMenu.class);
        addNewUser = PageFactory.initElements(driver, addNewUser.class);
        userManagement = PageFactory.initElements(driver, userManagement.class);
        mainToDoList = PageFactory.initElements(driver, main.class);
        addNewTask = PageFactory.initElements(driver, addNewTask.class);
    }
}
