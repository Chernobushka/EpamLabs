import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.*;

public class WebDriverTest {

    @Test
    public void addToCartWithoutSelectingSizeOrWidth() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.catfootwear.com/US/en/excavator-superlite-waterproof-nano-toe-work-boot/44904M.html?dwvar_44904M_color=P91196#cgid=mens-boots&start=1");

        WebElement addToCartButton = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart")));
        Actions moveToButton = new Actions(driver);
        moveToButton.moveToElement(addToCartButton);
        moveToButton.perform();
        WebElement closeCookies = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='optanon-alert-box-close banner-close-button']")));
        closeCookies.click();
        addToCartButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='cartMessageTip']")).isDisplayed(),
                "Message window did not show!");
        driver.quit();
    }

}
