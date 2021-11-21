package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.MobileFlow;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.fail;


@Listeners(utilities.Listeners.class)
public class EribankMobile extends CommonOps {

    @Test(description = "Test01 - Login to App")
    @Description("This Test Login to Eribank App and Verify Main Headers ")
    public void test01_Login() {
        MobileFlow.login_eribank(getData("usernamemobile"), getData("passwordmobile"));
        Uninterruptibles.sleepUninterruptibly(900, TimeUnit.MILLISECONDS);
        Verifications.verifyTextinElemant(eribankMainPage.MakePayment_btn, "Make Payment");
        Verifications.verifyTextinElemant(eribankMainPage.MortgageRequest_btn, "Mortgage Request");
        Verifications.verifyTextinElemant(eribankMainPage.ExpenseReport_btn, "Expense Report");
        Verifications.verifyTextinElemant(eribankMainPage.Logout_btn, "Logout");
    }

    @Test(description = "Test02 - Request Loan")
    @Description("This Test Fills Form For Loan Request")
    public void test02_Loan_Request() {
        MobileFlow.RequestMortgage("Shani", "Levi", "36", "Alonei Habashan", "Jerusalem", "Israel");
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        Verifications.verifyTextinElemant(eribankMainPage.ExpenseReport_btn, "Expense Report");
    }


    @Test(description = "Test03 - Changes Orientation")
    @Description("This Test Changes the Screen Orientation and Verify it")
    public void test03_ChangesOrientation() {
        MobileFlow.getOrientation();
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        Assert.assertEquals(MobileDriver.getOrientation().toString(), "PORTRAIT");
    }


    @Test(description = "Test04 - Takes ScreenShot")
    @Description("This Test Takes ScreenShot and Verify it")
    public void test04_getScreenShot() {
        MobileFlow.getScreenShot();
        try {
            Assert.assertTrue(eribankMainPage.screenshot_options.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("No screenshot were found");
        }
    }


    @Test(description = "Test05 - Switches To apiDemos App")
    @Description("This Test Switches To apiDemos App")
    public void test05_switchApp() {
        MobileFlow.switchApp(getData("AppPackage2"), getData("AppActivity2"));
        Verifications.numberOfMobileElements(apiDemosMainPage.mainPageTitle, 11);
    }

    @Test(description = "Test06 - Verify Search Titles", dataProvider = "data-provider-user", dataProviderClass = utilities.ManageDDT_Mobile.class)
    @Description("This Test Search and Verify Titles From DDT File ")
    public void test06_SearchTitles(String txt, String shouldExists) {
        MobileFlow.VerifySearch(txt, shouldExists);
    }

    @Test(description = "Test07 - Use Rotating Button and Verify it")
    @Description("This Test Changes The Rotating Button and Verifies the Dimensions Accordingly")
    public void test07_RotatingButton() {
        //swipe on y axis
       MobileFlow.RotatingButtensScreen(getData("swipe1_statrx"),getData("swipe1_statry"), getData("swipe1_endx"), getData("swipe1_endy"),getData("swipe1_duration"));
        Verifications.verifyDimensions(apiDemosMainPage.rotatingButton, 530, 407, 550, 991);
//        //return to original position
        MobileActions.swipe(Integer.parseInt(getData("swipe1_endx")),
                Integer.parseInt(getData("swipe1_endy")),
                Integer.parseInt(getData("swipe1_statrx")),
                Integer.parseInt(getData("swipe1_statry")),
                Integer.parseInt(getData("swipe1_duration")));
//        //swipe on z axis
        MobileDriver.swipe(Integer.parseInt(getData("swipe2_statrx")),
                Integer.parseInt(getData("swipe2_statry")),
                Integer.parseInt(getData("swipe2_endx")),
                Integer.parseInt(getData("swipe2_endy")),
                Integer.parseInt(getData("swipe2_duration")));

        Verifications.verifyDimensions(apiDemosMainPage.rotatingButton, 508, 648, 572, 509);
        //Return To Main Page
        MobileFlow.returnToMainPage (1);
    }


//Doesn't Work on Xiaomi Devices
//    @Test(description = "Test08 - Locks The Device And Unlocks It ")
//    @Description("This test Locks The Device And Unlocks It")
//    public void test08_DeviceLock() {
//        MobileFlow.lockDevice();
//        Verifications.numberOfMobileElements(apiDemosMainPage.mainPageTitle, 11);
//    }

    @Test(description = "Test09 - Hide And Show Test ")
    @Description("This Test verify Button changes From Show To Hide when clicked and Reversing")
    public void test08_hide_Show() {

        MobileFlow.hideAndShow();
        Verifications.verifyTextinElemant(apiDemosMainPage.fragments_hideAndShow, "SHOW");
        MobileActions.click(apiDemosMainPage.fragments_hideAndShow);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        Verifications.verifyTextinElemant(apiDemosMainPage.fragments_hideAndShow, "HIDE");
        Verifications.visibilityOfElement(apiDemosMainPage.fragments_textbox);
        //Return To Main Page
        MobileFlow.returnToMainPage (3);
        Uninterruptibles.sleepUninterruptibly(1,TimeUnit.SECONDS);
    }

    @Test(description = "Test10 - Drag and Drop Circle ")
    @Description("This Test verify Text Changes When Drag And Dropped")
    public void test09_DragAndDrop() {
        MobileFlow.dragFromTo(apiDemosMainPage.dot_1, apiDemosMainPage.dot_3);
        Verifications.TextContains(apiDemosMainPage.drag_text, "dot_1");
        MobileActions.dragTo(apiDemosMainPage.dot_3, apiDemosMainPage.dot_1);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        Verifications.TextContains(apiDemosMainPage.drag_text, "dot_3");
        //Return To Main Page
        MobileFlow.returnToMainPage (1);

    }

}
