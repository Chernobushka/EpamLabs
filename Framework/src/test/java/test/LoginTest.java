package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatfootwearItemPage;
import page.CatfootwearLoginPage;
import service.UserCreator;


public class LoginTest extends CommonConditions{

    @Test
    public void loginWithBadEmailAndPassword() {
        User testUser = UserCreator.withCredentialsFromProperty();
        System.out.println(testUser.getEmail());
        System.out.println(testUser.getPassword());
        Boolean canLogin = new CatfootwearLoginPage(driver)
                .openPage()
                .closeCookiesMessage()
                .canLogin(testUser);
        Assert.assertFalse(canLogin);
    }

    public void test1() {
        Boolean widthAndSizeSelected = new CatfootwearItemPage(driver)
                .openPage()
                .areWidthAndSizeSelected();
        Assert.assertFalse(widthAndSizeSelected, "Width and Size were selected!");
    }

}
