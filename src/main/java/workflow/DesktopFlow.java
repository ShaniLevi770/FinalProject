package workflow;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;
import io.qameta.allure.Step;
import java.util.concurrent.TimeUnit;

public class DesktopFlow extends CommonOps {
    @Step("Business Flow: Calculate Addition 1+2")
    public static void calculateAddition1and2 (){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(calcMain.btn_one);
        UIActions.click(calcMain.btn_plus);
        UIActions.click(calcMain.btn_two);
        UIActions.click(calcMain.btn_equals);
    }

        @Step("Business Flow: Calculate Addition of Any 2 numbers")
        public static void calculateAddition (WebElement elem, WebElement elem1){
            UIActions.click(calcMain.btn_clear);
            UIActions.click(elem);
            UIActions.click(calcMain.btn_plus);
            UIActions.click(elem1);
            UIActions.click(calcMain.btn_equals);
        }

    @Step("Business Flow: Calculate Square of Any number")
    public static void EmptyMemory (WebElement elem){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(elem);
        UIActions.click(calcMain.btn_square);
        UIActions.click(calcMain.btn_addToMemory);
        UIActions.click(calcMain.btn_Memory);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        UIActions.click(calcMain.btn_ClearMemory);
    }


    @Step("Business Flow: Calculate Requested Mathematical Operator on Any Two numbers")
    public static void RequestMathOp (WebElement elem, String mathOperator,WebElement elem1){
        UIActions.click(calcMain.btn_history);
        UIActions.click(calcMain.btn_clear);
        UIActions.click(elem);
        if  (mathOperator.equalsIgnoreCase("plus"))
        UIActions.click(calcMain.btn_plus);
        else if  (mathOperator.equalsIgnoreCase("minus"))
            UIActions.click(calcMain.btn_minus);
        else if  (mathOperator.equalsIgnoreCase("multiply"))
            UIActions.click(calcMain.btn_multiply);
        else if  (mathOperator.equalsIgnoreCase("divide"))
            UIActions.click(calcMain.btn_divide);
        else throw new RuntimeException("Invalid Mathematical Operator Request");
        UIActions.click(elem1);
        UIActions.click(calcMain.btn_equals);

    }

}
