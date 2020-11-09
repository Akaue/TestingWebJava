package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ComprandoTest {
    private WebDriver driver;

    @Before
     public void setUp(){
         System.setProperty("WebDriver.Chrome.driver","C:\\tools\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("http://practice.automationtesting.in/");
         driver.findElement(By.linkText("My Account")).click();

         WebElement formularioRegister = driver.findElement(By.className("login"));
         formularioRegister.findElement(By.id("username")).sendKeys("akaue@keeping.com");
         formularioRegister.findElement(By.id("password")).sendKeys("AnAnIa!!10293aUi");
         formularioRegister.findElement(By.id("password")).sendKeys(Keys.ENTER);

     }

     @Test
     public void ComprandoAlgumaCoisa(){

        driver.findElement(By.linkText("Orders")).click();
        driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/a")).click();

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]/h3")).click();


         WebElement mensagem = driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/h1"));
         String txtMensagem = mensagem.getText();
         Assert.assertEquals("Android Quick Start Guide",txtMensagem);

     }




}
