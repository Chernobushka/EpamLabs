package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import model.*;

public class CatfootwearItemPage extends AbstractPage {

    //https://www.catfootwear.com/US/en/excavator-superlite-waterproof-nano-toe-work-boot/194713401701.html


    private final String PAGE_URL = "https://www.catfootwear.com/US/en/excavator-superlite-waterproof-nano-toe-work-boot/44904M.html?dwvar_44904M_color=P91196";

    private Item item;

    public CatfootwearItemPage(WebDriver driver) {
        super(driver);
    }

    public CatfootwearItemPage closeCookiesMessage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='optanon-alert-box-close banner-close-button']")))
                .click();
        return this;
    }

    public CatfootwearItemPage openPage(Item item) {
        this.item = item;
        driver.get(item.getUrl());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public CatfootwearItemPage openWidthAndSizeMenu() {
        clickButtonByXpath(By.xpath("//div/a[@href='#' and @role='button']"));
        return this;
    }

    public CatfootwearItemPage selectSize() {
        // //*[@id='swatch-size-11']
        clickButtonByXpath(By.id("swatch-size-" + item.getSize()));
        return this;
    }

    public CatfootwearItemPage selectWidth() {
        // //*[@id='swatch-width-M']
        clickButtonByXpath(By.id("swatch-width-" + item.getWidth().toUpperCase()));
        return this;
    }

    public int getNumberOfItemsInCart() {
        return Integer.parseInt(new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='mini-cart-quantity-bag']")))
                .getAttribute("textContent"));
    }

    public CatfootwearItemPage selectItem() {
        clickButtonByXpath(By.id("add-to-cart"));
        return this;
    }
}
