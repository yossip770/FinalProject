package utilities;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class helperMethods extends commonOps
{
    public static void takeElementScreenshot(WebElement imageElement, String imageName)
    {
        imageScreenshot = new AShot().takeScreenshot(driver, imageElement);
        try {
            ImageIO.write(imageScreenshot.getImage(), "png", new File(getData("imageRepo") + imageName+ ".png"));
        } catch (Exception e) {
            System.out.println("Error writing image file: " + e);
        }
    }
}
