package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileDownlod extends TestBase {

    @Test
    public void indirmeTesti(){
        //  C:\Users\49172\OneDrive\Desktop\.logo.png

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.jpg dosyasını indirelim
        bekle(1);
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        bekle(5);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu = "C:\\Users\\49172\\Downloads\\logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



        bekle(2);

    }
}
