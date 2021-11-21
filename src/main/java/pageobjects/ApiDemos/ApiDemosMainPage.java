package pageobjects.ApiDemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApiDemosMainPage {


    private AppiumDriver MobileDriver;

    public ApiDemosMainPage(AppiumDriver MobileDriver) {
        this.MobileDriver = MobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(MobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id="text1")
    public List<AndroidElement> mainPageTitle ;

    @AndroidFindBy(id = "logoutButton")
    public AndroidElement Logout_btn;

    @AndroidFindBy (xpath= "//*[@text='Your balance is: 0.00$']")
    public AndroidElement your_balance_0;


    @AndroidFindBy (xpath = "//*[@text='Rotating Button']")
    public AndroidElement rotatingButton_title;

    @AndroidFindBy (id = "rotatingButton")
    public AndroidElement rotatingButton;

    @AndroidFindBy (xpath = "//*[@text='Views']")
    public AndroidElement Views;

    @AndroidFindBy (id = "frag1hide")
    public AndroidElement fragments_hideAndShow;

    @AndroidFindBy (id = "saved")
    public AndroidElement fragments_textbox;

    @AndroidFindBy (id = "0_resource_name_obfuscated")
    public AndroidElement change_lang;

    @AndroidFindBy (id = "drag_dot_1")
    public AndroidElement dot_1;

    @AndroidFindBy (id = "drag_dot_3")
    public AndroidElement dot_3;

    @AndroidFindBy (id = "drag_text")
    public AndroidElement drag_text;

    @AndroidFindBy (id = "key_pos_1_0")
    public AndroidElement letter_s;


}

