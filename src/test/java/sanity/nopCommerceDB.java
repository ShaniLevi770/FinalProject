package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.WebFlows;
import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class nopCommerceDB extends CommonOps {
    //make sure sql account is still available//

    @Test(description = "Test01 -Login to nopCommerce with DB Credentials")
    @Description("This Test Logins to nopCommerce with DB Credentials")
    public void test01_RegisterOrLoginDB(){
        WebFlows.loginDB();
        try{
            UIActions.click(nopCommerceLogin.btn_register_block);
            WebFlows.registration("shani", "levi", "shani.sultan@gmail.com", "130785sh", "130785sh");
            Verifications.verifyTextinElemant(nopCommerceRegistration.register_finish, "Register");
            UIActions.click(nopCommerceRegistration.continue_toMainPage);
        }
        catch (NoSuchElementException e){
            System.out.println("Can Not find Element " + e);
        }
    }

    @Test(description = "Test02 -Enlist to Newsletter with e-mail From DataBase ")
    @Description("This Test Enlists to Newsletter with e-mail From DataBase")
    public void test02_enlistToNewsletterDB() {

        WebFlows.subscribeDB();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        String confirmation="Thank you for signing up! A verification email has been sent. We appreciate your interest.";
        Verifications.verifyTextinElemant(nopCommerceMain.newsletter_result, confirmation );

    }

}
