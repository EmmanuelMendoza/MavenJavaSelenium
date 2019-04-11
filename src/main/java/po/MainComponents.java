package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import selenium.utils.GenericMethods;

public class MainComponents {
    
    protected GenericMethods gm;       // Used to access the WebDriver generic methods utility

    @FindBy(id = "twotabsearchtextbox")
    WebElement txtSearchBar;

    @FindBy(id = "searchDropdownBox")
    WebElement ddDepartments;

    @FindBy(xpath = "//input[@value='Ir']")
    WebElement searchButton;

    /**
     * Initializes the MainComponents page receiving the WebDriver running instance
     * @param driver
     */
    public MainComponents(WebDriver driver) {
        PageFactory.initElements(driver, this);
        gm = new GenericMethods(driver);
    }

    /**
     * Sets the department dropdown element to All Departments
     */
    public void resetDepartment() {
        Select sel = new Select(ddDepartments);
        sel.selectByIndex(0);
    }

    /**
     * Select a department from the Departments dropwdown element using the visible department text
     * @param department
     */
    public void setDepartmentByVisibleText(String department) {
        gm.setDropDownByVisibleText(ddDepartments, department);
    }

    /**
     * Select a department from the Departments dropwdown element using the value argument
     * @param department
     */
    public void setDepartmentByValue(String department) {
        gm.setDropDownByValue(ddDepartments, department);
    }

    /**
     * Clears the text from the Search bar
     */
    public void clearSearchBox() {
        gm.clearElementText(txtSearchBar);
    }

    /**
     * Inputs the search term into the search bar
     * @param searchTerm
     */
    public void inputSearchTerm(String searchTerm) {
        gm.setElementText(txtSearchBar, searchTerm);
    }

    /**
     * Clicks on the Search button (magnifying glass icon)
     */
    public void clickSearchButton() {
        gm.clickOnElement(searchButton);
    }

    /**
     * Searches for a product in all departments
     * @param searchTerm
     */
    public void searchProductAllDepartments(String searchTerm) {
        resetDepartment();
        clearSearchBox();
        inputSearchTerm(searchTerm);
        clickSearchButton();

    }

    /**
     * Searches for a product in the specified department (by visible text)
     * @param searchTerm
     * @param department
     */
    public void searchProductByDepartment(String searchTerm, String department) {
        setDepartmentByVisibleText(department);
        clearSearchBox();
        inputSearchTerm(searchTerm);
        clickSearchButton();
    }
}