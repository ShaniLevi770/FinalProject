package pageobjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class MainPage {
    @FindBy(how= How.XPATH, using= "//div[@class='page home-page']/div/div[2]/div/h2")
    public WebElement Topic_Title;

    @FindBy(how= How.XPATH, using= "//ul[@class='top-menu notmobile']/li")
    public List<WebElement>Header_Menu;

    @FindBy(how= How.CSS, using="body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div > div.category-grid.home-page-category-grid > div > div:nth-child(1) > div > h2 > a")
    public WebElement electronics;

    @FindBy(how= How.CSS, using="body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div > div.category-grid.home-page-category-grid > div > div:nth-child(2) > div > h2 > a")
    public WebElement appareal;

    @FindBy(how= How.CSS, using= "body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div > div.category-grid.home-page-category-grid > div > div:nth-child(3) > div > h2 > a")
    public WebElement digital_downloads;

    @FindBy(how= How.CSS, using= "//a[@href='/']")
    public WebElement nopCommerceLogo;

    @FindBy(how= How.XPATH, using= "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")
    public WebElement nopCommerceSearchResults;

    @FindBy(how= How.XPATH, using= "//*[@class='search-box-text ui-autocomplete-input']")
    public WebElement NopCommerceSearchText;

    @FindBy(how= How.XPATH, using= "//*[@class='button-1 search-box-button']")
    public WebElement NopCommerce_btn_Searchsubmit;

    @FindBy(how= How.ID, using= "customerCurrency")
    public WebElement customerCurrency;

    @FindBy(how= How.ID, using= "newsletter-email")
    public WebElement  newsletter_email;

    @FindBy(how= How.CLASS_NAME, using= "newsletter-result")
    public WebElement  newsletter_result;

    @FindBy(how= How.CLASS_NAME, using= "newsletter-subscribe-button")
    public WebElement  btn_subscribe;




}
