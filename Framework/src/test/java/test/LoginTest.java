package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatfootwearItemPage;
import page.CatfootwearLoginPage;
import service.UserCreator;


public class LoginTest extends CommonConditions{

    @Test
    public void loginTest() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedUserFirstName = new CatfootwearLoginPage(driver)
                .openPage()
                .closeCookiesMessage()
                .login(testUser)
                .getLoggedAccountFirstName();
        Assert.assertEquals(testUser.getFirstName(),loggedUserFirstName);
    }

    public void test1() {
        Boolean widthAndSizeSelected = new CatfootwearItemPage(driver)
                .openPage()
                .areWidthAndSizeSelected();
        Assert.assertFalse(widthAndSizeSelected, "Width and Size were selected!");
    }

}
