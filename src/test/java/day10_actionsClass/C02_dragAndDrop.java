package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_dragAndDrop extends TestBase {

    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        bekle(2);
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragMe,dropHere).perform();
        bekle(2);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYazi = "Dropped!";
        String actualYazi = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();

        Assert.assertEquals(expectedYazi,actualYazi);

    }


}
