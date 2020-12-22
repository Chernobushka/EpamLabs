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
        clickButtonByXpath(By.id("swatch-size-" + item.getSize()));
        return this;
    }

    public CatfootwearItemPage selectWidth() {
        clickButtonByXpath(By.id("swatch-width-" + item.getWidth().toUpperCase()));
        return this;
    }

    public boolean isAvailable() {
        WebElement button = driver.findElement(By.id("out-of-stock-cta"));
        return !(button.isDisplayed());
    }

    public CatfootwearCartPage selectItem() {
        clickButtonByXpath(By.id("add-to-cart"));
        return new CatfootwearCartPage(driver)
                .openPage();
    }
}
