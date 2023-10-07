package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {

    WebDriver driver;

    // ilgili kurulumlari tamamlayalim
// Kullanici https://www.google.com adresine gider
// Çıkıyorsa Kullanici cookies i kabul eder
// Arama Kutusuna karşilastirma yapmak istedigi para birimlerini girer
// Para birimlerinin karsilastirmasini alin
// Karsilastirilacak olan para biriminin 25 den kUCUk oldygu test edilir


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.google.com");
        WebElement cookiesElement = driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]"));
        cookiesElement.click();
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='APjFqb']"));
        aramaKutusu.sendKeys("USD TO TRY"+ Keys.ENTER);

        WebElement resultMoney = driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));

        String actualResult = resultMoney.getText().replace(",",".");
        String expectedDeger = "25";
        double actualResultDouble = Double.parseDouble(actualResult);

        Assert.assertTrue(actualResultDouble>25);



    }



}
