package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatfootwearRegisterPage extends AbstractPage{

    private final String PAGE_URL = "https://www.catfootwear.com/US/en/register";

    public CatfootwearRegisterPage(WebDriver driver) {
        super(driver);
    }

    public CatfootwearRegisterPage closeCookiesMessage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='optanon-alert-box-close banner-close-button']")))
                .click();
        return this;
    }

    public CatfootwearRegisterPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public CatfootwearRegisterPage register(User user) {
        sendKeysByXpath(By.id("dwfrm_profile_customer_firstname"), user.getFirstName());
        sendKeysByXpath(By.id("dwfrm_profile_customer_lastname"), user.getLastName());
        sendKeysByXpath(By.id("dwfrm_profile_customer_zip"), user.getZipCode());
        sendKeysByXpath(By.id("dwfrm_profile_customer_email"), user.getEmail());
        sendKeysByXpath(By.id("dwfrm_profile_customer_emailconfirm"), user.getEmail());
        sendKeysByXpath(By.id("dwfrm_profile_login_password"), user.getPassword());
        sendKeysByXpath(By.id("dwfrm_profile_login_passwordconfirm"), user.getPassword());

        clickButtonByXpath(By.id("dwfrm_profile_verification_termsandconditions"));
        clickButtonByXpath(By.id("dwfrm_profile_verification_ageverification"));

        clickButtonByXpath(By.xpath("//button[@value='Complete Registration']"));

        return this;
    }
}
