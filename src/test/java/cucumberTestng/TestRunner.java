package cucumberTestng;

/**
 * Created by bsc4518 on 7/27/2017.
 */

import Utils.MobileApp;
import com.relevantcodes.extentreports.ExtentReports;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = "src/main/resources/Features/sampleTest.feature", format = { "pretty",
        "html:target/site/cucumber-pretty",
        "rerun:target/rerun.txt",
        "json:target/cucumber1.json" },
        glue = {"classpath:StepDefinitions"},
        tags = {"~@ignore"})
public class TestRunner extends AbstractTestNGCucumberTests {



    @BeforeClass
    public static void loadPageObjects() throws Throwable {
        System.out.println("----BeforeClass----");
        MobileApp.getInstance();
        MobileApp.report = new ExtentReports("target\\report.html",true);
    }

    @AfterClass
    public static void end(){
        System.out.println("----------After Class----------");
        MobileApp.report.flush();
    }
}