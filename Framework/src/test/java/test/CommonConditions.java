package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import driver.DriverSingleton;
import org.testng.annotations.BeforeTest;

public class CommonConditions {
    protected WebDriver driver;

    @BeforeTest()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
