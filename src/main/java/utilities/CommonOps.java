package utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflow.ElectronFlow;

import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{


    /*#################################################
    Method Name: getData
    Method Description: This method gets the data from xml configuration file
    Method Parameters: String
    Method Return: String
    #################################################*/
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
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


    /*#################################################
    Method Name: initBrowser
    Method Description: This method initializes the driver according to browser type and other relevant Web methods
    Method Parameters: String
    Method Return: Void
    #################################################*/
    public void initBrowser(String browserType){
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIeDriver();

        else
            throw new RuntimeException("Invalid Browser Type");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait= new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("Url"));
        MangePages.init_nopCommerce();
        action= new Actions(driver);
    }

    /*#################################################
    Method Name: initChromDriver
    Method Description: This method initializes Chrome driver
    Method Parameters: Void
    Method Return: WebDriver
    #################################################*/
    public static WebDriver initChromDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        return driver;
    }

    /*#################################################
    Method Name: initFirefoxDriver
    Method Description: This method initializes Firefox driver
    Method Parameters: Void
    Method Return: WebDriver
    #################################################*/
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        return driver;
    }

    /*#################################################
    Method Name: initIeDriver
    Method Description: This method initializes InternetExplorer driver
    Method Parameters: Void
    Method Return: WebDriver
    #################################################*/
    public static WebDriver initIeDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver= new InternetExplorerDriver();
        return driver;
    }

    /*#################################################
    Method Name: initMobile
    Method Description: This method initializes Mobile driver and other relevant mobile methods
    Method Parameters: Void
    Method Return: Void
    #################################################*/
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage1"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity1"));
        try {
            MobileDriver = new AndroidDriver<>(new URL((getData("AppiumServer"))), dc);
        } catch (Exception e) {
            System.out.println(" Can not connect to appium server, see details" + e);
        }
        MangePages.init_MobileApps();
        MobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait= new WebDriverWait(MobileDriver, Long.parseLong(getData("Timeout")));
        action= new Actions(MobileDriver);
    }

    /*#################################################
    Method Name: initAPI
    Method Description: This method initializes API connection
    Method Parameters: Void
    Method Return: Void
    #################################################*/
    public static void initAPI() {
        RestAssured.baseURI=getData("urlAPI");
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
    }

    /*#################################################
    Method Name: initElectron
    Method Description: This method initializes Electron and other relevant methods
    Method Parameters: Void
    Method Return: Void
    #################################################*/
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("electronDriverPath"));
        ChromeOptions opt= new ChromeOptions();
        opt.setBinary(getData("electronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver=new ChromeDriver(dc);
        MangePages.init_ToDo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait= new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action= new Actions(driver);
    }

    /*#################################################
    Method Name: initDesktop
    Method Description: This method initializes Desktop and other relevant methods
    Method Parameters: Void
    Method Return: Void
    #################################################*/
    public static void initDesktop() {
//        dc.setCapability("app", getData("CalculatorApp"));
//        try{
//            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
//        } catch (Exception e){
//            System.out.println("Can not Connect to Appium Server, See Detailes:" + e);
//        }
//
//        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
//        wait= new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
//        MangePages.initCalculator();
    }

    /*#################################################
    Method Name: StartSession
    Method Description: This method initializes relevant init-method according to platformName case
    Method Parameters: String
    Method Return: Void
    #################################################*/
    @BeforeClass
    @Parameters({"PlatformName"})
    public void StartSession(String PlatformName){
        platform=PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
            else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if(platform.equalsIgnoreCase("api"))
            initAPI();
        else if(platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid platform name");

    softAssert = new SoftAssert();
    screen= new Screen();
  // ManageDB.startConnection(getData("DBURL"),getData("DBUsername"), getData("DBPassword"));
    }

    /*#################################################
    Method Name: CloseSession
    Method Description: This method close the connection/quit driver according to the platform case
    Method Parameters: Void
    Method Return: Void
    #################################################*/
    @AfterClass
    public void CloseSession() {
        //ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile"))
               driver.quit();
           else
                MobileDriver.quit();
        }

    }

    /*#################################################
    Method Name: AfterMethod
    Method Description: This method contains different after test methods according to platform case
    Method Parameters: Void
    Method Return: Void
    #################################################*/
    @AfterMethod
    public void AfterMethod() {
        if (platform.equalsIgnoreCase("electron"))
            ElectronFlow.EmptyList();
        if (platform.equalsIgnoreCase("mobile")) {
            if (MobileDriver.currentActivity().contains("ApiDemos")) {
                MobileDriver.startActivity(getData("AppPackage2"), getData("AppActivity2"));

            }
        }
    }

    /*#################################################
    Method Name: BeforeMethode
    Method Description: This method starts recording using MonteScreenRecorder, unless platform is API
    Method Parameters: Void
    Method Return: Void
    #################################################*/
    @BeforeMethod
    public void BeforeMethode(Method method){
        if (!platform.equalsIgnoreCase("api")){
        try {
            MonteScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}


