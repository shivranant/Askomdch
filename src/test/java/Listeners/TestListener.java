package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils_Layer.*;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReport_Utils.initReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport_Utils.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport_Utils.logPass(result.getMethod().getMethodName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = Screenshot_Utils.captureScreenshot(result.getMethod().getMethodName());
        ExtentReport_Utils.logFail(result.getMethod().getMethodName() + " failed.");
        ExtentReport_Utils.attachScreenshot(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReport_Utils.skip(result.getMethod().getMethodName() + " skipped.");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport_Utils.flushReports();
    }
}