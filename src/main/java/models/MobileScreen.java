package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

/**
 * Created by bsc4518 on 7/4/2017.
 */
public class MobileScreen {

    MobileScreen mobileScreen;
    String pageName;
    Map<String, Locator> locator;


    public MobileScreen(){}

     public MobileScreen setPageName(String pageName){
         this.pageName = pageName;
         this.mobileScreen = new MobileScreen();
         return this.mobileScreen;
     }

    public MobileScreen setLocator(String givenLocatorName, Locator locate){

        if(locate.typeOfLocator != null && !locator.containsKey(givenLocatorName)){
            locator.put(givenLocatorName, new Locator().setTypeOfLocator(locate.typeOfLocator).setAttributeValue(locate.attributeValue));
        }
        return this.mobileScreen;
    }

    public Locator getLocator(String givenLocatorName){
        Locator locate = null;    
        
        if(locator.containsKey(givenLocatorName)){
            locate = locator.get(givenLocatorName);
        }
        return locate;
    }

    public WebElement getElement(String attribute, WebDriver driver) {
        Locator locate = null;

        if(locator.containsKey(attribute)){
            locate = locator.get(attribute);
        }
        return locate.getWebElement(driver);
    }

    public MobileScreen getPage(String pageName){
        return this.mobileScreen;
    }

    public String getPageName(){
        return this.pageName;
    }

}
