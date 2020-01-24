package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import utilities.commonOps;
import utilities.listeners;

import java.util.List;

public class uiActions extends commonOps {
    @Step("Click on element")
    public static void click(WebElement elm)
    {
        if (!getData("platformName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(elm));
        elm.click();
    }
    @Step("Insert text into field")
    public static void updateText(WebElement elm, String value)
    {
        if (!getData("platformName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(elm));
        elm.sendKeys(value);
    }
    @Step("Update DropDown field")
    public static void select(WebElement elm, String value)
    {
        if (!getData("platformName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(elm));
        Select select = new Select(elm);
        select.selectByVisibleText(value);
    }
    @Step("Mouse hover on element and click on last element")
    public static void mouseHoverAndClick(WebElement elm1, WebElement elm2, WebElement elm3)
    {
        if (!getData("platformName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.elementToBeClickable(elm1));
        actions.moveToElement(elm1).moveToElement(elm2).moveToElement(elm3).click().build().perform();
    }

    @Step("Select from Date list")
    public static void selectFromDatePicker(int index)
    {
        addNewTask.lstDatePicker.get(index).click();
        addNewTask.btnSaveDate.click();
   }
}
