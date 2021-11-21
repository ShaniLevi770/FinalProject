package pageobjects.calculator;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class calcMainPage {
    @FindBy(how= How.NAME, using= "One")
    public WebElement btn_one;

    @FindBy(how= How.NAME, using= "Plus")
    public WebElement btn_plus;

    @FindBy(how= How.NAME, using= "Two")
    public WebElement btn_two;

    @FindBy(how= How.NAME, using= "Three")
    public WebElement btn_three;

    @FindBy(how= How.NAME, using= "Four")
    public WebElement btn_four;

    @FindBy(how= How.NAME, using= "Equals")
    public WebElement btn_equals;

    @FindBy(how= How.NAME, using= "Clear")
    public WebElement btn_clear;

    @FindBy(how= How.XPATH, using= "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;

    @FindBy(how= How.NAME, using= "Square")
    public WebElement btn_square;

    @FindBy(how= How.NAME, using= "Minus")
    public WebElement btn_minus;

    @FindBy(how= How.NAME, using= "Multiply by")
    public WebElement btn_multiply;

    @FindBy(how= How.NAME, using= "Divide by")
    public WebElement btn_divide;

    @FindBy(how= How.NAME, using= "Memory Add")
    public WebElement btn_addToMemory;

    @FindBy(how= How.NAME, using= "Memory")
    public WebElement btn_Memory;

    @FindBy(how= How.NAME, using= "Clear all memory")
    public WebElement btn_ClearMemory;

    @FindBy(how= How.NAME, using= "There's nothing saved in memory")
    public WebElement btn_VerifyMemoryEmpty;

    @FindBy(how= How.XPATH, using= "//*[@AutomationId='MemoryItemValue']")
    public WebElement btn_MemoryValue;

    @FindBy(how= How.XPATH, using= "//*[@AutomationId='MemoryPaneEmpty']")
    public WebElement btn_MemoryisEmpty;

    @FindBy(how= How.NAME, using= "History")
    public WebElement btn_history;
}
