package pageobjects.nopCommerce;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class Camera_PhotoPage {

    @FindBy(how = How.XPATH, using = "//button[@class='button-2 add-to-wishlist-button']")
    public List<WebElement> camera_add_Towishlist;


    //relevant paths to all pages
    @FindBy(how = How.CSS, using = "div.item-box")
    public List<WebElement> itemsOnPage;

    @FindBy(how = How.ID, using = "products-orderby")
    public WebElement orderby;

    @FindBy(how = How.CSS, using = "span.price.actual-price")
    public List<WebElement> pricelist;

    @FindBy (how = How.XPATH, using = "//*[@class='button-2 product-box-add-to-cart-button']")
    public List<WebElement> btn_addToCart;

    @FindBy(how = How.CLASS_NAME, using = "price actual-price")
    public List<WebElement> actual_price;





}
