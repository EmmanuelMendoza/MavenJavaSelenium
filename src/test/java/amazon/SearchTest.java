package amazon;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import po.ResultsPage;
import resources.TestData;
import selenium.core.BaseClass;

public class SearchTest extends BaseClass {
    
    protected ResultsPage rp;

    @BeforeClass
    public void initHelpers() {
        rp = new ResultsPage(getWebDriver(), getWebDriverWait());
    }

    @Test(enabled = true, priority = 0)
    public void searchByDepartmentText() {
        rp.searchProductByDepartment(TestData.searchTerm, TestData.departmentText);
        Assert.assertTrue(rp.getSearchTermFromResultsLabel().contains(TestData.searchTerm));
    }
    

    @Test(enabled = true, priority = 1)
    public void searchByDepartmentValue() {
        rp.setDepartmentByValue(TestData.departmentValue);
        rp.clearSearchBox();
        rp.inputSearchTerm(TestData.searchTerm);
        rp.clickSearchButton();
        Assert.assertTrue(rp.getSearchTermFromResultsLabel().contains(TestData.searchTerm));
    }


    @Test(enabled = true, priority = 2)
    public void searchAllDepartments() {
        rp.searchProductAllDepartments(TestData.searchTerm);
        Assert.assertTrue(rp.getSearchTermFromResultsLabel().contains(TestData.searchTerm));
    }

    @Test(enabled = true, priority = 3)
    public void FailedTest() {
        rp.searchProductAllDepartments(TestData.searchTerm);
        Assert.assertTrue(rp.getSearchTermFromResultsLabel().contains("NonExistingString"));
    }
}