package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.fail;


public class UIActions extends CommonOps {

    @Step("click on element")
    public static void click(WebElement elem) {
        elem.click();
    }
    @Step("update text element")
    public static void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value) {
        elem.sendKeys(value);
    }
    @Step("update text element as Human")
    public static void updateTextHuman(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch : text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch+"");

        }
    }


    @Step("update dropdown element")
    public static void updateDropDown(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("mouseHover on element")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }


    //method overload (different signature)
    @Step("mouseHover on element")
    public static void mouseHover(WebElement elem1) {
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).click().build().perform();
    }


    @Step("clear Text")
    public static void clear(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.sendKeys(Keys.CLEAR).build().perform();
    }

    @Step("scroll down")
    public static void scroll(WebElement elem) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);

    }

    @Step("drag and drop")
    public static void dragAndDrop(WebElement elem, WebElement elem1) {
        action.dragAndDrop(elem, elem1).build().perform();
    }

    @Step(" verify elements visually")
    public static void VisualElement(String expected_imageName) {
        try {
            screen.find(getData("imageRepo") + expected_imageName + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File:" + findFailed);
            fail("Error Comparing Image File:" + findFailed);
        }
    }


    @Step("sikuli type text")
    public static void type_text_sikuli(String expected_imageName, String text) throws FindFailed {
        screen.type( getData("imageRepo") + expected_imageName + ".png", getData("usernameweb"));
    }

    @Step("sikuli click")
    public static void click_sikuli(String expected_imageName) {
        try {
            screen.click(getData("imageRepo") + expected_imageName + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("couldn't click on image" + findFailed);
            fail("couldn't click on image" + findFailed);
        }
    }

}
