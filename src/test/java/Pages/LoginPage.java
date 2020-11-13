package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  {

    private WebDriver driver;
  // toda page tem q ter essa estrutura
    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    public LoginFormPage MyAccountClick(){
        driver.findElement(By.linkText("My Account")).click();

        return new LoginFormPage(driver);
    }
}
