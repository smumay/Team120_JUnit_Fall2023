package Ubung;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class S03 extends TestBase {

    @Test
    public void test(){

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");


    // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        bekle(2);

    // 3. Login kutusuna “username” yazin

        WebElement loginKutusu = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");

    // 4. Password kutusuna “password” yazin
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordKutusu.sendKeys("password");


    // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun

        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        driver.navigate().back();



    // 6. Online banking menusunden Pay Bills sayfasina gidin

        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();


    //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();


    //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Eurozone (euro)");


    //9. “amount” kutusuna bir sayi girin
        WebElement amountKutusu = driver.findElement(By.xpath("//input[@id='pc_amount']"));

        amountKutusu.sendKeys("200");


    //10. “US Dollars” in secilmedigini test edin
        WebElement usDollar = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(usDollar.isSelected());

        bekle(3);


    //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        bekle(3);

    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

        WebElement currencyElementi = driver.findElement(By.xpath("//div[@id='alert_content']"));
        String expected= "Foreign currency cash was successfully purchased.";
        String actual = currencyElementi.getText();
        Assert.assertTrue(actual.contains(expected));



    }
}
