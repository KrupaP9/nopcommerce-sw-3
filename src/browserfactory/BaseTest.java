package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //driver is declared public and static to allow access from other classes
    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        //set key to value for driver location
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        //create instance for ChromeDriver class
        driver = new ChromeDriver();
        //launch URL given
        driver.get(baseUrl);
        //maximise window
        driver.manage().window().maximize();
        //set implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        //quit browser
        driver.quit();
    }
}
