package page;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatfootwearCartPage extends AbstractPage {

    private final String PAGE_URL = "https://www.catfootwear.com/US/en/cart";

    // //button[@class='button-text remove-item']

    public CatfootwearCartPage(WebDriver driver) {
        super(driver);
    }

    public CatfootwearCartPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public double getOrderPrice() {
        return Double.parseDouble(getElementLocatedBy(By.xpath("//tr[@class='order-subtotal']/td[@class='textalign-right']"))
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

        return type.replace("Shipping ", "")
                .substring(0, type.indexOf(',') - 3);
    }

    public CatfootwearCartPage applyPromocode(String promocode) {
        clickButtonByXpath(By.xpath("//a[@aria-controls='promo-code-content']"));
        sendKeysByXpath(By.id("dwfrm_cart_couponCode"), promocode);
        clickButtonByXpath(By.id("add-coupon"));
        return this;
    }
}