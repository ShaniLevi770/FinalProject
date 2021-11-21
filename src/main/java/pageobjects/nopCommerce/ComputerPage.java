package pageobjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ComputerPage {

    @FindBy(how = How.XPATH, using = "//div[@class='page-body']/div[1]/div/div[1]/div/h2/a")
    public WebElement Desktop;
}
