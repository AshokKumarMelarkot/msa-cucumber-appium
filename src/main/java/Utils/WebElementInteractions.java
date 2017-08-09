package Utils;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.Date;

/**
 * Created by bsc4518 on 7/25/2017.
 */
public class WebElementInteractions extends Assert {

    String filePath = System.getProperty("user.dir") + File.separator+ "target"+File.separator+ "screenshots";

    protected void clickOn(String screen, String locatorName) throws Throwable {
        long timeStamp = new Date().getTime();

        try {
            MobileApp.MobileScreens.get(screen).getElement(locatorName, MobileApp.getDriver()).click();
            MobileApp.logger.log(LogStatus.PASS, "Clicked on " + locatorName + " in " + screen);
        } catch (NullPointerException e) {
            FileUtils.copyFile(((TakesScreenshot) MobileApp.getDriver()).getScreenshotAs(OutputType.FILE), new File(filePath + File.separator + "screenshot_" + timeStamp + ".png"));

            MobileApp.logger.log(LogStatus.FAIL, "Unable to find element " + locatorName + " in " + screen , MobileApp.logger.addScreenCapture(filePath+File.separator+"screenshot_" + timeStamp + ".png"));

            throw e.getCause();
        } catch (Exception e) {
            FileUtils.copyFile(((TakesScreenshot) MobileApp.getDriver()).getScreenshotAs(OutputType.FILE), new File(filePath + File.separator + "screenshot_" + timeStamp + ".png"));

            MobileApp.logger.log(LogStatus.FAIL, "Failed to click element " + locatorName + " in " + screen, MobileApp.logger.addScreenCapture(filePath+File.separator+"screenshot_" + timeStamp + ".png"));
            throw e.getCause();
        }
    }

    protected void enterText(String screen, String locatorName, String text) throws Throwable {
        long timeStamp = new Date().getTime();


        try {
            MobileApp.MobileScreens.get(screen).getElement(locatorName, MobileApp.getDriver()).clear();
            MobileApp.MobileScreens.get(screen).getElement(locatorName, MobileApp.getDriver()).sendKeys(text);
            MobileApp.logger.log(LogStatus.PASS, "Entered text " + text + " for " + locatorName + " in " + screen);
        } catch (NullPointerException e) {
            FileUtils.copyFile(((TakesScreenshot) MobileApp.getDriver()).getScreenshotAs(OutputType.FILE), new File(filePath + File.separator + "screenshot_" + timeStamp + ".png"));

            MobileApp.logger.log(LogStatus.FAIL, "Unable to find element " + locatorName + " in " + screen , MobileApp.logger.addScreenCapture(filePath+File.separator+"screenshot_" + timeStamp + ".png"));

            throw e.getCause();
        } catch (Exception e) {
            FileUtils.copyFile(((TakesScreenshot) MobileApp.getDriver()).getScreenshotAs(OutputType.FILE), new File(filePath + File.separator + "screenshot_" + timeStamp + ".png"));

            MobileApp.logger.log(LogStatus.FAIL, "Failed to enterText text " + text + " on element " + locatorName + " in " + screen , MobileApp.logger.addScreenCapture(filePath+File.separator+"screenshot_" + timeStamp + ".png"));
            throw e.getCause();
        }
    }

    protected void selectByText(String screen, String locatorName, String text) throws Throwable {
        long timeStamp = new Date().getTime();


        try {
            MobileApp.MobileScreens.get(screen).getElement(locatorName, MobileApp.getDriver()).click();
            MobileApp.getDriver().findElement(By.xpath("//*[@text='"+text+"']")).click();

            MobileApp.logger.log(LogStatus.PASS, "Selected text " + text + " for " + locatorName + " in " + screen);
        } catch (NullPointerException e) {
            FileUtils.copyFile(((TakesScreenshot) MobileApp.getDriver()).getScreenshotAs(OutputType.FILE), new File(filePath + File.separator + "screenshot_" + timeStamp + ".png"));

            MobileApp.logger.log(LogStatus.FAIL, "Unable to find element " + locatorName + " in " + screen , MobileApp.logger.addScreenCapture(filePath+File.separator+"screenshot_" + timeStamp + ".png"));
            throw e.getCause();
        } catch (Exception e) {
            FileUtils.copyFile(((TakesScreenshot) MobileApp.getDriver()).getScreenshotAs(OutputType.FILE), new File(filePath + File.separator + "screenshot_" + timeStamp + ".png"));

            MobileApp.logger.log(LogStatus.FAIL, "Failed to select value " + text + " on element " + locatorName + " in " + screen , MobileApp.logger.addScreenCapture(filePath+File.separator+"screenshot_" + timeStamp + ".png"));
            throw e.getCause();
        }
    }

    protected String readText(String screen, String locatorName) throws Throwable {
        long timeStamp = new Date().getTime();
        String text = "";

        try {
            text = MobileApp.MobileScreens.get(screen).getElement(locatorName, MobileApp.getDriver()).getText();
            MobileApp.logger.log(LogStatus.PASS, "Returned  text for locator " + locatorName + " in " + screen);
        } catch (NullPointerException e) {
            FileUtils.copyFile(((TakesScreenshot) MobileApp.getDriver()).getScreenshotAs(OutputType.FILE), new File(filePath + File.separator + "screenshot_" + timeStamp + ".png"));

            MobileApp.logger.log(LogStatus.FAIL, "Unable to find element " + locatorName + " in " + screen , MobileApp.logger.addScreenCapture(filePath+File.separator+"screenshot_" + timeStamp + ".png"));
            throw e.getCause();
        } catch (Exception e) {
            FileUtils.copyFile(((TakesScreenshot) MobileApp.getDriver()).getScreenshotAs(OutputType.FILE), new File(filePath + File.separator + "screenshot_" + timeStamp + ".png"));

            MobileApp.logger.log(LogStatus.FAIL, "Failed to read value of element " + locatorName + " in " + screen , MobileApp.logger.addScreenCapture(filePath+File.separator+"screenshot_" + timeStamp + ".png"));
            throw e.getCause();
        }

        return text;
    }


}
