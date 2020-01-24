package SanityTest;

import extentions.verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.commonOps;
import workFlow.mobileFlow;
import workFlow.webFlow;

import static utilities.commonOps.getData;
@Listeners(utilities.listeners.class)
public class toDoList extends commonOps {
    @Test(description = "Create a new task")
    @Description("Test Description - Create a new task")
    public void test01_createTask()
    {
        mobileFlow.createTask();
    }
}
