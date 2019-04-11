package selenium.core;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    

    protected WebDriver driver;

    public abstract void createWebDriver();

    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver() {
        if(driver == null) {
            createWebDriver();
        }
        return this.driver;
    }

}