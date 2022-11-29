package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UtilitiesNopCommerce extends BaseTest {
    public void clickOnElement(By by){
        //find the element to click
        WebElement link = driver.findElement(by);
        //click on element
        link.click();
    }
    public void sendTextToElement(By by, String text){
        //find the element to enter text into
        WebElement field = driver.findElement(by);
        //send text to element
        field.sendKeys(text);
    }
    public String getTextFromElement(By by){
        //find the element to get text from
        WebElement element = driver.findElement(by);
        //return the text from the element as String
        return element.getText();
    }
    public void selectByVisibleTextFromDropDown(By by, String text){
        //method to select dropdown option using text displayed
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectByValue(By by, String text){
        //method to select dropdown option using value
        WebElement value = driver.findElement(by);
        Select select = new Select(value);
        select.selectByValue(text);
    }
    public void selectByIndex(By by, int num){
        //method to select dropdown option using the order in which they appear
        WebElement index = driver.findElement(by);
        Select select = new Select(index);
        select.selectByIndex(num);
    }
    //method to switch driver to any popup
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    //method to accept any popup
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    //method to dismiss any popup
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    //method to send text to any popup
    public void sendTextToAlert(By by, String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //method to get text from any popup
    public String getTextFromAlert(By by){
        return driver.switchTo().alert().getText();
    }
    //hover over element
    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by);
        actions.moveToElement(text1).moveToElement(text2).build().perform();
    }
    //hover and click an element
    public void mouseHoverAndClickOnElement(By by){
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by);
        actions.moveToElement(text1).moveToElement(text2).click().build().perform();
    }
}
