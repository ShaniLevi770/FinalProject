package pageobjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderMenuPage {

    @FindBy(how= How.XPATH, using= "//ul[@class='top-menu notmobile']/li[1]")
    public WebElement computers;

    @FindBy(how= How.XPATH, using= "//ul[@class='top-menu notmobile']/li[2]")
    public WebElement electronics;

    @FindBy(how= How.XPATH, using= "//ul[@class='top-menu notmobile']/li[3]")
    public WebElement apareal;

    @FindBy(how= How.XPATH, using= "//ul[@class='top-menu notmobile']/li[4]")
    public WebElement digital_downloads;

    @FindBy(how= How.XPATH, using= "//ul[@class='top-menu notmobile']/li[5]")
    public WebElement books;

    @FindBy(how= How.XPATH, using= "//ul[@class='top-menu notmobile']/li[6]")
    public WebElement jewelery;

    @FindBy(how= How.XPATH, using= "//ul[@class='top-menu notmobile']/li[7]")
    public WebElement gift_cards;

    @FindBy(how = How.XPATH, using = "//a[@href='/others']")
    public WebElement others;

    @FindBy(how = How.XPATH, using = "//a[@href='/cart']")
    public WebElement shopping_cart;


    @FindBy(how= How.XPATH, using= "//a[@href='/camera-photo']")
    public WebElement camera_and_photos;

    @FindBy(how= How.XPATH, using= "//img[@alt='Picture for category Camera & photo']")
    public WebElement camera_and_photosnew;

    @FindBy(how= How.XPATH, using= "//img[@alt='Picture for category Cell phones']")
    public WebElement cell_phonesNew;




}
