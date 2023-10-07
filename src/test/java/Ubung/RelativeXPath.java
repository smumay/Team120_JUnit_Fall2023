package Ubung;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class RelativeXPath {

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        //2- Add Element butonuna basin
        //3- Delete butonu’nun gorunur oldugunu test edin
        //4- Delete tusuna basin
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin


    static WebDriver driver ;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" https://the-internet.herokuapp.com/add_remove_elements/");
    }


    @AfterClass
    public static void teardown(){
        ReusableMethods.bekle(2);
        driver.close();
    }


    @Test
    public void test01(){
        //2- Add Element butonuna basin

        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();


        //3- Delete butonu’nun gorunur oldugunu test edin

        WebElement deleteButonu = driver.findElement(By.xpath("//button[@class='added-manually']"));

        Assert.assertTrue("delete butonu görünür" ,deleteButonu.isDisplayed());


        //4- Delete tusuna basin

        deleteButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveElement =driver.findElement(By.xpath("//h3[.='Add/Remove Elements']"));

        //Assert.assertFalse("Add/Remove Elements görünür " ,addRemoveElement.isDisplayed());
        Assert.assertTrue(addRemoveElement.isDisplayed());



    }


}
