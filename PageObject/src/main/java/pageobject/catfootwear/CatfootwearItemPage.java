package pageobject.catfootwear;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class CatfootwearItemPage extends Page {

    private final String PAGE_URL = "https://www.catfootwear.com/US/en/excavator-superlite-waterproof-nano-toe-work-boot/44904M.html?dwvar_44904M_color=P91196#cgid=mens-boots&start=1";

    @FindBy(id = "add-to-cart")
    private WebElement addToCartButton;
    @FindBy(xpath = "//button[@class='optanon-alert-box-close banner-close-button']")
    private WebElement closeCookiesMessageButton;
    @FindBy(id = "yie-close-button-1a46e2c2-4310-5df6-9f8a-34ff5a4bee68")
    private WebElement closeAdButton;
    @FindBy(xpath = "//div[@class='cartMessageTip']")
    private WebElement cartMessageTip;

    public CatfootwearItemPage(WebDriver driver) {
        super(driver);
    }

    public CatfootwearItemPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }


    public CatfootwearItemPage closePopUps() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(closeCookiesMessageButton));
        closeCookiesMessageButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(closeAdButton));
        closeAdButton.click();
        return this;
    }

    public Boolean areWidthAndSizeSelected() {
        Actions moveToButton = new Actions(driver);
        moveToButton.moveToElement(addToCartButton);
        moveToButton.perform();
        addToCartButton.click();
        return !(cartMessageTip.isDisplayed());
    }

}
