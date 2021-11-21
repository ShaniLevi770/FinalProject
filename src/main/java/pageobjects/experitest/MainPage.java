package pageobjects.experitest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {

    private AppiumDriver MobileDriver;

    public MainPage(AppiumDriver MobileDriver){
this.MobileDriver = MobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(MobileDriver, 3, TimeUnit.SECONDS), this);
    }


    @AndroidFindBy (id= "usernameTextField")
    public AndroidElement user;

    @AndroidFindBy (id= "passwordTextField")
    public AndroidElement pass;

    @AndroidFindBy (xpath = "//*[@text='Login']")
    public AndroidElement btn_Login;

    @AndroidFindBy (id = "makePaymentButton")
    public AndroidElement MakePayment_btn;

    //typo in program script  mortage instead of mortgage
    @AndroidFindBy (id = "mortageRequestButton")
    public AndroidElement MortgageRequest_btn;


    @AndroidFindBy (id = "expenseReportButton")
    public AndroidElement ExpenseReport_btn;


    @AndroidFindBy (id = "logoutButton")
    public AndroidElement Logout_btn;

    @AndroidFindBy (xpath= "//*[@text='Your balance is: 0.00$']")
    public AndroidElement your_balance_0;

    @AndroidFindBy (xpath = "//*[@class='android.webkit.WebView']")
    public AndroidElement eribank_Logo;

    @AndroidFindBy (xpath = "//*[@property='Value']")
    public List<AndroidElement> entrance_page;

    @AndroidFindBy (id= "global_screenshot")
    public AndroidElement screenshot_options;


}
