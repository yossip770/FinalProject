package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.w3c.dom.Document;
import org.testng.annotations.BeforeClass;
import workFlow.webFlow;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class commonOps extends base {
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/dataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("browser type started is not valid");
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeOut")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getData("urlLogin"));
        managePages.init();
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
    }
    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initFirefoxDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("appPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("appActivity"));
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), dc);
        } catch (MalformedURLException e) {
            System.out.println("Cannot connect to android URL, see details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeOut")), TimeUnit.SECONDS);
        managePages.init();
    }
    @BeforeClass
    public static void startSession()
    {
        if (getData("platformName").equalsIgnoreCase("web"))
            initBrowser(getData("browserName"));
      else if(getData("platformName").equalsIgnoreCase("mobile"))
          initMobile();
        else
            throw new RuntimeException("Invalid platform name started");
    }
    @AfterMethod
    public static void startMethod(){
        if(getData("platformName").equalsIgnoreCase("web"))
            webFlow.logOut();
    }
    @AfterClass
    public static void closeSession(){driver.quit();}
}
