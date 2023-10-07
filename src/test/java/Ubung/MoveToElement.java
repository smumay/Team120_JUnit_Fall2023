package Ubung;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class MoveToElement extends TestBase {
    @Test
    public void test(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement kontoListenElement = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(kontoListenElement).perform();



        bekle(3);


        //3- “Create a list” butonuna basin

        driver.findElement(By.xpath("(//a[@class='nav-link nav-item'])[1]")).click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String expectedYazi = "Meine Listen";
        String actualList = driver.findElement(By.id("my-lists-tab")).getText();

        Assert.assertEquals(expectedYazi,actualList);
    }
}
