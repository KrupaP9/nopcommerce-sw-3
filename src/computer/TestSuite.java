package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilitiesNopCommerce;


public class TestSuite extends UtilitiesNopCommerce {
    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com/");
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException{
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Computers ']"));
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //define expected
        String expectedText = "Name: Z to A";
        //get actual
        String actualText = getTextFromElement(By.xpath("//select[@id='products-orderby']/option[text()='Name: Z to A']"));
        //verify the ordering is priced high to low
        Assert.assertEquals("not sorted by Name: Z to A", expectedText, actualText);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        //2.1 Click on Computer Menu.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Computers ']"));
        //2.2 Click on Desktop
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //define expected text
        String expectedText = "Build your own computer";
        //get actual text
        String actualText = getTextFromElement(By.xpath("//div[@class='product-name']/h1"));
        Assert.assertEquals("Not on Build your own computer page",expectedText,actualText);
        Thread.sleep(1000);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_1']"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_2']"),"8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[text()='Vista Premium [+$60.00]']"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(1000);
        //mouseHoverAndClickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        //clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        //define expected price
        String expectedPrice = "$1,475.00";
        //get actual price
        String actualPrice = getTextFromElement(By.xpath("//span[text()='$1,475.00']"));
        //2.11 Verify the price "$1,475.00"
        Assert.assertEquals("not $1,475.00",expectedPrice,actualPrice);
        //2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1'] "));
        //define expected
        String expectedMessage = "The product has been added to your shopping cart";
        //get actual
        String actualMessage = getTextFromElement(By.xpath("//div[@class='bar-notification success']/p"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals("Not added successfully",expectedMessage,actualMessage);
        //After that close the bar clicking on the cross button.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='bar-notification success']/span"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //define expected
        String expectedTextShoppingCart = "Shopping cart";
        //get actual
        String actualTextShoppingCart = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        //2.15 Verify the message "Shopping cart"
        Assert.assertEquals("not on shopping cart",expectedTextShoppingCart,actualTextShoppingCart);
        Thread.sleep(1000);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        //define expected
        String expectedTotal = "$2,950.00";
        //get actual
        String actualTotal = getTextFromElement(By.xpath("//td[@class='subtotal']/span[text()='$2,950.00']"));
        //2.17 Verify the Total"$2,950.00"
        Assert.assertEquals("Total not $2,950.00",expectedTotal,actualTotal);
        Thread.sleep(1000);
        //2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@name='termsofservice']"));
        //2.19 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@name='checkout']"));
        //define expected text
        String expectedWelcome = "Welcome, Please Sign In!";
        //get actual text
        String actualWelcome = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(1000);
        Assert.assertEquals("Not on sign in page",expectedWelcome,actualWelcome);
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"Mary");
        sendTextToElement(By.id("BillingNewAddress_LastName"),"Allens");
        sendTextToElement(By.id("BillingNewAddress_Email"),"maryallens@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"20 London Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"NW11AD");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"07854367945");
        //2.23 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
        //2.25 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"),"MR A SMITH");
        sendTextToElement(By.id("CardNumber"),"5555555555554444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"02");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"123");
        //2.29 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedPaymenMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//li[@class='payment-method']/span[@class='value']"));
        Thread.sleep(1000);
        Assert.assertEquals("not credit card",expectedPaymenMethod,actualPaymentMethod);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod ="Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        Thread.sleep(1000);
        Assert.assertEquals("not next day air",expectedShippingMethod,actualShippingMethod);
        //2.33 Verify Total is “$2,950.00”
        String expectedTotalAmount = "$2,950.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        //2.34 Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //define expected
        String expectedThankYou = "Thank you";
        //get actual
        Thread.sleep(1000);
        String actualThankYou = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        //2.35 Verify the Text “Thank You”
        Thread.sleep(1000);
        Assert.assertEquals("Thank you not displayed",expectedThankYou,actualThankYou);
        //define expected
        String expectedSuccessfullyProcessed = "Your order has been successfully processed!";
        //get actual
        String actualSuccessfullyProcessed = getTextFromElement(By.xpath("//div[@class='section order-completed']/div[@class='title']/strong"));
        //2.36 Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Not processed",expectedSuccessfullyProcessed,actualSuccessfullyProcessed);
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.37 Verify the text “Welcome to our store”
        //define expected
        String expectedWelcomeMessage = "Welcome to our store";
        //get actual
        String actualWelcomeMessage = getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2"));
        //2.36 Verify the message “Your order has been successfully processed!”
        Thread.sleep(1000);
        Assert.assertEquals("Not successfully processed",expectedWelcomeMessage,actualWelcomeMessage);
    }
    public void tearDown(){
        closeBrowser();
    }
}
