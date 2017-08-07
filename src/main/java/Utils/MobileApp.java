package Utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import models.MobileScreen;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by bsc4518 on 7/25/2017.
 */
public class MobileApp {
    private static MobileApp ourInstance = null;
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static final  Map<String, MobileScreen> MobileScreens = new HashMap<>();
    public static final DesiredCapabilities capabilities = new DesiredCapabilities();
    String filePath = System.getProperty("user.dir") + "/src/main/resources/PageObjects/";

    public static ExtentReports report = null;
    public static ExtentTest logger = null;

    private MobileApp(DesiredCapabilities... params) throws Throwable {
        setDriver(params);
        MobileScreens.putAll(getAllPages(filePath));
    }

    public static MobileApp getInstance() throws Throwable {
        if (ourInstance == null) {
            ourInstance = new MobileApp();
            System.out.println("**********************Session id created********************** new session id : "+((RemoteWebDriver) driver.get()).getSessionId());
        }

        if(ourInstance != null &&  ((RemoteWebDriver) driver.get()).getSessionId() == null){
            ourInstance = new MobileApp();
            System.out.println("**********************Session id killed and new session created********************** new session id : "+((RemoteWebDriver) driver.get()).getSessionId());
        }

        return ourInstance;
    }

    private void setDriver(DesiredCapabilities... params) throws IOException {
        driver.set(getAndroidDriverThreadLocal(params).get());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        if (getDriver() != null) {
            try {
                getDriver().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                getDriver().quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.remove();
    }

    private static ThreadLocal<WebDriver> getAndroidDriverThreadLocal(DesiredCapabilities... params) throws IOException {
        final Properties prop = new Properties();
        FileInputStream input = new FileInputStream("src/main/resources/config.properties");
        prop.load(input);

        System.out.println(prop.getProperty("appPath"));
        System.out.println(prop.getProperty("application"));
        System.out.println(prop.getProperty("device"));
        System.out.println(prop.getProperty("platform"));
        System.out.println(prop.getProperty("appiumServer"));

        System.out.println("********************InIt initiated ************");
        File appDir = new File(prop.getProperty("appPath"));
        File app = new File(appDir, prop.getProperty("application"));

        //mandatory capabilities
        capabilities.setCapability("deviceName", prop.getProperty("device"));
//        capabilities.setCapability("deviceName", "ba99f4b7");
        capabilities.setCapability("platformName", prop.getProperty("platform"));
        capabilities.setCapability("app", app.getAbsolutePath());
        //capabilities.setCapability("noReset",false);

        return new ThreadLocal<WebDriver>() {
            @Override
            protected WebDriver initialValue() {
                AndroidDriver<WebElement> androidDriver = null;
                try {
                    androidDriver = new AndroidDriver<WebElement>(new URL(prop.getProperty("appiumServer")), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return androidDriver;
            }
        };
    }

    private static Map<String, MobileScreen> getAllPages(String filePath) throws Throwable {
        Map<String, MobileScreen> pages = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            Iterator it = FileUtils.iterateFiles(new File(filePath), new String[]{"yaml"}, false);

            while (it.hasNext()) {
                File file = (File) it.next();
                MobileScreen mobileScreen = getPage(file);

                System.out.println("Name of the file : "+file.getName());
                System.out.println("****** :- " + mobileScreen.getPageName());
                System.out.println(ReflectionToStringBuilder.toString(mobileScreen, ToStringStyle.MULTI_LINE_STYLE));

                pages.put(mobileScreen.getPageName(), mobileScreen);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e.getCause();
        }
        return pages;
    }

    private static MobileScreen getPage(File file) throws Throwable {
        MobileScreen mobileScreen;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            mobileScreen = mapper.readValue(file, MobileScreen.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw e.getCause();
        }
        return mobileScreen;
    }

    private static Boolean isSessionEmpty(){
        Boolean isEmpty = false;

        SessionId session =  ((AndroidDriver)getDriver()).getSessionId();
        if(session == null){
            isEmpty = true;
        }else{
            isEmpty = false;
        }

        return isEmpty;
    }
}
