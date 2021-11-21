package workflow;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebFlows extends CommonOps {

    @Step("Business Flow: Registration")
    public static void registration(String firatName, String lastName, String email_adress, String pass, String confirm_pass) {

        UIActions.click(nopCommerceRegistration.btn_register_nopCommerce);
        Uninterruptibles.sleepUninterruptibly(800, TimeUnit.MILLISECONDS);
        UIActions.updateText(nopCommerceRegistration.first_name, firatName);
        UIActions.updateText(nopCommerceRegistration.last_name, lastName);
        UIActions.updateText(nopCommerceRegistration.Email_adress, email_adress);
        UIActions.updateText(nopCommerceRegistration.password, pass);
        UIActions.updateText(nopCommerceRegistration.confirm_password, confirm_pass);
        UIActions.click(nopCommerceRegistration.btn_register_submit);
    }

    @Step("Business Flow: Login")
    public static void login(String user, String pass) {
        UIActions.click(nopCommerceLogin.btn_login_nopCommerce);
        UIActions.updateText(nopCommerceLogin.txt_user, user);
        UIActions.updateText(nopCommerceLogin.txt_paas, pass);
        UIActions.click(nopCommerceLogin.btn_login_submit);
    }


    @Step("Business Flow: Verify Headers")
    public static void verify_Headers(){
        Verifications.visibilityOfElements(nopCommerceMain.Header_Menu);
        Verifications.verifyTextinElemant(nopCommerceMain.Topic_Title,"Welcome to our store");
        Verifications.verifyTextinElemant(HeaderMenu.electronics,"Electronics");
        Verifications.verifyTextinElemant(HeaderMenu.apareal,"Apparel");
        Verifications.verifyTextinElemant(HeaderMenu.digital_downloads,"Digital downloads");
        Verifications.verifyTextinElemant(HeaderMenu.computers,"Computers");
    }


    @Step("Business Flow: Add A Product To Wishlist ")
    public static void AddTowishList( int i){
        UIActions.click(HeaderMenu.electronics);
        UIActions.click(HeaderMenu.camera_and_photosnew);
        Verifications.numberOfElements(cameraPhotoPage.itemsOnPage, 3);
        UIActions.click(cameraPhotoPage.camera_add_Towishlist.get(i));
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Login to nopCommerce with DB Credentials")
    public static void loginDB() {
        String query = "SELECT Comments, Password FROM employees1 WHERE id='3'";
        List<String> cred = DBActions.getCrdentials(query);
        UIActions.click(nopCommerceLogin.btn_login_nopCommerce);
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        UIActions.updateText(nopCommerceLogin.txt_user, cred.get(0));
        UIActions.updateText(nopCommerceLogin.txt_paas, cred.get(1));
        UIActions.click(nopCommerceLogin.btn_login_submit);
    }


    @Step("Business Flow: Subscribe to nopCommerce Newsletter with e-mail from DB")
    public static void subscribeDB() {
        String query = "SELECT Comments FROM employees1 WHERE id='1'";
        String emailDB = DBActions.get_email(query);
        UIActions.scroll(nopCommerceMain.newsletter_email);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        UIActions.updateText(nopCommerceMain.newsletter_email,emailDB );
        UIActions.click(nopCommerceMain.btn_subscribe);
    }


    @Step("Business Flow: Delete from wishlist")
    public static void deleteFrom_wishLList(WebElement elem1, WebElement elem2) {
        UIActions.click(elem1);
        UIActions.click(elem2);
    }

    @Step("Business Flow: Add Item to Shopping Cart")
    public static void addToShoppingCart(int indexOfDesiredItem) {
        UIActions.click(HeaderMenu.electronics);
        UIActions.click(HeaderMenu.cell_phonesNew);
        Verifications.numberOfElements(cameraPhotoPage.itemsOnPage, 3);
        String priceOfProduct = cameraPhotoPage.pricelist.get(indexOfDesiredItem).getText();
        UIActions.click(cameraPhotoPage.btn_addToCart.get(indexOfDesiredItem));
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        UIActions.click(HeaderMenu.shopping_cart);
        Verifications.verifyTextinElemant(wishListPage.price_data,priceOfProduct);
        //empty cart
        UIActions.click(wishListPage.remove_btn);

    }

    @Step("Business Flow: Empty Shopping Cart")
    public static void EmptyShoppingCart() {
        UIActions.click(HeaderMenu.shopping_cart);
        System.out.println(upperheaderMenu.shoppingCart.getText());
        while (upperheaderMenu.shoppingCart_quantity.getAttribute("innerHTML") != "(0)") {
            UIActions.click(wishListPage.remove_btn);
        }
    }

    @Step("Business Flow: Subscribe to Website Newsletter ")
    public static void subscribeToNewsletter_Sikuli(String username) throws FindFailed {
        UIActions.scroll(nopCommerceMain.newsletter_email);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        //UIActions.type_text_sikuli("nopCommerceNewsletter", username);
        UIActions.updateText(nopCommerceMain.newsletter_email, "SHANI.SULTAN@GMAIL.COM");
        UIActions.click_sikuli("nopCommerceSubscribe");
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


    @Step("Business Flow: Subscribe to Website Newsletter ")
    public static void subscribeToNewsletter(String username)  {
        UIActions.scroll(nopCommerceMain.newsletter_email);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        UIActions.updateText(nopCommerceMain.newsletter_email, username);
        UIActions.click(nopCommerceMain.btn_subscribe);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


    @Step("Business Flow:Switch to Popup Alert ")
    public static void popupSwitch(){
        //UIActions.mouseHover(HeaderMenu.electronics, HeaderMenu.cell_phonesNew);
        UIActions.click(HeaderMenu.electronics);
        String pageTitle= driver.getTitle();
        UIActions.click(HeaderMenu.cell_phonesNew);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        UIActions.click(nopCommerceMain.NopCommerce_btn_Searchsubmit);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        Alert popup= driver.switchTo().alert();
        popup.accept();
        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(),pageTitle);
    }

    @Step("Business Flow: Search and Verify elements")
    public static void VerifySearch(String search_text, String ShouldExists) {
        UIActions.updateTextHuman(nopCommerceMain.NopCommerceSearchText, search_text);
        UIActions.click(nopCommerceMain.NopCommerce_btn_Searchsubmit);
        if (ShouldExists.equalsIgnoreCase("exists")) {
            Verifications.ExistenceOfElement(nopCommerceMain.nopCommerceSearchResults);
            System.out.println(nopCommerceMain.nopCommerceSearchResults.getText() + " exists");
        } else if (ShouldExists.equalsIgnoreCase("not-exists")) {
            Verifications.nonExistenceOfElement((nopCommerceMain.nopCommerceSearchResults));
            System.out.println("Element doesn't exists");
        } else throw new RuntimeException("Invalid Expected Output Option, should be exists or not-exists");

    }


}
