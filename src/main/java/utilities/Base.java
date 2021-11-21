package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {

    //General

    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

//Web or WindowsDriver
    protected static WebDriver driver;

    //Mobile
protected  static AndroidDriver MobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

//Rest API
    public static RequestSpecification httpRequest;
    public  static Response response;
    public static JsonPath jp;
    public static JSONObject parameters= new JSONObject();

    //Database
    protected  static Connection con;
    protected  static Statement stat;
    protected  static ResultSet rs;


    //Web page objects
    protected static pageobjects.nopCommerce.RegisterPage nopCommerceRegistration;
    protected static pageobjects.nopCommerce.LoginPage nopCommerceLogin;
    protected static pageobjects.nopCommerce.MainPage nopCommerceMain;
    protected static pageobjects.nopCommerce.UpperHeaderPage upperheaderMenu;
    protected static pageobjects.nopCommerce.HeaderMenuPage HeaderMenu;
    protected static pageobjects.nopCommerce.ComputerPage computerMenu;
    protected static pageobjects.nopCommerce.DesktopPage desktopPage;
    protected static pageobjects.nopCommerce.Camera_PhotoPage cameraPhotoPage;
    protected static pageobjects.nopCommerce.WishListPage wishListPage;

    //Mobile page objects
    protected static pageobjects.experitest.MainPage eribankMainPage;
    protected static pageobjects.experitest.MortgageRequestPage MortgageRequestPage;
    protected static pageobjects.ApiDemos.ApiDemosMainPage apiDemosMainPage;

    //Mobile Electron objects
    protected static pageobjects.todolist.MainPage todoMainPage;

    //Mobile Desktop objects
    protected static pageobjects.calculator.calcMainPage calcMain;
}
