package Suporte;

import com.sun.deploy.cache.Cache;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    private static Cache FileUtils;

    public static void take(WebDriver driver, String arquivo){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

       try{
           FileUtils.copyFile(screenshot, new File(arquivo));
       } catch (Exception e){
           System.out.println("Deu Ruim" + e.getMessage());
        }
      }
    }
