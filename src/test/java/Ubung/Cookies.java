package Ubung;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {

    @Test
    public void test01(){

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookies = driver.manage().getCookies();
        int sira= 1;
        for (Cookie each:cookies
             ) {

            System.out.println(sira + "' inci  " +each);
            sira++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedCookies = 5;
        int actualCookies = cookies.size();

        Assert.assertTrue(actualCookies>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

            String expectedCookieDegeri = "USD";
            String actualCookieDegeri = driver.manage().getCookieNamed("i18n-prefs").getValue();

            Assert.assertEquals(expectedCookieDegeri,actualCookieDegeri);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin

        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
         driver.manage().addCookie(yeniCookie);



        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        System.out.println("===================yeni cookie eklendikten sonra==========");
        cookies = driver.manage().getCookies();

         sira = 1;
        for (Cookie each :cookies
             ) {

            System.out.println(sira + "' inci  " +each);
            sira++;
        }

        boolean cookieEklendiMi = false;

        for (Cookie each: cookies
             ) {
            if (each.getName().equals("en sevdigim cookie")){
                cookieEklendiMi= true;
            }
        }

        Assert.assertTrue(cookieEklendiMi);



        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        cookies = driver.manage().getCookies();

        for (Cookie each:cookies
             ) {
            System.out.println(each);

        }

        boolean cookieSilindiMi = true;

        for (Cookie each: cookies
        ) {
            if (each.getName().equals("skin")){
                cookieSilindiMi= false;

            }


        }

        Assert.assertTrue(cookieSilindiMi);





        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        cookies = driver.manage().getCookies();

      int expectedCookieSize = 0;
      int actualCookieSize = cookies.size();

      Assert.assertEquals(expectedCookieSize,actualCookieSize);




        driver.close();
    }

    }

