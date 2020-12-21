package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatfootwearItemPage extends AbstractPage {

    private final String PAGE_URL = "https://www.catfootwear.com/US/en/excavator-superlite-waterproof-nano-toe-work-boot/44904M.html?dwvar_44904M_color=P91196";

    @FindBy(id = "add-to-cart")
    private WebElement addToCartButton;

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

    public Boolean areWidthAndSizeSelected() {
        addToCartButton.click();
        return !(cartMessageTip.isDisplayed());
    }
}
