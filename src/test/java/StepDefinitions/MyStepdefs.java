package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bsc4518 on 7/14/2017.
 */
public class MyStepdefs {
    protected AndroidDriver driver;
    public static final String USERNAME = "tejasjog1";
    public static final String AUTOMATE_KEY = "kyrrFA2kZSULdvFAxKVN";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Given("^Connect to Appium server in order to created web driver instance$")
    public void setUP() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Ashok");
        Assert.assertTrue(true);

        prepareAndroidForAppium();
    }

    @When("^Enter the form details with name (.*), email (.*), password (.*), userID (.*)$")
    public void formFilling(String name, String email, String password, String userID) throws Throwable {
        System.out.println(": : " + name + ": : " + email + ": : " + password + ": : " + userID);

        fillForm(name, email, password, userID);
    }

    @Given("^Connect to Appium server in order to created browser stack instance$")
    public void browserStackSetUP() throws Throwable {
        System.out.println("Ashok");
        Assert.assertTrue(true);
        connectToBrowserStack();
    }

    private void connectToBrowserStack() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "IE");
        caps.setCapability("browser_version", "7.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "XP");
        caps.setCapability("browserstack.debug", "true");


        WebDriver bsDriver = new RemoteWebDriver(new URL(URL), caps);
        bsDriver.get("http://www.google.com");

        WebElement element = bsDriver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(bsDriver.getTitle());

    }

    protected void prepareAndroidForAppium() throws MalformedURLException {
        File appDir = new File("C:\\Users\\bsc4518\\Downloads");
        File app = new File(appDir, "selendroid-test-app-0.17.0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //mandatory capabilities
        capabilities.setCapability("deviceName", "192.168.158.101:5555");
        capabilities.setCapability("platformName", "Android");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public void fillForm(String inputUsername, String inputEmail, String inputPassword, String inputName) {

        driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("ashok.melar@gmail.com");
        driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
        driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys(inputUsername);
        driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys(inputEmail);
        driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys(inputPassword);
        driver.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys(inputName);
    }
}
