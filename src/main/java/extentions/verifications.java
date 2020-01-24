package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import utilities.commonOps;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static org.testng.Assert.*;

public class verifications extends commonOps {
    @Step("Verify Text in Element is equal to Expected Value")
    public static void textInElement(WebElement element, String expectedValue)
    {
        if (!getData("platformName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), expectedValue);
    }

    @Step("Verify element is display")
    public static void isElementPresent(WebElement elm)
    {
        if (!getData("platformName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(elm));
        assertTrue(elm.isDisplayed());
    }
    @Step("Verify user saved successfully")
    public static void isUserSaved(List<WebElement> elm, String expectedValue)
    {
        if (!getData("platformName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOfAllElements(elm));
        for (WebElement e :
                elm) {
            if (e.getText().equalsIgnoreCase(expectedValue)) {
                assertEquals(e.getText(), expectedValue);
                break;
            }
        }
    }

    @Step("Verify user delete successfully")
    public static void isUserDeleted(List<WebElement> elm, String expectedValue)
    {
        if (!getData("platformName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOfAllElements(elm));
        for (WebElement e :
                elm) {
            if (e.getText().equalsIgnoreCase(expectedValue)) {
                fail("User " + expectedValue + "isn't deleted");
                break;
            }
            else
                assertNotEquals(e.getText(), expectedValue);
        }
    }

    @Step("Verify image elements")
    public static void verifyVisualElement(WebElement imageElement, String expectedImageName)
    {
        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new File(getData("imageRepo")+expectedImageName+".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading image file: " + e);
        }
        Screenshot imageScreenShot = new AShot().takeScreenshot(driver, imageElement);
        BufferedImage actualImage = imageScreenShot.getImage();
        diff = imgDiff.makeDiff(actualImage, expectedImage);
        assertFalse(diff.hasDiff(), "Images aren't the same");
    }
}
