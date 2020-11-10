package tests;

import Suporte.Generator;
import Suporte.Screenshot;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ComprandoTest  {
    private WebDriver driver;

    @Rule
    public TestName test = new TestName();
    public TestName test2 = new TestName();

    @Before
     public void setUp(){
         System.setProperty("WebDriver.Chrome.driver","C:\\tools\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("http://practice.automationtesting.in/");
         driver.findElement(By.linkText("My Account")).click();

         //Formulario de Login
         WebElement formularioRegister = driver.findElement(By.className("login"));
         formularioRegister.findElement(By.id("username")).sendKeys("akaue@keeping.com");
         formularioRegister.findElement(By.id("password")).sendKeys("AnAnIa!!10293aUi");
         formularioRegister.findElement(By.id("password")).sendKeys(Keys.ENTER);

     }

     @Test
     public void ComprandoAlgumaCoisa(){

        //Indo para o shop
        driver.findElement(By.linkText("Shop")).click();
//        driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/a")).click();

        //Selecionando o livro de android
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]/h3")).click();


        //Validando livro escolhido
        WebElement mensagem = driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/h1"));
        String txtMensagem = mensagem.getText();
        Assert.assertEquals("Android Quick Start Guide",txtMensagem);
        Screenshot.take(driver, "C:\\Users\\Akaue Lima\\IdeaProjects\\TestingWebJava\\test-report" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png");

        //Adicionando ao carrinho
        driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/form/button")).click();
        // Indo para o caixa
        driver.findElement(By.id("wpmenucartli")).click();
        driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();
        //Place order
        driver.findElement(By.id("place_order")).click();

        WebElement mensagem2 = driver.findElement(By.className("woocommerce-thankyou-order-received"));
        String txtMensagem2 = mensagem2.getText();
        Assert.assertEquals( "Thank you. Your order has been received.", txtMensagem2);
        Screenshot.take(driver, "C:\\Users\\Akaue Lima\\IdeaProjects\\TestingWebJava\\test-report" + Generator.dataHoraParaArquivo() + test2.getMethodName() + ".png");


     }

     @After
     public void tearDown(){
        driver.quit();

     }


}
