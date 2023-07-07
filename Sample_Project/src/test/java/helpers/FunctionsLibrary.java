package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Properties;

import static org.junit.Assert.fail;


public class FunctionsLibrary {
    private WebDriver driver;

    public FunctionsLibrary(WebDriver driver) {
        this.driver = driver;
    }

    public static HashMap<String,String> ReadPropertiesFile() {
        File file = new File("config.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, String> AUT_Properties = new HashMap<String, String>();
        Enumeration KeyValues = prop.keys();
        while (KeyValues.hasMoreElements()) {
            String key = (String) KeyValues.nextElement();
            String value = prop.getProperty(key);
            AUT_Properties.put(key, value);
        }
        return AUT_Properties;
    }



    public void waitvisibilityOfElement(WebElement element, long waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            fail("The element is still not present");
        }
    }


    public void elementClick(WebElement element) {
        try {
            waitvisibilityOfElement(element,45);
            if(isElementPresent(element)) {
                waitElementToBeClickable(element);
                element.click();
            }
        } catch (Exception e) {
            fail("The element is not found");
        }
    }


    public void elementSendKeys(WebElement element, String data) {
        try {
            waitElementToBeClickable(element);
            element.clear();
            element.sendKeys(data);
        } catch (NoSuchElementException e) {
            fail("Textbox element is not present");
        } catch (Exception e) {
            fail("The textbox can not be edited");
        }
    }

    public boolean isElementPresent(WebElement element) {
        boolean blnResult = false;
        if (element.isDisplayed())
        {blnResult = true;}
        else
        {blnResult = false;}
        return blnResult;
    }

    public void waitElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (NoSuchElementException e) {
            fail("Element "+element+" is not present");
        } catch (Exception e) {
            fail("Wait for the element "+element+" is not working");
        }
    }

}
