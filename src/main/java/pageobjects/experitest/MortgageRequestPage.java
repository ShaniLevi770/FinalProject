package pageobjects.experitest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class MortgageRequestPage {


    private AppiumDriver MobileDriver;

    public MortgageRequestPage(AppiumDriver MobileDriver){
        this.MobileDriver = MobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(MobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id= "passwordTextField")
    public AndroidElement pass;

    @AndroidFindBy (xpath = "//*[@text='First Name']")
    public AndroidElement firstName;

    @AndroidFindBy (xpath = "//*[@text='Last Name']")
    public AndroidElement lastName;

    @AndroidFindBy (xpath = "//*[@text='Age']")
    public AndroidElement age;

    @AndroidFindBy (xpath = "//*[@text='Address 1']")
    public AndroidElement address1;

    @AndroidFindBy (xpath = "//*[@text='Address 2']")
    public AndroidElement address2;

    @AndroidFindBy (xpath = "//*[@text='Country']")
    public AndroidElement country;

    @AndroidFindBy (xpath = "//*[@text='Next']")
    public AndroidElement btn_next;

    @AndroidFindBy (xpath = "//*[@text='Home']")
    public AndroidElement home;

    @AndroidFindBy (xpath = "//*[@text='15']")
    public AndroidElement nu_ofYears;

    @AndroidFindBy (xpath = "//*[@text='Government Job']")
    public AndroidElement GovernmentJob;

    @AndroidFindBy (xpath = "//*[@text='500000']")
    public AndroidElement YearlyIncome;


    @AndroidFindBy (xpath = "//*[@text='Save']")
    public AndroidElement btn_save;










}
