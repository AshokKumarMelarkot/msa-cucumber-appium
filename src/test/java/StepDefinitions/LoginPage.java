package StepDefinitions;

import Utils.MobileApp;
import Utils.Utility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

/**
 * Created by bsc4518 on 7/14/2017.
 */
public class LoginPage extends Utility {


    @Before
    public void startTest(Scenario scenario){
        System.out.println("----------Before----------");
        MobileApp.logger = MobileApp.report.startTest(scenario.getName());
    }


    @Given("^Login to application$")
    public void login() throws Throwable {
        System.out.println("Login to application");
        Assert.assertTrue(true);
    }

    @When("^Enter name (.*) on registration form$")
    public void enterName(String name) throws Throwable {
        System.out.println(": : " + name + ": : " + name + ": : ");

        clickOn("landingScreen","startUserRegistration");
        enterText("registrationScreen","inputUsername", name);
    }

    @Then("^The Entered name (.*) should display on registration page$")
    public void doAssertion(String expectedName) throws Throwable {
        String actualName = readText("registrationScreen","inputUsername");
        assertEquals(expectedName, actualName);
    }


    @When("^Fill the registration form with details name (.*), email (.*), password (.*), userID (.*), language (.*) and (.*)$")
    public void userLogin(String name, String email,String password, String userID,String progLanguage, Boolean acceptAdds) throws Throwable {
        System.out.println(": : " + name + ": : " + email + ": : ");
        System.out.println(": : " + password + ": : " + userID + ": : ");

        clickOn("landingScreen","startUserRegistration");
        enterText("registrationScreen","inputUsername", name);
        enterText("registrationScreen","inputEmail", email);
        enterText("registrationScreen","inputPassword", password);
        enterText("registrationScreen","userID", userID);
        selectByText("registrationScreen","preferedProgrammingLanguage", progLanguage);
        clickOn("registrationScreen","acceptAdds");
        clickOn("registrationScreen","btnRegisterUser");
        clickOn("registrationScreen","buttonRegisterUser");
    }

    @After
    public void endTest(Scenario scenario){
        System.out.println("----------After----------");
        MobileApp.report.endTest(MobileApp.logger);
        String scrFile = ((TakesScreenshot) MobileApp.getDriver()).getScreenshotAs(OutputType.BASE64);
        MobileApp.logger.addBase64ScreenShot(scrFile);
    }
}
