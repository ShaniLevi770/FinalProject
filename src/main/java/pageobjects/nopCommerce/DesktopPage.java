package pageobjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class DesktopPage {
    @FindBy(how = How.XPATH, using = "//div[@class='item-grid']/div")
    public List<WebElement> desktop_items;

}
