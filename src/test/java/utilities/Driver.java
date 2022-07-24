package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {

    static WebDriver driver;

    /**
     * This method is used to have single driver object all over test cases
     * @return
     */
    public static WebDriver getDriver(){
        String browserType=ConfigReader.getProperty("browser");

        if(driver==null || ((RemoteWebDriver)driver).getSessionId()==null){
            if(browserType.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            }else if(browserType=="firefox"){
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            }else if(browserType=="edge"){
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            }
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }

}
