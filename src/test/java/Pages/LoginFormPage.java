package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    public LoginFormPage TypeLogin(String username, String password){
       driver.findElement(By.id("username")).sendKeys(username);
       driver.findElement(By.id("password")).sendKeys(password);
       driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

       return this;
    }
}
