package pageobject.catfootwear;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Page;

public class CatfootwearAccountPage extends Page {

    private final String PAGE_URL = "https://www.catfootwear.com/US/en/account";

    @FindBy(id = "account-login-btn")
    private WebElement loginButton;
    @FindBy(xpath = "//input[@class='input-text email-input required']")
    private WebElement emailBox;
    @FindBy(id = "dwfrm_login_password")
    private WebElement passwordBox;
    @FindBy(xpath = "//div[@class='errormessage']")
    private WebElement FailedLoginAttemptErrorMessage;


    @FindBy(xpath = "//button[@class='optanon-alert-box-close banner-close-button']")
    private WebElement closeCookiesMessageButton;
    @FindBy(id = "yie-close-button-1a46e2c2-4310-5df6-9f8a-34ff5a4bee68")
    private WebElement closeAdButton;


    public CatfootwearAccountPage(WebDriver driver) {
        super(driver);
    }

    public CatfootwearAccountPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public CatfootwearAccountPage closePopUps() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(closeCookiesMessageButton));
        closeCookiesMessageButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(closeAdButton));
        closeAdButton.click();
        return this;
    }

    public CatfootwearAccountPage setEmail(String email)
    {
        emailBox.sendKeys(email);
        return this;
    }

    public CatfootwearAccountPage setPassword(String password)
    {
        passwordBox.sendKeys(password);
        return this;
    }

    public Boolean canLogin() {
        loginButton.click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());

        return !(FailedLoginAttemptErrorMessage.isDisplayed());
    }
}
