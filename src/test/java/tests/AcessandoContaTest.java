package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class AcessandoContaTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("Webdriver.Chrome.driver", "C:\\tools\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.automationtesting.in/");
        driver.findElement(By.linkText("My Account")).click();
    }

    @Test
    public void LoginUser() throws InterruptedException {
        //Inserindo dados para acessar conta
        WebElement formularioRegister = driver.findElement(By.className("login"));
        formularioRegister.findElement(By.id("username")).sendKeys("akaue@keeping.com");
        formularioRegister.findElement(By.id("password")).sendKeys("AnAnIa!!10293aUi");
        formularioRegister.findElement(By.id("password")).sendKeys(Keys.ENTER);


        // Validando mensagem de acesso a conta
        WebElement mensagem = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]"));
        String txtMensagem = mensagem.getText();
        Assert.assertEquals("Hello akaue (not akaue? Sign out)",txtMensagem);

        //Fazendo logou da conta
        driver.findElement(By.linkText("Logout")).click();

    }

    @After
    public void tearDown(){
        driver.quit();

    }

}
