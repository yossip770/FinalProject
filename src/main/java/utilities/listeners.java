package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends commonOps implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("--------------Starting test: " + iTestResult.getName() + " ---------------");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("--------------Test passed: "+ iTestResult.getName()+ " ---------------");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("--------------Test: " + iTestResult.getName() + " Failed---------------");
        saveScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("--------------Skipping execution---------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "Page Screen-shot", type = "image/png")
    public byte[] saveScreenshot()
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
