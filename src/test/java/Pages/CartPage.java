package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage ValidandoMsg(){

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-thankyou-order-received"))).isEnabled();

        WebElement mensagem = driver.findElement(By.className("woocommerce-thankyou-order-received"));
        String txtmensagem = mensagem.getText();
        Assert.assertEquals("Thank you. Your order has been received.", txtmensagem);

        return this;

    }
}