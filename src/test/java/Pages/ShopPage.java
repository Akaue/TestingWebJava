package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage extends BasePage {


    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public ShopPage ShopClick(){
        driver.findElement(By.linkText("Shop")).click();

        return this;

    }

    public ShopPage ShopBuying(){

        //Selecionando o livro de android
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]/h3")).click();


        //Validando livro escolhido
        WebElement mensagem = driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/h1"));
        String txtMensagem = mensagem.getText();
        Assert.assertEquals("Android Quick Start Guide",txtMensagem);

        //Adicionando ao carrinho
        driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/form/button")).click();


        return this;
    }

    public CartPage ViewCart(){
        // Indo para o caixa
        driver.findElement(By.id("wpmenucartli")).click();
        driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();


        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"place_order\"]"))).getText();


//       Place order  esta com problema
        driver.findElement(By.xpath("//input[@id=\"place_order\"]")).click();



        return new CartPage(driver);

    }



}
