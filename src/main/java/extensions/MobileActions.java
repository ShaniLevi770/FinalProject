package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;


import java.util.concurrent.TimeUnit;

public class MobileActions extends CommonOps {

    @Step("update text element")
    public static void updateText(MobileElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("clear text from text box")
    public static void clearText(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(Keys.CLEAR);
    }

    @Step("click on element")
    public static void click(MobileElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }


    @Step("tap Element")
    public static void tap(int fingers, MobileElement elem, int duration) {
        MobileDriver.tap(fingers, elem, duration);
    }

    @Step("swipe Element")
    public static void swipe(int startX, int startY, int endX, int endY, int duration) {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        MobileDriver.swipe(startX, startY, endX, endY, duration);
    }


    @Step("zoom Element")
    public static void zoom(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        MobileDriver.zoom(elem);
    }

    @Step("pinch Element")
    public static void pinch(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        MobileDriver.pinch(elem);
    }

    @Step("execute script")
    public static void executeScript(String script) {
        MobileDriver.executeScript(script);
    }

    @Step("get Time")
    public static void getTime() {
        System.out.println(MobileDriver.getDeviceTime());

    }

    @Step("drag and drop")
    public static void dragTo(AndroidElement source, WebElement target) {
        TouchAction action = new TouchAction(MobileDriver);
        action.longPress(source).moveTo(target).release().perform();

    }
}


