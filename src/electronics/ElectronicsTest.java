package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Random;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() throws InterruptedException {
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]"), By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        verifyText("Verify cellphones text","Electronics", By.xpath("//div[@class='center-2']/div/div[1]/h1"));
    }

    @Test
    public void verifyThatTheProductAddedSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        //2.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //1.3 Verify the text “Cell phones”
        verifyText("Verify cellphones text","Cell phones", By.xpath("//div[@class='page category-page']/div[1]/h1"));

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//div[@class='product-viewmode']/a[2]"));
        Thread.sleep(2000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/h2/a"));

        // 2.6 Verify the text “Nokia Lumia 1020”
        verifyText("Verify nokia lumia 1020 text","Nokia Lumia 1020", By.xpath("//div[@class='product-name']/h1"));

        //2.7 Verify the price “$349.00”
        verifyText("Price verify","$349.00", By.xpath("//div[@class='prices']/div/span"));

        //2.8 Change quantity to 2
        clearTextFromField(By.id("product_enteredQuantity_20"));
        Thread.sleep(2000);
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        Thread.sleep(2000);

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("Verify sgopping cart text","The product has been added to your shopping cart", By.xpath("//div[@id='bar-notification']/div/p"));

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//div[@id='bar-notification']/div/span"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverAndClick(By.xpath("//li[@id='topcartlink']"), By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        verifyText("Verify shopping cart text","Shopping cart",By.xpath("//div[@class='page-title']/h1"));

        //2.13 Verify the quantity is 2
        //verifyText("2", By.xpath("//td[@class='quantity']/input"), "Verify quantity");

        //2.14 Verify the Total $698.00
        verifyText("Verify price","$698.00", By.xpath("//td[@class='subtotal']/span"));

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.16 Click on checkout
        clickOnElement(By.id("checkout"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText("Verify welcome sign in text","Welcome, Please Sign In!", By.xpath("//div[@class='page-title']/h1"));

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//div[@class='buttons']/button[2]"));

        //2.19 Verify the text “Register”
        verifyText("Register text validation","Register", By.xpath("//div[@class='page-title']/h1"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Pratik");
        sendTextToElement(By.id("LastName"), "Gandhi");
        WebElement emailField = driver.findElement(By.id("Email"));// email field locator
        emailField.click();// click email field
        Random randomGenerator = new Random();// random generator class
        int randomInt = randomGenerator.nextInt(1000);
        emailField.sendKeys("username" + randomInt + "@gmail.com");// creating random email generator
        sendTextToElement(By.id("Password"), "123456");
        sendTextToElement(By.id("ConfirmPassword"),"123456");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));

        //2.22 Verify the message “Your registration completed”
        verifyText("Your registration completed text","Your registration completed",By.xpath("//div[@class='page-body']/div[1]"));

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//div[@class='buttons']/a"));

        //2.24 Verify the text “Shopping cart”
        verifyText("Verify shopping cart text","Shopping cart",By.xpath("//div[@class='page-title']/h1"));

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"Albania");
        sendTextToElement(By.id("BillingNewAddress_City"),"surat");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"999 baker road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"56235");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"9898989898");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@class='buttons']/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));

        //2.32 Select “Visa” From Select credit card dropdown
        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"),"pin");
        sendTextToElement(By.id("CardNumber"),"4917484589897107");
        selectByIndexFromDropDown(By.id("ExpireYear"),2);
        sendTextToElement(By.id("CardCode"),"007");

        //2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyText("Credit card validation","Credit Card",By.xpath("//li[@class='payment-method']/span[2]"));

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText("Shipping method validation","2nd Day Air",By.xpath("//li[@class='shipping-method']/span[2]"));

        //2.37 Verify Total is “$698.00”
        verifyText("Amount validation","$698.00",By.xpath("//td[@class='subtotal']/span"));

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));

        //2.39 Verify the Text “Thank You”
        verifyText("Thank you text validation","Thank you",By.xpath("//div[@class='page checkout-page order-completed-page']/div[1]/h1"));

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyText("yoru order has been successfully processed","Your order has been successfully processed!",By.xpath("//div[@class='page checkout-page order-completed-page']/div[2]/div/div[1]"));

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@class='section order-completed']/div[3]/button"));

        //2.42 Verify the text “Welcome to our store”
        verifyText("Welcome to store text","Welcome to our store",By.xpath("//div[@class='topic-block-title']/h2"));

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//div[@class='header-links']/ul/li[2]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://demo.nopcommerce.com/";
        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


