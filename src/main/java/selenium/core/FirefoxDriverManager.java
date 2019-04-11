package selenium.core;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
    }
    
}