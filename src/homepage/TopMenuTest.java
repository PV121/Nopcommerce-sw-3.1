package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import javax.xml.ws.WebEndpoint;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl= "https://demo.nopcommerce.com/";
    @Before
    public void openBrowserTopMenu(){
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){

        List<WebElement> topMenuName= driver.findElements(By.xpath("//body/div[6]/div[2]"));
        for (WebElement name : topMenuName){
            if (name.getText().equalsIgnoreCase(menu)){
                name.click();
                break;
            }
        }
    }
    @Test
    public void verifyComputer (){
        selectMenu("Computers");
        verifyText("Computers","Computers",By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
    }
    @Test
    public void verifyElectronics(){
        selectMenu("Electronics");
        verifyText("Electronics","Electronics",By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
    }
    @Test
    public void verifyApparel(){
        selectMenu("Apparel");
        verifyText("Apparel","Apparel",By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
    }
    @Test
    public void verifyDigitalDownloads(){
        selectMenu("DigitalDownloads");
        verifyText("Digital downloads","Digital downloads",By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
    }
    @Test
    public void verifyBooks(){
        selectMenu("Books");
        verifyText("Books","Books",By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]"));
    }
    @Test
    public void verifyJewelry(){
        selectMenu("Jewelry");
        verifyText("Jewelry","jewelry",By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
    }
    @Test
    public void verifyGiftCards(){
        selectMenu("Gift cards");
        verifyText("Gift Cards","Gift Cards",By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
    }


    @After
    public void closeBrowserTopMenu(){
        closeBrowser();
    }

}
