package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

            /*    Exercise-1:

BeforeClass ile driver'i oluşturun ve class icinde static yapin
Maximize edin ve 10 sn bekletin
http://www.qooqle.com adresine gidin



AfterClass ile kapatin.
     */
    static WebDriver driver;
    WebElement aramaKutusu;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }



    @Before
    public void before(){
        driver.get("https://www.google.com");
        WebElement cookiesElement = driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]"));
        cookiesElement.click();
        aramaKutusu= driver.findElement(By.xpath("//*[@id='APjFqb']"));
    }

    @Test
    public void test01(){
        //1-arama kutusuna "12 Angry Men” yaz ip, cikan sonuc şayisini yazdinin


    }

    @Test
    public void test02(){
        //2-arama kutusuna "Vizontele” yaz ip, cikan sonuc şayisini yazdirin

    }

    @Test
    public void test03(){
        //3-arama kutusuna "Saving Private Ryan” yaz4p, cikan sonuc şayisini yazdirin

    }




}
