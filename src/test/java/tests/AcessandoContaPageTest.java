package tests;

import Pages.LoginPage;
import Suporte.Web;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AcessandoContaPageTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = Web.createChrome();
    }

    @Test
    public void AcessarConta(){
        new LoginPage(driver)
                .MyAccountClick()
                .TypeLogin("akaue@keeping.com","AnAnIa!!10293aUi");

    }


}
