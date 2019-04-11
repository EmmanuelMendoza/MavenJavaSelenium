package selenium.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericMethods {
    
    protected WebDriver driver;

    /**
     * Throws an exception when trying to instanciate the class without a WebDriver reference
     */
    public GenericMethods() {
        throw new IllegalStateException("WebDriver not especified,\n Expected use: new GenericMethods(WebDriver)");
    }

    /**
     * Initializes a GenericMethods instance
     * @param driver
     */
    public GenericMethods(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Sets the text into the specified WebElement
     * @param element
     * @param text
     */
    public void setElementText(WebElement element, String text) {
        try{
            Utilities.fnHighlightMe(driver, element);
            element.sendKeys(text);
        }catch (NoSuchElementException e){
            // log error
        }catch (Exception e) {
            // log error
        }
        
    }

    /**
     * Clears the text of the specified WebElement
     * @param element
     */
    public void clearElementText(WebElement element) {
        try{
            Utilities.fnHighlightMe(driver, element);
            element.clear();;
        }catch (NoSuchElementException e){
            // log error
        }catch (Exception e) {
            // log error
        }
        
    }

    /**
     * 
     * @param element
     * @return The text of the specified WebElement
     */
    public String getElementText(WebElement element) {
        String text = "";
        try {
            Utilities.fnHighlightMe(driver, element);
            text = element.getText();
        }catch (NoSuchElementException e) {
            // log error
        }catch (Exception e) {
            // log error
        }

        return text;

    }

    /**
     * Clicks on the specified WebElement
     * @param element
     */
    public void clickOnElement(WebElement element) {

        try {
            Utilities.fnHighlightMe(driver, element);
            element.click();
        }catch (NoSuchElementException e) {
            // log error
        }catch (Exception e) {
            // log error
        }
    }

    /**
     * Sets the value of a dropdown element to the specified visible text
     * @param element
     * @param visibleText
     */
    public void setDropDownByVisibleText(WebElement element, String visibleText) {
        try {
            Utilities.fnHighlightMe(driver, element);
            Select sel = new Select(element);
            sel.selectByVisibleText(visibleText);
        }catch (NoSuchElementException e) {
            // log error
        }catch (Exception e) {
            // log error
        }
    }

    /**
     * Sets the value of a dropdown element to the specified value
     * @param element
     * @param value
     */
    public void setDropDownByValue(WebElement element, String value) {
        try {
            Utilities.fnHighlightMe(driver, element);
            Select sel = new Select(element);
            sel.selectByValue(value);
        }catch (NoSuchElementException e) {
            // log error
        }catch (Exception e) {
            // log error
        }
    }


}