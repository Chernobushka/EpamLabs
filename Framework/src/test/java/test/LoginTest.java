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
    public void expressShippingPriceTest() {
        Item firstTestItem = ItemCreator.withCredentialsFromProperty("first");
        Item secondTestItem = ItemCreator.withCredentialsFromProperty("fourth");

        CatfootwearItemPage itemPage = new CatfootwearItemPage(driver);
        itemPage.openPage(firstTestItem)
                .closeCookiesMessage()
                .selectItem();
        CatfootwearCartPage cartPage = itemPage.openPage(secondTestItem)
                .selectItem();
        Assert.assertTrue(cartPage.getShippingPrice() == 0);
        Assert.assertTrue(cartPage.getShippingType().contains("Express"));
    }

    @Test(priority = 2)
    public void applyPromocodeTest() {
        CatfootwearCartPage cartPage = new CatfootwearCartPage(driver)
                .openPage();
        double priceBefore = cartPage.getOrderPrice();
        double priceAfter = cartPage
                .applyPromocode("SECRET20")
                .getOrderPrice();
        System.out.println(priceBefore);
        System.out.println(priceAfter);
        Assert.assertEquals(priceAfter, priceBefore * 0.8);
    }

    @Test(priority = 3)
    public void changeSippingTypeOnItemDelete() {
        CatfootwearCartPage cartPage = new CatfootwearCartPage(driver)
                .openPage()
                .deleteItem(1);
        Assert.assertTrue(cartPage.getShippingType().contains("Standard"));
        Assert.assertNotEquals(cartPage.getExpressShippingPrice(), 0);
    }

    @Test(priority = 4)
    public void addItemToCart() {
        Item testItem = ItemCreator.withCredentialsFromProperty("first");
        CatfootwearItemPage page = new CatfootwearItemPage(driver)
                .openPage(testItem);
        int numberOfItemsInCartBefore = page.getNumberOfItemsInCart();
        int numberOfItemsInCartAfter = page.selectItem()
                .getNumberOfItemsInCart();

        Assert.assertEquals(numberOfItemsInCartAfter, numberOfItemsInCartBefore + 1);
    }

    @Test(priority = 5)
    public void addItemToCartWithoutSelectingSizeAndWidth() {
        Item testItem = ItemCreator.withCredentialsFromProperty("third");
        CatfootwearItemPage page = new CatfootwearItemPage(driver)
                .openPage(testItem);
        int numberOfItemsInCartBefore = page.getNumberOfItemsInCart();
        int numberOfItemsInCartAfter = page.selectItem()
                .getNumberOfItemsInCart();

        Assert.assertEquals(numberOfItemsInCartAfter, numberOfItemsInCartBefore);
    }


    @Test(priority = 6)
    public void addItemToCartWithBadSizeAndWidth() {
        Item testItem = ItemCreator.withCredentialsFromProperty("second");
        boolean availability = new CatfootwearItemPage(driver)
                .openPage(testItem)
                .isAvailable();
        Assert.assertFalse(availability);
    }

    @Test(priority = 7)
    public void registerWithBadCredentials() {
        User testUser = UserCreator.withCredentialsFromProperty("first");
        String loggedUserFirstName = new CatfootwearRegisterPage(driver)
                .openPage()
                .register(testUser)
                .getLoggedAccountFirstName();
        Assert.assertNotEquals(testUser.getFirstName(),loggedUserFirstName);
    }

    @Test(priority = 8)
    public void loginTest() {
        User testUser = UserCreator.withCredentialsFromProperty("first");
        String loggedUserFirstName = new CatfootwearLoginPage(driver)
                .openPage()
                .login(testUser)
                .getLoggedAccountFirstName();
        Assert.assertEquals(testUser.getFirstName(),loggedUserFirstName);
    }

    @Test(priority = 9)
    public void addCreditCardTest() {
        CreditCard card = CardCreator.withCredentialsFromProperty();
        String defaultPayment = new CatfootwearWalletPage(driver)
                .openPage()
                .addCreditCard(card)
                .getDefaultPaymentMethod();
        Assert.assertTrue(defaultPayment.contains(card.toString()));
    }
}
