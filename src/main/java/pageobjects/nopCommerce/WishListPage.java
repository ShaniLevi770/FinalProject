package pageobjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WishListPage {
    @FindBy(how= How.XPATH, using= "//div[@name='addtocart']")
    public WebElement addToCart;

    @FindBy(how= How.CLASS_NAME, using= "remove-btn")
    public WebElement remove_btn;

    @FindBy(how= How.CLASS_NAME, using= "product-subtotal")
    public WebElement price_data;




}
