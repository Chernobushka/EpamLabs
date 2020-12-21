package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatfootwearLoginPage extends AbstractPage{
    private final String PAGE_URL = "https://www.catfootwear.com/US/en/account";

    public CatfootwearLoginPage(WebDriver driver) {
        super(driver);
    }

    public CatfootwearLoginPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public CatfootwearLoginPage closeCookiesMessage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='optanon-alert-box-close banner-close-button']")))
                .click();
        return this;
    }

    public Boolean canLogin(User user) {
        sendKeysByXpath(By.xpath("//input[@class='input-text email-input required']"), user.getEmail());
        sendKeysByXpath(By.id("dwfrm_login_password"), user.getPassword());
        clickButtonByXpath(By.id("account-login-btn"));
        return true;
    }
}
