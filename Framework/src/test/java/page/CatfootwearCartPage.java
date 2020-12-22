package page;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class CatfootwearCartPage extends AbstractPage {

    private final String PAGE_URL = "https://www.catfootwear.com/US/en/cart";

    // //button[@class='button-text remove-item']
    // //h3[@class='coupon-applied']
    // //div[contains(text(),'Express')]


    public CatfootwearCartPage(WebDriver driver) {
        super(driver);
    }

    public CatfootwearCartPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public double getExpressShippingPrice() {
        String price = getElementLocatedBy(By.xpath("//div[contains(text(),'Express')]"))
            .getText();
        if (price.contains("FREE"))
            return 0;
        else
            return Double.parseDouble(price.substring(11));

    }

    public double getOrderPrice() {
        return Double.parseDouble(getElementLocatedBy(By.xpath("//tr[@class='order-total']/td[@class='textalign-right']"))
            .getText()
            .replace("$",""));
    }

    public double getShippingPrice() {
        return Double.parseDouble(getElementLocatedBy(By.xpath("//tr[@class='order-shipping']/td[@class='textalign-right']"))
            .getText()
            .replace("$",""));
    }

    public String getShippingType() {
        String type = getElementLocatedBy(By.xpath("//tr[@class='order-shipping']/td[1]"))
                .getText();

        return type.replace("Shipping ", "");
    }

    public CatfootwearCartPage applyPromocode(String promocode) {
        clickButtonByXpath(By.xpath("//a[@aria-controls='promo-code-content']"));
        sendKeysByXpath(By.id("dwfrm_cart_couponCode"), promocode);
        clickButtonByXpath(By.id("add-coupon"));
        return this.openPage();
    }

    public CatfootwearCartPage deleteItem(int number) {
        List<WebElement> elements = driver.findElements(By.xpath("//button[@class='button-text remove-item']"));
        elements.get(number - 1).click();
        return this;
    }

    public CatfootwearCartPage clearCart() {
        List<WebElement> elements = driver.findElements(By.xpath("//button[@class='button-text remove-item']"));
        for (WebElement x : elements) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.visibilityOf(x))
                    .click();
        }
        return this;
    }
}
