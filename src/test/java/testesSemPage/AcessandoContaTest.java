package testesSemPage;

import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "AcessandoContaTest.csv")
public class AcessandoContaTest {
    private WebDriver driver;

    @Before
    public void setUp(){
//        System.setProperty("Webdriver.Chrome.driver", "C:\\tools\\chromedriver_win32\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("http://practice.automationtesting.in/");

        driver = Web.createChrome();

    }

    @Test
    public void testLoginUser(@Param(name="username")String username,@Param(name="password")String password,@Param(name="msgLogin")String msgLogin) throws InterruptedException {
        driver.findElement(By.linkText("My Account")).click();
        //Inserindo dados para acessar conta
        WebElement formularioRegister = driver.findElement(By.className("login"));
        formularioRegister.findElement(By.id("username")).sendKeys(username);
        formularioRegister.findElement(By.id("password")).sendKeys(password);
        formularioRegister.findElement(By.id("password")).sendKeys(Keys.ENTER);


        // Validando mensagem de acesso a conta
        WebElement mensagem = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]"));
        String txtMensagem = mensagem.getText();
        Assert.assertEquals(msgLogin,txtMensagem);

        //Fazendo logou da conta
        driver.findElement(By.linkText("Logout")).click();

    }

    @After
    public void tearDown(){
        driver.quit();

    }

}
