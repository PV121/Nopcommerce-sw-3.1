package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowserComputer() {
        openBrowser(baseUrl);
    }

    @Test
    public void name() throws InterruptedException {
        // click on computer
        clickOnElement(By.xpath("//div[@class='header-menu']/ul/li[1]"));
        // click on desktop
        Thread.sleep(3000);
        clickOnElement(By.xpath("//ul[@class='sublist']/li[1]/a"));


        List<WebElement> beforeFilterPrice = driver.findElements(By.xpath("item-grid"));
        List<Double> beforeFilterPriceList = new ArrayList<>();
        for (WebElement prices : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(prices.getText().replace("$", "")));
        }
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");
        Thread.sleep(2000);
        List<WebElement> afterFilterPrice = driver.findElements(By.xpath("item-grid"));
        List<Double> afterFilterPriceList = new ArrayList<>();
        for (WebElement prices : beforeFilterPrice) {
            beforeFilterPriceList.add(Double.valueOf(prices.getText().replace("$", "")));
        }
        //sorting the priceList
        Collections.sort(beforeFilterPriceList);
        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Click on computers on top menu
        clickOnElement(By.xpath("//div[@class='header-menu']/ul/li[1]"));
        //Click on desktop from side menu
        clickOnElement(By.xpath("//ul[@class='sublist']/li[1]/a"));
        //Select order by Name: a to z

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        Thread.sleep(2000);

        //click on add to cart
        clickOnElement(By.xpath("//div[@class='product-item']/div[2]/div[3]/div[2]/button[1]"));

        //validation of text
        verifyText("Build your own computer text validation", "Build your own computer", By.xpath("//div[@class='overview']/div[1]"));

        // select 2.2 GHz Intel Pentium Dual-Core E2200 from dropdown
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");

        Thread.sleep(2000);
        // select 8GB [+$60.00] from the dropdown
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");

        Thread.sleep(2000);

        //click on HDD radio button
        clickOnElement(By.id("product_attribute_3_7"));
        Thread.sleep(2000);

        // Click on OS radio button
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(2000);

        // click on Total Commander [+$5.00]
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);

        Thread.sleep(2000);
        //Verify price of products
        verifyText("Price validation", "$1,475.00", By.id("price-value-1"));

        //Click on cart button
        clickOnElement(By.id("add-to-cart-button-1"));
        Thread.sleep(2000);

        verifyText("Add to cart text validation", "The product has been added to your shopping cart", By.xpath("//div[@id='bar-notification']/div/p"));
        clickOnElement(By.xpath("//div[@id='bar-notification']/div/span"));

        //mouse hover and click to add to cart button
        mouseHoverAndClick(By.xpath("//li[@id='topcartlink']"), By.xpath("//div[@class='buttons']/button"));

        //verify add to cart message
        verifyText("Add to cart text validation", "Shopping cart", By.xpath("//div[@class='page-title']/h1"));

        //clear text from the field
        Thread.sleep(2000);
        clearTextFromField(By.xpath("//td[@class='quantity']/input"));

        //send keys to field
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//td[@class='quantity']/input"), "2");

        //click on update cart
        clickOnElement(By.id("updatecart"));

        //verify the price
        verifyText("Verify price", "$2,950.00", By.xpath("//td[@class='subtotal']/span"));

        //click on the term box
        clickOnElement(By.id("termsofservice"));

        //click on checkout button
        clickOnElement(By.id("checkout"));

        //verify welcome please sign in
        verifyText("welcome sign in text validaation", "Welcome, Please Sign In!", By.xpath("//div[@class='page-title']/h1"));

        // click on checkout as guest
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //send text to first name field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "John");

        //send text to password field
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Cena");

        //send text to email address
        sendTextToElement(By.id("BillingNewAddress_Email"), "johncena123@gmail.com");
        Thread.sleep(5000);

        //select country from the dropdown
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "Canada");

        //select country from the dropdown
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "Ontario");

        //send text to city field
        sendTextToElement(By.id("BillingNewAddress_City"), "Ottawa");

        //send text to address 1
        sendTextToElement(By.id("BillingNewAddress_Address1"), "President road");

        //send text to postal code field
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "M9V2D6");

        //send text to phone number field
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "111111111111");

        //click on continue button
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));

        Thread.sleep(8000);

        //Click on next day air($0.00)
        clickOnElement(By.xpath("//ul[@class='method-list']/li[2]/div[1]/input"));

        //click on continue button
        clickOnElement(By.xpath("//form[@id='co-shipping-method-form']/div[2]/button"));

        //click on credit card radio button
        clickOnElement(By.xpath("//ul[@class='method-list']/li[2]/div/div[2]/input"));

        //Click on continue button
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));
        Thread.sleep(5000);

        //Select master card from the dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");

        //send text to cardholder name field
        sendTextToElement(By.id("CardholderName"), "Mr John");

        //Send text to cardnumber field
        sendTextToElement(By.id("CardNumber"), "5105105105105100");

        //select month from dropdown
        selectByValueFromDropdown(By.id("ExpireMonth"), "10");

        //select year from dropdown
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2024");

        //send text to card code
        sendTextToElement(By.id("CardCode"), "123");

        //Click on continue button
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        //verify credit card text
        verifyText("Verifying credit crad text","Credit Card", By.xpath("//li[@class='payment-method']/span[2]"));

        //verify shipping method next day air
        verifyText("Verifying shipping method next day air","Next Day Air", By.xpath("//li[@class='shipping-method']/span[2]"));

        //verify price
        verifyText("Verify Price ","$2,950.00", By.xpath("//div[@class='table-wrapper']/table[1]/tbody/tr/td[6]/span"));

        //click on continue button
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
        Thread.sleep(5000);

        //Verify Thank you text
        verifyText("Verify thank you text","Thank you", By.xpath("//div[@class='page-title']/h1"));

        //verify your order has been successfully processed
        verifyText("Verify successfully processed text","Your order has been successfully processed!", By.xpath("//div[@class='section order-completed']/div[1]"));

        //click on continue button
        clickOnElement(By.xpath("//div[@class='section order-completed']/div[3]/button"));

        //verify welcome to our store
        verifyText("Verify welcome to iur store","Welcome to our store", By.xpath("//div[@class='topic-block-title']/h2"));

    }

    @After
    public void closeBrowserComputer() {
        closeBrowser();
    }
}
