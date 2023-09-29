package day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://wwww.amazon.com");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazi = driver.findElement(By.xpath("//div[@class='sg-col-4-of-24 sg-col-3-of-12 sg-col-4-of-16 sg-col s-breadcrumb sg-col-4-of-20']"));
        System.out.println(sonucYazi.getText());

        //5- Ilk urunu tiklayalim

            driver.findElement(By.xpath("")).click();



        //6- Sayfadaki tum basliklari yazdiralim

        driver.navigate().back();

        List<WebElement> baslikElementleri = driver.findElements(By.xpath(""));

        for (int i = 0; i < baslikElementleri.size(); i++) {
            System.out.println(i+ "- " +baslikElementleri.get(i).getText());
        }

        ReusableMethods.bekle(5);
        driver.close();

    }
}
