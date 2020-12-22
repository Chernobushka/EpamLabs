package page;

import model.CreditCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatfootwearWalletPage extends AbstractPage {

    private final String PAGE_URL = "https://www.catfootwear.com/US/en/wallet";

    public CatfootwearWalletPage(WebDriver driver) {
        super(driver);
    }

    public CatfootwearWalletPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public CatfootwearWalletPage addCreditCard(CreditCard card) {
        clickButtonByXpath(By.xpath("//a[@data-dlg-options='{ \"classes.ui-dialog\" : \"hidden-title\", \"title\" : \"Add a Credit Card\" }']"));
        sendKeysByXpath(By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_owner"), card.getNameOnCard());
        sendKeysByXpath(By.xpath("//input[contains(@id, 'dwfrm_paymentinstruments_creditcards_newcreditcard_number')]"), card.getCardNumber());

        clickButtonByXpath(By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_month"));
        sendKeysByXpath(By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_month"), card.getExpirationDateMonth());

        clickButtonByXpath(By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_year"));
        sendKeysByXpath(By.id("dwfrm_paymentinstruments_creditcards_newcreditcard_year"), card.getExpirationDateYear());

        clickButtonByXpath(By.id("applyBtn"));

        return this;
    }

    public String getDefaultPaymentMethod() {
        return getElementLocatedBy(By.xpath("//li[@class=' first   default']"))
                .getText();
    }
}
