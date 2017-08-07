package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by bsc4518 on 7/4/2017.
 */
public class Locator implements ILocate {


    public Locator(){}

    String typeOfLocator;
    String attributeValue;

    @Override
    public Locator setTypeOfLocator(String typeOfLocator) {
        this.typeOfLocator  = typeOfLocator;
        return this;
    }

    @Override
    public Locator setAttributeValue(String attributeValue) {
        this.attributeValue  = attributeValue;
        return this;
    }

    @Override
    public String getTypeOfLocator() {
        return this.typeOfLocator;
    }

    @Override
    public String getAttributeValue() {
        return this.attributeValue;
    }

    @Override
    public By getByLocator() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        By byLocator = null;
//        Class<By> cls = (Class<By>) Class.forName("org.openqa.selenium.By");
//        Method m = cls.getMethod(this.typeOfLocator, String[].class);
//        String[] params = {this.attributeValue};

        if(this.typeOfLocator.equals("id")){
            byLocator =  By.id(this.attributeValue);
        }else if(this.typeOfLocator.equals("css")){
            byLocator =  By.cssSelector(this.attributeValue);
        }

//        return (By) m.invoke(null, (Object) params);
        return byLocator;
    }

    @Override
    public WebElement getWebElement(WebDriver driver) {

        WebElement webElement = null;

//        Class<By> cls = (Class<By>) Class.forName("org.openqa.selenium.By");
//        Method m = cls.getMethod(this.typeOfLocator, String[].class);
//        String[] params = {this.attributeValue};

        if(this.typeOfLocator.equals("id")){
            webElement =  driver.findElement(By.id(this.attributeValue));
        }else if(this.typeOfLocator.equals("css")){
            webElement =  driver.findElement(By.cssSelector(this.attributeValue));
        }


//        return driver.findElement((By) m.invoke(null, (Object) params));
        return webElement;
    }

    public String toString() {
        return this.typeOfLocator  +" :  "+this.attributeValue;
    }
}
