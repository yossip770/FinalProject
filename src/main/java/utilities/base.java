package utilities;

import objectPages.*;
import objectPages.toDoList.addNewTask;
import objectPages.toDoList.main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.image.BufferedImage;

public class base {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public static Screenshot imageScreenshot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();

    public static LoginPage loginPage;
    public static header headerPage;
    public static adminMenu adminMenu;
    public static addNewUser addNewUser;
    public static userManagement userManagement;

    public static main mainToDoList;
    public static addNewTask addNewTask;
}
