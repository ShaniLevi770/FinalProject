package pageobjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    @FindBy(how= How.CLASS_NAME, using= "ico-register")
    public WebElement btn_register_nopCommerce;

    @FindBy (how= How.ID, using= "FirstName")
    public WebElement first_name;

    @FindBy (how= How.ID, using= "LastName")
    public WebElement last_name;

    @FindBy (how= How.ID, using= "Email")
    public WebElement Email_adress;

    @FindBy (how= How.ID, using= "Password")
    public WebElement password;

    @FindBy (how= How.ID, using= "ConfirmPassword")
    public WebElement confirm_password;

    @FindBy (how= How.ID, using= "register-button")
    public WebElement btn_register_submit;

    @FindBy(how= How.XPATH, using= "//div[@class='page-title']/h1")
    public WebElement register_finish;


    @FindBy(how = How.XPATH, using = "//a[@class='button-1 register-continue-button']")
    public WebElement continue_toMainPage;


}
