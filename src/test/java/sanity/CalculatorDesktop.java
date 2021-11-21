package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.DesktopFlow;

@Listeners(utilities.Listeners.class)

public class CalculatorDesktop extends CommonOps {

    //Open WinAppDriver Before Running Tests
    @Test(description = "Test01 - Verify Addition Result of 1+ 2 ")
    @Description("This Test verify Addition Result of 1+ 2")
     public void  test01_verifyAddition (){
        DesktopFlow.calculateAddition1and2();
        Verifications.verifyTextinElemant(calcMain.field_result, "Display is 3");

    }

    @Test(description = "Test02 - Verify Addition Result ")
    @Description("This Test verify Addition Result")
    public void  test02_verifyAdditionGeneric (){
        DesktopFlow.calculateAddition (calcMain.btn_one, calcMain.btn_three);
        Verifications.verifyTextinElemant(calcMain.field_result, "Display is 4");
    }

    @Test(description = "Test03 - Press on Memory and Verify Result is Empty")
    @Description("This Test Press on Memory and Verify Result is Empty")
    public void  test03_EmptyMemory (){
        DesktopFlow.EmptyMemory(calcMain.btn_two);
        Verifications.verifyTextinElemant(calcMain.btn_MemoryisEmpty, "There’s nothing saved in memory");
    }

    @Test(description = "Test04 - Verify Divide Operator Result ")
    @Description("This Test verify Divide Operator Result")
    public void  test04_verifyDividesOperator (){
        DesktopFlow.RequestMathOp(calcMain.btn_two, "divide", calcMain.btn_one);
        Verifications.verifyTextinElemant(calcMain.field_result, "Display is 2");
    }
    @Test(description = "Test05 - Verify Multiply Operator Result ")
    @Description("This Test Verify Multiply Operator Result")
    public void  test05_verifyMultiplyOperator (){
        DesktopFlow.RequestMathOp(calcMain.btn_two, "multiply", calcMain.btn_one);
        Verifications.verifyTextinElemant(calcMain.field_result, "Display is 2");
    }
    @Test(description = "Test04 - Verify Minus Operator Result ")
    @Description("This Test verify Minus Operatior Result")
    public void  test03_verifyMinusOperator (){
        DesktopFlow.RequestMathOp(calcMain.btn_two, "minus", calcMain.btn_one);
        Verifications.verifyTextinElemant(calcMain.field_result, "Display is 1");
    }
    @Test(description = "Test04 - Verify Plus Operator Result ")
    @Description("This Test Verify Plus Operator Result")
    public void  test03_verifyPlusOperator (){
        DesktopFlow.RequestMathOp(calcMain.btn_two, "plus", calcMain.btn_one);
        Verifications.verifyTextinElemant(calcMain.field_result, "Display is 3");
    }

}
