package listeners;

import com.aventstack.extentreports.Status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import base.DriverFactory;
import utils.ScreenshotUtil;

public class ExtentListener extends TestListenerAdapter {
	
	String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	
        String screenshotPath = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getName() + "_" + timestamp);
        testThread.get().addScreenCaptureFromPath(screenshotPath);
        testThread.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getName() + "_" + timestamp);
        testThread.get().fail(result.getThrowable());
        testThread.get().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
