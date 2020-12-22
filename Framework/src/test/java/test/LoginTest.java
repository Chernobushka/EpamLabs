package test;

import javafx.scene.layout.Priority;
import model.CreditCard;
import model.Item;
import model.User;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import service.CardCreator;
import service.ItemCreator;
import service.UserCreator;


public class LoginTest extends CommonConditions{

    @Test(priority = 1)
    public void loginTest() {
        User testUser = UserCreator.withCredentialsFromProperty("first");
        String loggedUserFirstName = new CatfootwearLoginPage(driver)
                .openPage()
                .closeCookiesMessage()
                .login(testUser)
                .getLoggedAccountFirstName();
        Assert.assertEquals(testUser.getFirstName(),loggedUserFirstName);
    }

    //@Test(priority = 2)
    public void addItemToCartWithoutSelectingSizeOrWidth() {
        Item testItem = ItemCreator.withCredentialsFromProperty("first");
        CatfootwearItemPage page = new CatfootwearItemPage(driver)
                .openPage(testItem)
                .closeCookiesMessage();
        int numberOfItemsInCartBefore = page.getNumberOfItemsInCart();
        page.selectItem();
        int numberOfItemsInCartAfter = page.getNumberOfItemsInCart();


        Assert.assertEquals(numberOfItemsInCartAfter, numberOfItemsInCartBefore + 1);
    }
    //@Test(priority = 2)
    public void test1() {
        CatfootwearCartPage page = new CatfootwearCartPage(driver)
                .openPage();
        System.out.println(page.getOrderPrice());
        System.out.println(page.getShippingPrice());
        System.out.println(page.getShippingType());

        page.applyPromocode("SECRET20");
    }
    //@Test
    public void test2() {
        User testUser = UserCreator.withCredentialsFromProperty("first");
        String loggedUserFirstName = new CatfootwearRegisterPage(driver)
                .openPage()
                .closeCookiesMessage()
                .register(testUser)
                .getLoggedAccountFirstName();
        Assert.assertEquals(testUser.getFirstName(),loggedUserFirstName);
    }

    //@Test(priority = 2)
    public void test3() throws InterruptedException {
        new CatfootwearCartPage(driver)
                .openPage()
                .deleteItem(3);

        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void test4() throws InterruptedException {
        CreditCard testCard = CardCreator.withCredentialsFromProperty();
        new CatfootwearWalletPage(driver)
                .openPage()
                .addCreditCard(testCard);

        Thread.sleep(5000);
    }
}
