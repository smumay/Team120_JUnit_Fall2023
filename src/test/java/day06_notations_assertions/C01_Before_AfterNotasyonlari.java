package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_Before_AfterNotasyonlari {

    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin

    WebDriver driver;
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void amazonTest(){
        // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin

            setup();
        driver.get("https://www.amazon.com");
        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("amazon PASSED");
        }else{
            System.out.println("amazon FAILED");
        }
        ReusableMethods.bekle(2);

        driver.close();
    }

    @Test

    public void wiseTesti(){
        // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin

        setup();

        driver.get("https://www.wisequarter.com");
        String expectedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("wisequarter testi PASSED");
        }else{
            System.out.println("wisequarter test FAILED");
        }
        driver.close();

    }

            @Test
    public void youtubeTesti(){

        setup();

        driver.get("https://www.youtube.com");

                String unExpectedTitleIcerik = "best";
                String actualTitle = driver.getTitle();

                if (actualTitle.contains(unExpectedTitleIcerik)){
                    System.out.println(" Youtube testi FAILED");
                }else{
                    System.out.println(" Youtube test PASSED");
                }
                driver.close();


            }





}
