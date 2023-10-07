package Ubung;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class S02_YoutubeSorusu {

    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun
    //   ve gerekli testleri yapin
    //




    static WebDriver driver;

    @BeforeClass
    public static void setup()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void titleTest(){
        //○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedBaslik = "YouTube";
        String actualBaslik = driver.getTitle();

        Assert.assertEquals(expectedBaslik,actualBaslik);

    }

    @Test
    public void imageTest(){
        //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin

        WebElement imageElement = driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));

        Assert.assertTrue(imageElement.isDisplayed());
    }

    @Test
    public void searchBoxTesti(){
        //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())

        WebElement searchBoxElementi = driver.findElement(By.xpath("//div[@id='search-input']"));

        Assert.assertTrue(searchBoxElementi.isEnabled());

    }

    @Test
    public void baslikTesti(){
        //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


        String unexpectedBaslik = "youtube";
        String actualBaslik = driver.getTitle();

        Assert.assertNotEquals(unexpectedBaslik,actualBaslik);


    }


}
