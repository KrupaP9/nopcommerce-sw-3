package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.UtilitiesNopCommerce;

import java.util.List;

public class TopMenuTest extends UtilitiesNopCommerce {
    @Before
    public void openBrowsers() {
        openBrowser("https://demo.nopcommerce.com/");
    }

    public static void selectMenu(String menu) {
        //create a list to store all menu options
        List<WebElement> menuList = driver.findElements(By.xpath("//div[@class = 'header-menu']/ul/li"));
        try {
            //loop through list with for loop
            for (WebElement menuOption : menuList) {
                System.out.println(menuOption.getText());
                //if option matches with the parameter then click
                if (menuOption.getText().equals(menu)) {
                    menuOption.click();
                }
            }
            //catch exceptions
        } catch (StaleElementReferenceException e) {
            menuList = driver.findElements(By.xpath("//div[@class = 'header-menu']/ul/li"));
        }
    }

    @Test
    public void verifyPageNavigation() throws InterruptedException{
        //call selectMenu method with parameter booke
        selectMenu("Books");
        //define expected
        String expectedPage = "Books";
        //get actual
        String actualPage = getTextFromElement(By.xpath("//h1[contains(text(),'Books')]"));
        //verify expected and actual are same
        Assert.assertEquals("page relocation fail",expectedPage,actualPage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
