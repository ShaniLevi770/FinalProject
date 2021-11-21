package workflow;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import extensions.Verifications;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;


public class MobileFlow extends CommonOps {

    @Step ("Business Flow: Login")
    public static void login_eribank(String user, String pass){
       MobileActions.updateText(eribankMainPage.user, user);
       MobileActions.updateText(eribankMainPage.pass, pass);
       MobileActions.click(eribankMainPage.btn_Login);
    }

    @Step("Business Flow: Request Mortgage")
    public static void RequestMortgage(String firstname, String lastname, String Age, String address1, String address2, String country){
        MobileActions.tap(1, eribankMainPage.MortgageRequest_btn, 300);
        MobileActions.updateText(MortgageRequestPage.firstName, firstname);
        MobileActions.updateText(MortgageRequestPage.lastName, lastname);
        MobileActions.updateText(MortgageRequestPage.age, Age);
        MobileActions.updateText(MortgageRequestPage.address1,address1);
        MobileActions.updateText(MortgageRequestPage.address2, address2);
        MobileActions.updateText(MortgageRequestPage.country,country);
        MobileActions.click(MortgageRequestPage.btn_next);
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        MobileActions.tap(1, MortgageRequestPage.home, 300);
        MobileActions.click(MortgageRequestPage.nu_ofYears);
        MobileActions.swipe(156, 1890, 156, 62, 19200);
        MobileActions.click(MortgageRequestPage.GovernmentJob);
        MobileActions.click(MortgageRequestPage.YearlyIncome);
        MobileActions.click(MortgageRequestPage.btn_save);
    }

    @Step("Business Flow:Takes ScreenShot")
    public static void getScreenShot() {
        MobileDriver.openNotifications();
        MobileDriver.swipe(480, 60, 480, 1300, 11200);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        MobileDriver.findElement(By.xpath("//*[@id='icon' and ./parent::*[@contentDescription='צילום מסך']]")).click();
    }


    @Step("Business Flow: Changes Orientation to Portrait ")
    public static void getOrientation() {
        if (MobileDriver.getOrientation().toString() == "LANDSCAPE") {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            MobileDriver.rotate(ScreenOrientation.PORTRAIT);
        }
        else {
            MobileDriver.rotate(ScreenOrientation.LANDSCAPE);
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            MobileDriver.rotate(ScreenOrientation.PORTRAIT);
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        }
    }

    @Step("Business Flow: Switch to Home Page and then to Another App")
    public static void switchApp(String AppPackage, String AppActivity) {
        MobileActions.executeScript("experitest:client.deviceAction(\"Home\")");
        System.out.println(MobileDriver.getDeviceTime());
        MobileDriver.startActivity(AppPackage, AppActivity);
    }


    @Step("Business Flow:Locks The Device")
    public static void lockDevice() {
        if (MobileDriver.isLocked()) {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            MobileDriver.unlockDevice();
        } else {
            MobileDriver.lockDevice();
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            MobileDriver.unlockDevice();
        }
        Assert.assertFalse(MobileDriver.isLocked());
    }


    @Step("Business Flow: Search and Verify titles")
    public static void VerifySearch(String search_text, String ShouldExists) {
        if (ShouldExists.equalsIgnoreCase("exists")) {
           Verifications.searchElementInList(apiDemosMainPage.mainPageTitle, search_text);
        } else if (ShouldExists.equalsIgnoreCase("not-exists")) {
            Verifications.verifyNoSuchElementInList(apiDemosMainPage.mainPageTitle, search_text);
        } else throw new RuntimeException("Invalid Expected Output Option, should be exists or not-exists");
    }

    @Step("Business Flow: Rotating Element Using App Buttons")
    public static void RotatingButtensScreen(String swipestartx, String swipestarty, String swipeendx, String swipeendy, String swipeDuration) {
        MobileActions.click(apiDemosMainPage.Views);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        MobileDriver.swipe(460, 2000, 533, 184, 11000);
        MobileActions.click(apiDemosMainPage.rotatingButton_title);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        //rotate with button
        MobileDriver.swipe(Integer.parseInt(swipestartx),
                Integer.parseInt(swipestarty),
                Integer.parseInt(swipeendx),
                Integer.parseInt(swipeendy),
                Integer.parseInt(swipeDuration));
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }


    @Step("Business Flow: Hide And Show Text ")
    public static void hideAndShow() {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        MobileActions.click(apiDemosMainPage.mainPageTitle.get(2));
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        MobileActions.click(apiDemosMainPage.mainPageTitle.get(5));
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        MobileActions.click(apiDemosMainPage.mainPageTitle.get(6));
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        MobileActions.click(apiDemosMainPage.fragments_textbox);
        MobileActions.clearText(apiDemosMainPage.fragments_textbox);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        MobileActions.updateText(apiDemosMainPage.fragments_textbox, "only english");
        MobileActions.click(apiDemosMainPage.fragments_hideAndShow);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Drag_Drop ")
    public static void dragFromTo(AndroidElement elem1, AndroidElement elem2) {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        MobileActions.click(apiDemosMainPage.mainPageTitle.get(10));
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        MobileActions.click(apiDemosMainPage.mainPageTitle.get(7));
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        MobileActions.dragTo(elem1,elem2);
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
    }


    @Step("Business Flow: Return To Main Page ")
    public static void returnToMainPage(int num) {
        for (int i = 0; i <= num; i++)
            MobileDriver.pressKeyCode(4);
    }

}

