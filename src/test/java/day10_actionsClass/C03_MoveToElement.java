package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {

    @Test
    public void test01(){

         /*
            Bazi HTML kodlar mouse ile yaklastigimizda aktif hale gelir
            amazon anasayfadaki accounts&lists menusu de mouse ile yaklasinca aciliyor
            mouse ile yaklasmasak da
            menu uzerindeki linklere ait HTML kodlar gorunuyor
            AMA kullanilamiyor
            acilir menuyu acmadan elementleri kullanmaya kalkisinca
            ElementNotInteractableException
            veriyor.
         */

        //1- https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement ListElementi = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

        actions.moveToElement(ListElementi).perform();

        //3- “Create a list” butonuna basin

        driver.findElement(By.xpath("//*[text()='Neue Liste anlegen '] ")).click();


        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        WebElement meinListe = driver.findElement(By.xpath("//*[@id='my-lists-tab']"));

        Assert.assertTrue(meinListe.isDisplayed());



        bekle(5);


    }
}
