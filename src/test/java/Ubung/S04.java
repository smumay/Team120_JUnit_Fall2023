package Ubung;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class S04 extends TestBase {

    @Test
    public void test(){

    //1. “https://www.saucedemo.com/ Adresine gidin
        driver.get("https://www.saucedemo.com/");

    //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys("standard_user");
        bekle(2);
    //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
        bekle(2);
    //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();
        bekle(2);


    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

       WebElement ilkUrun = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
       String kayit = ilkUrun.getText();
        System.out.println(kayit);
        ilkUrun.click();
       bekle(2);


    //6. Add to Cart butonuna basin
        ////*[@data-test='add-to-cart-sauce-labs-backpack']

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();


    //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@*='shopping_cart_link']")).click();

    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepet = driver.findElement(By.xpath("//div[@class='cart_item_label']"));

        Assert.assertTrue(sepet.isDisplayed());
        bekle(2);

    //9. Sayfayi kapatin


    //saucedemo.comsaucedemo.com
    //Swag Labs
    //Sauce Labs Swag Labs app
}
}