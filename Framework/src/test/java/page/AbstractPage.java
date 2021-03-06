package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 30;

    public AbstractPage closeCookiesMessage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='optanon-alert-box-close banner-close-button']")))
                .click();
        return this;
    }

    public String getLoggedAccountFirstName() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='user-account']")))
                .getText()
                .replace("Welcome, ","");
    }

    public AbstractPage logout() {
        clickButtonByXpath(By.xpath("//a[@class='logout']"));
        return this;
    }

    protected WebElement getElementLocatedBy(By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickButtonByXpath(By by) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }

    protected void sendKeysByXpath(By by, String keys) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .sendKeys(keys);
    }

    public int getNumberOfItemsInCart() {
        return Integer.parseInt(new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='mini-cart-quantity-bag']")))
                .getAttribute("textContent"));
    }

    protected ExpectedCondition<Boolean> PageLoaded() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
    }
}
