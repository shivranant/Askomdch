package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    //features = "C:\\Users\\Asus\\Desktop\\Shivkrishna\\Integrated_framewrok\\resources\\Feature_Files_UI",             // folder where both .feature files exist
		features = "C:\\Users\\Asus\\Desktop\\Shivkrishna\\Integrated_framewrok\\src\\test\\resources\\Feature_Files_UI\\Registration.feature",
	    glue = {"Step_Definations", "Hooks_Layer"},            // step definitions + hooks
	    plugin = {
	        "pretty",
	        "html:reports/cucumber-html-report",
	        "json:reports/cucumber.json",
	        "rerun:target/failed_scenarios.txt"
	    },
	    tags = "@Registration",                         // run both tagged scenarios
	    monochrome = true,
	    dryRun = false
	)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios(); // enables parallel scenario execution
    }
    
}
