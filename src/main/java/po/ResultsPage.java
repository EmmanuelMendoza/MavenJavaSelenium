package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage extends MainComponents {

    protected WebDriverWait wait;

    @FindBy(xpath = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]")
    WebElement resultsContainer;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    WebElement lblResult;
    
    public ResultsPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        this.wait = wait;
    }

    /**
     * Waits for the results list to be displayed
     */
    public void waitForResults() {
        wait.until(ExpectedConditions.visibilityOf(resultsContainer));
    }

    /**
     * 
     * @return The text on the results label
     */
    public String getSearchTermFromResultsLabel() {
        return gm.getElementText(lblResult);
    }
    
}