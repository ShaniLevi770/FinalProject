package pageobjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UpperHeaderPage {
    @FindBy(how= How.XPATH, using= "//div[@class='header-links']/ul/li[1]")
    public WebElement myAccount;

    @FindBy(how= How.XPATH, using= "//div[@class='header-links']/ul/li[2]")
    public WebElement logOut;

    @FindBy(how= How.CLASS_NAME, using= "wishlist-label")
    public WebElement wishListLabel;

    @FindBy(how= How.XPATH, using= "//div[@class='header-links']/ul/li[3]")
    public WebElement wishList;

    @FindBy(how= How.XPATH, using= "//div[@class='wishlist-qty']")
    public WebElement wishList_numberofItems;

    @FindBy(how= How.XPATH, using= "//div[@class='header-links']/ul/li[4]")
    public WebElement shoppingCart;

    @FindBy(how= How.XPATH, using= "//span[@class='cart-qty']")
    public WebElement shoppingCart_quantity;

}
