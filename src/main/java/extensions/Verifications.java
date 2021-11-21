package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;
//import static org.testng.AssertJUnit.*;

public class Verifications extends CommonOps {

    @Step("Verify Text in Element")
    public static void verifyTextinElemant(WebElement elem, String expected) {
      Assert.assertEquals(elem.getText(), expected);
    }

    @Step("Verify Text in innerHTML")
    public static void verifyTextininnerHTML(WebElement elem, String expected) {
       wait.until(ExpectedConditions.visibilityOf(elem));
       Assert.assertEquals(elem.getAttribute("innerHTML").trim(), expected);
    }

    @Step("Verify Text Vs. Text")
    public static void verifyTextVsText(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    //Electron
    @Step("Verify Number Vs. Number")
    public static void verifyNumber(int actual, int expected) {
        Assert.assertEquals(actual, expected);
    }

    @Step("Verify Number of Element")
    public static void numberOfElements(List<WebElement> elems, int expected) {
      wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
      Assert.assertEquals(elems.size(), expected);
    }

    @Step(" Verify Existence of Elements")
    public static void ExistenceOfElementsInList(List<WebElement> elems, int expected_number) {
      wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
      Assert.assertTrue(elems.size() == expected_number);
    }


    @Step("Verify Visibility Of Elements in List- softAssert")
    public static void visibilityOfElements(List<WebElement> elems) {
      wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
      for (WebElement elem : elems) {
      softAssert.assertTrue(elem.isDisplayed(), "Sorry" + elem.getText() + "isn't displayed");
      }
     softAssert.assertAll("some elements were not displayed");
    }

    @Step("Verify Visibility of Element")
    public static void visibilityOfElement(WebElement elem) {
      wait.until(ExpectedConditions.visibilityOf(elem));
        try {
            elem.isDisplayed();
        }
        catch (Exception e) {
            System.out.println("elem is not displayed");
        }
    }

    @Step(" Verify Elements Visually")
    public static void VisualElement(String expected_imageName) {
        try {
        screen.find(getData("imageRepo") + expected_imageName + ".png");
        }
        catch (FindFailed findFailed) {
        System.out.println("Error Comparing Image File:" + findFailed);
        fail("Error Comparing Image File:" + findFailed);
        }
    }


    @Step(" Verify Existence of Element")
    public static void ExistenceOfElement(WebElement elem) {
       // wait.until(ExpectedConditions.visibilityOf(elem));
       Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        try {
            Assert.assertTrue(elem.isDisplayed());
        }
        catch (NoSuchElementException e) {
            fail("No products were found that matched your criteria.");

        }
    }

    @Step("Verify nonExistence of Element")
    public static void nonExistenceOfElement(WebElement elem) {
        try {
            Assert.assertFalse(elem.isDisplayed());
        }
        catch (NoSuchElementException e) {
        }
    }



    @Step(" Find and Verify Text in Element is Shown")
    public static void searchElementInList(List<AndroidElement> elems, String search_text) {
        int k = 0;
        for (int i = 0; i < elems.size(); i++) {
            if (elems.get(i).getText().equals(search_text)) {
                k = 1;
            }
            if (k == 1)
                break;
        }
        if (k == 1) {
            System.out.println(search_text + " exists");
        } else {
            fail(search_text + " should exist but were not found");
        }
    }

    @Step("Business Flow: Find and Verify No Such Element In List")
    public static void verifyNoSuchElementInList(List<AndroidElement> elems, String search_text) {
        int k = 0;
        for (int i = 0; i < elems.size(); i++) {
            if (elems.get(i).getText().equals(search_text)) {
                k = 1;
            }
            if (k == 1)
                break;
        }
        if (k == 0) {
            System.out.println(search_text + " not exists");
        } else {
            fail(search_text + " should not exist but were found");
        }
    }

    @Step("Verify Visibility Of MobileElements in List- softAssert")
    public static void visibilityOfMobileElements(List<AndroidElement> elems) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        for (AndroidElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Sorry" + elem.getText() + "isn't displayed");
        }
        softAssert.assertAll("some elements were not displayed");
    }

    @Step("Verify Number of Mobile Elements in List ")
    public static void numberOfMobileElements(List<AndroidElement> elems, int i) {
        Assert.assertEquals(elems.size(), i);
    }

    @Step ("Verify Element Dimensions")
    public static void verifyDimensions(AndroidElement elem, int x, int y, int width, int height) {
        Assert.assertEquals(elem.getRect().getX(), x);
        Assert.assertEquals(elem.getRect().getY(), y);
        Assert.assertEquals(elem.getRect().getWidth(), width);
        Assert.assertEquals(elem.getRect().getHeight(), height);
    }

    @Step ("Verify element Text Contains")
    public static void TextContains(AndroidElement elem, String text) {
        Assert.assertTrue(elem.getText().contains(text));
    }



    //ONLY TO WEB PRICES
    @Step("Business Flow: Verify Prices Are Sorted From Low To High")
    public static void prices_are_sorted(List<WebElement> elems) {

        //isolate price from $ and .00
        String pricearray[] = new String[elems.size()];
        int[] prices = new int[elems.size()];
        for (int i = 0; i < elems.size(); i++) {
            ;
            String temp = elems.get(i).getText();
            pricearray[i] = temp.split("\\$")[1].split("\\.")[0];
        }
        //string to int
        for (int i = 0; i < elems.size(); i++) {
            prices[i] = Integer.parseInt(pricearray[i]);
            System.out.println(prices[i]);
        }
        for (int i = 0; i < elems.size() - 1; i++) {
            if (prices[i] <= prices[i + 1])
                System.out.println("ok");
            else {
                fail("prices  are not sorted from low to high");
            }
        }
    }


}