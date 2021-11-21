package pageobjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy (how= How.CLASS_NAME, using= "ico-login")
    public WebElement btn_login_nopCommerce;

    @FindBy (how= How.ID, using= "Email")
    public WebElement txt_user;

    @FindBy (how= How.CLASS_NAME, using= "password")
    public WebElement txt_paas;

    @FindBy (how= How.CSS, using= "button[class='button-1 login-button']")
    public WebElement btn_login_submit;

    @FindBy (how= How.XPATH, using= "//div[@class='new-wrapper register-block']/div[3]/button")
    public WebElement btn_register_block;


}
