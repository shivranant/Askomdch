package Hooks_Layer;


import io.cucumber.java.*;
import utils_Layer.ExtentReport_Utils;
import utils_Layer.Screenshot_Utils;

import java.io.IOException;

import Base_layer.Base_Class;

public class Hooks extends Base_Class {

	@BeforeAll
    public static void beforeAll() {
        ExtentReport_Utils.initReports();
    }

    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        initialization(); // Set up browser via ThreadLocal
        ExtentReport_Utils.createTest(scenario.getName());
        ExtentReport_Utils.logInfo("🟡 Scenario Started: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotPath = Screenshot_Utils.captureScreenshot(scenario.getName().replaceAll(" ", "_"));
            ExtentReport_Utils.logFail("🔴 Scenario Failed: " + scenario.getName());
            ExtentReport_Utils.attachScreenshot(screenshotPath);
        } else {
        	String screenshotPath = Screenshot_Utils.captureScreenshot(scenario.getName().replaceAll(" ", "_"));
            ExtentReport_Utils.logPass("🟢 Scenario Passed: " + scenario.getName());
            ExtentReport_Utils.attachScreenshot(screenshotPath);
        }

        quitDriver(); // Clean up ThreadLocal WebDriver
    }

    @AfterAll
    public static void afterAll() {
        ExtentReport_Utils.flushReports(); // Flush the Extent report after all scenarios
    }
}

