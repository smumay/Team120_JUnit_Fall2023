package Ubung;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class S05 extends TestBase {

    @Test
    public void test(){

    // amazon ana sayfaya gidip url'in amazon icerdigini test edin
        driver.get("https://www.amazon.com");
        String amazonHdD= driver.getWindowHandle();
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        bekle(2);

    // yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https:www.wisequarter.com");
        String wiseHdD= driver.getWindowHandle();
        String expectedWiseUrl = "wise";
        String actualWiseUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualWiseUrl.contains(expectedWiseUrl));
        bekle(2);



    // yeni bir pencere olarak youtube'a gidin ve url'in youtube icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https:www.youtube.com");
        String youTubeHdD= driver.getWindowHandle();
        String expectedYoutubeUrl = "youtube";
        String actualYouTubeUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualWiseUrl.contains(expectedWiseUrl));
        bekle(2);



    // wisequarter'in acik oldugu sayfaya donup title'in Wise icerdigini test edin
        driver.switchTo().window(wiseHdD);
        String expectedTitle = "Wise";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));





    // Amazon'un acik oldugu sayfaya donun ve Title'in Amazon icerdigini test edin
        driver.switchTo().window(amazonHdD);

        expectedTitle = "Amazon";
        actualTitle = driver.getTitle();


        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }
}
