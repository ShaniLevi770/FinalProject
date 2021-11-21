package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends  CommonOps implements ITestListener {


    public void onFinish(ITestContext arg0) {
        System.out.println("Starting Execution");

    }


    public void onStart(ITestContext arg0) {
        System.out.println("Ending Execution");

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        // TODO Auto-generated method stub

    }


    public void onTestFailure(ITestResult test) {
        System.out.println("Test " + test.getName() + " Failed");

        if (!platform.equalsIgnoreCase("api")) {
            saveScreenshots();
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void onTestSkipped(ITestResult test) {
        // TODO Auto-generated method stub

    }


    public void onTestStart(ITestResult test) {
        System.out.println("Test " + test.getName() +" staerted");

    }


    public void onTestSuccess(ITestResult test) {
        System.out.println("Test " + test.getName() + " Past");

        if (!platform.equalsIgnoreCase("api")) {
            //stop recorder
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //delete file
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File Deleted Succefully");
            else
                System.out.println("Failed To Delete File");
        }
    }

    @Attachment(value = "page screen shots", type = "image/png")
    public byte[] saveScreenshots()
    {
        if (!platform.equalsIgnoreCase("mobile"))
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    else
            return ((TakesScreenshot)MobileDriver).getScreenshotAs(OutputType.BYTES);


    }

}
