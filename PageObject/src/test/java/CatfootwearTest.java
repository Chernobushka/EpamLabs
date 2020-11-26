import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.catfootwear.CatfootwearAccountPage;
import pageobject.catfootwear.CatfootwearItemPage;

public class CatfootwearTest {

    private WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test
    public void addToCartWithoutSelectingSizeOrWidth() {
        Boolean widthAndSizeSelected = new CatfootwearItemPage(driver)
                .openPage()
                .closePopUps()
                .areWidthAndSizeSelected();
        Assert.assertFalse(widthAndSizeSelected, "Width and Size were selected!");
    }

    @Test
    public void loginWithBadEmailAndPassword() {
        Boolean canLogin = new CatfootwearAccountPage(driver)
                .openPage()
                .setEmail("qwe@asd.com")
                .setPassword("qweqwe")
                .canLogin();
        Assert.assertFalse(canLogin, "Login and Password were correct!");
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
