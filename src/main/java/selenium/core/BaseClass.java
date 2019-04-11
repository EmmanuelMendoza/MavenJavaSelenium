package selenium.core;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import resources.TestData;

public class BaseClass {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected DriverManager driverManager;
    protected ExtentReports extent;

    /**
     * Extent report html reporter configuration
     */
    static {
        System.setProperty("extent.reporter.html.start", "true");
        System.setProperty("extent.reporter.html.config", "html-config.xml");
        System.setProperty("extent.reporter.html.out", "test-output/HTMLReport/Amazon MX Suite.html");
        System.setProperty("extent.reporter.html.setAutoCreateRelativePathMedia", "true");
    }


    /**
     * Initializes the WebDriver and WebDriverWait instances
     */
    @BeforeSuite
    public void setUp() {
        //initReporter();
        driverManager = DriverManagerFactory.getDriverManager(DriverType.valueOf(TestData.browser));
        driver = driverManager.getWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        driver.get(TestData.BASE_URL);
    }

    /**
     * Quits the running WebDriver instance
     */
    @AfterSuite
    public void tearDown() {
        driverManager.quitWebDriver();
    }

    /**
     * 
     * @return the running WebDriver instance
     */
    public WebDriver getWebDriver() {
        return this.driverManager.getWebDriver();
    }


    /**
     * 
     * @return the WebDriverWait instance
     */
    public WebDriverWait getWebDriverWait() {
        return this.wait;
    }
}