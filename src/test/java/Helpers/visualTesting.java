package Helpers;

import org.testng.annotations.Test;
import utilities.commonOps;
import utilities.helperMethods;
import workFlow.webFlow;

public class visualTesting extends commonOps
{
    @Test
    public void createScreenshot()
    {
        webFlow.login();
        helperMethods.takeElementScreenshot(headerPage.imgLogo, "orangeHRMLogo");
    }
}
