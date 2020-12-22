package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import driver.DriverSingleton;
import util.TestListener;

@Listeners({TestListener.class})
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
