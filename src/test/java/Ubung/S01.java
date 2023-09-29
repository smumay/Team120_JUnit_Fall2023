package Ubung;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class S01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);


        //4- Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucYazisi = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]"));
        System.out.println(aramaSonucYazisi.getText());

        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='sg-col sg-col-4-of-12 sg-col-4-of-16 sg-col-4-of-20 sg-col-4-of-24 s-list-col-left'])[1]")).click();

        ReusableMethods.bekle(2);


        //6- Sayfadaki tum basliklari yazdiralim


        driver.navigate().back();

        WebElement kategoriYazdirma = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]"));
        System.out.println(kategoriYazdirma.getText());


        driver.close();
    }
}
