package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.WebFlows;
import java.util.concurrent.TimeUnit;
import org.sikuli.script.FindFailed;
import static org.testng.AssertJUnit.fail;

@Listeners(utilities.Listeners.class)
public class nopCommerceWeb extends CommonOps {


    @Test(description = "Test01 - Register/Login")
    @Description("This Test Registers or Login (As Needed) and Verify Main Header Element")
    public void test01_RegisterOrLogin(){
        WebFlows.login(getData("usernameweb"), getData("passwordweb"));
        try{
            UIActions.click(nopCommerceLogin.btn_register_block);
            WebFlows.registration("shani", "levi", "shani.sultan@gmail.com", "130785sh", "130785sh");
            Verifications.verifyTextinElemant(nopCommerceRegistration.register_finish, "Register");
            UIActions.click(nopCommerceRegistration.continue_toMainPage);
        }
        catch (NoSuchElementException e){
            System.out.println("enter_main");
        }
        Verifications.ExistenceOfElement(HeaderMenu.electronics);
    }

    @Test (description = "Test02 - verifyHeaders")
    @Description("This Test Verify Some MainPage Elements ")
    public void test02_VerifyHeader(){
        WebFlows.verify_Headers();
    }


    @Test (description = "Test03 - Adds Items To Wish List")
    @Description("This Test Adds the Specified Item By Number to the Wishlist ")
    public void test03_AddTowishList() {
        WebFlows.AddTowishList(1);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Verifications.verifyTextinElemant(upperheaderMenu.wishList, "Wishlist (1)");
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


     @Test (description = "Test04 - Delete Item From Wishlist")
     @Description("This Test Deletes Item from Wishlist ")
     public void test04_DeleteFromWishlist(){
        WebFlows.deleteFrom_wishLList(upperheaderMenu.wishListLabel, wishListPage.remove_btn);
        Uninterruptibles.sleepUninterruptibly(1,TimeUnit.SECONDS);
        Verifications.verifyTextinElemant(upperheaderMenu.wishList, "Wishlist (0)");
     }

//    @Test (description = "Test05 - Verify Logo Visually")
//    @Description("This Test Verify Company Logo Using Sikuli Tool ")
//    public void test05_Verify_LogoVisually(){
//        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
//        Verifications.VisualElement("nopCommerceLogo");
//    }

    @Test (description = "Test06 - Verify Search Results", dataProvider = "data-provider-user", dataProviderClass = utilities.ManageDDT.class )
    @Description("This Test Verify Search Results For Strings Accepted From Data Provider Method")
    public void test06_Verify_SearchResults(String txt, String shouldExists){
        WebFlows.VerifySearch (txt,shouldExists);
    }

    @Test (description = "Test07 - Add Item To Shopping Cart")
    @Description("This Test Adds the Specified Item By (Given Index)  To Shopping Cart and Verify it")
    public void test07_AddItem_ShoppingCart() {
        WebFlows.addToShoppingCart(1);
    }


    @Test (description = "Test08 - Sort Items By Price Low to High and Verify it ")
    @Description("This Test Sorts Items On Page By Price Low to High")
    public void test08_sortPrices() {
        //UIActions.mouseHover(HeaderMenu.electronics, HeaderMenu.cell_phones);
        UIActions.click(HeaderMenu.electronics);
        UIActions.click(HeaderMenu.cell_phonesNew);
        UIActions.updateDropDown(cameraPhotoPage.orderby, "Price: Low to High");
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        Verifications.prices_are_sorted(cameraPhotoPage.pricelist);
        }



    @Test (description = "Test09 - Change Currency from Dollars to Euro and back")
    @Description("This Test Changes Currency from Dollars to Euro and back and Verify")
    public void test09_changeCurrency() {
      UIActions.updateDropDown(nopCommerceMain.customerCurrency,"Euro");
      Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
      //get selected text to verify action was completed
        Select select = new Select(nopCommerceMain.customerCurrency);
        WebElement option = select.getFirstSelectedOption();
        String SelectedText = option.getText();

        Verifications.verifyTextVsText(SelectedText, "Euro");
        //Verifications.VisualElement("nopCommerceCurrency");
        UIActions.updateDropDown(nopCommerceMain.customerCurrency,"US Dollar");
    }

//
//    @Test (description = "Test10 - Enlist To nopCommerce Newsletter using Sikuli and Verify it")
//    @Description("This Test Enlists To nopCommerce Newsletter and Verify it")
//    public void test10_enlistToNewsletter_Sikuli() throws FindFailed {
//        WebFlows.subscribeToNewsletter(getData("usernameweb"));
//        String thankU="Thank you for signing up! A verification email has been sent. We appreciate your interest.";
//        Verifications.verifyTextinElemant(nopCommerceMain.newsletter_result, thankU);
//    }


    @Test (description = "Test10 - Enlist To nopCommerce Newsletter and Verify it")
    @Description("This Test Enlists To nopCommerce Newsletter and Verify it")
    public void test10_enlistToNewsletter()  {
        WebFlows.subscribeToNewsletter(getData("usernameweb"));
        String thankU="Thank you for signing up! A verification email has been sent. We appreciate your interest.";
        Verifications.verifyTextinElemant(nopCommerceMain.newsletter_result, thankU);
    }

    @Test (description = "Test11 - Switch to Popup Window ")
    @Description("This Test Switches to Popup Window and Closes it")
    public void test11_switch() {
        WebFlows.popupSwitch();
    }
}

