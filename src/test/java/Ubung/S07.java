package Ubung;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class S07 extends TestBase {

    @Test
    public void test(){

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String firstHandleDegeri = driver.getWindowHandle();

        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);


        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        bekle(2);
        //4.Diger window'a gecin
        Set<String>  handleSeti = driver.getWindowHandles();
        String secondHandleDegeri="";

        for (String each:handleSeti
             ) {
            if (!each.equals(firstHandleDegeri)){
                secondHandleDegeri=each;
            }
        }

        driver.switchTo().window(secondHandleDegeri);

        //5."username" ve "password" kutularina deger yazdirin
        Faker faker = new Faker();
        //String password = faker.internet().password();

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        actions.click(username).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).perform();

            bekle(2);


        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedYazi = "validation failed";
        String actualYazi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedYazi,actualYazi);



        //8.Ok diyerek Popup'i kapatin

        driver.switchTo().alert().accept();



        //9.Ilk sayfaya geri donun
        driver.switchTo().window(firstHandleDegeri);

        //10.Ilk sayfaya donuldugunu test edin

        String expectedUrl = "http://webdriveruniversity.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);



    }


}
