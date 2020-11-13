package tests;

import Pages.LoginPage;
import Pages.ShopPage;
import Suporte.Web;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ComprandoPageTest {
    private WebDriver driver;


    @Before
    public void setUp(){
      driver = Web.createChrome();
      new LoginPage(driver)
              .MyAccountClick()
              .TypeLogin("akaue@keeping.com","AnAnIa!!10293aUi");
    }

    @Test
    public void comprandoAlgo(){
        new ShopPage(driver)
                .ShopClick()
                .ShopBuying()
                .ViewCart()
                .ValidandoMsg();

    }


//    @After
//    public void tearDown(){
//        driver.quit();
//
//    }
}
