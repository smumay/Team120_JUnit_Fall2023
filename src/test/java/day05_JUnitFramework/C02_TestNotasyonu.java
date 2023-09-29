package day05_JUnitFramework;


import org.junit.Ignore;
import org.junit.Test;

public class C02_TestNotasyonu {



    @Test

    public void amazonTest(){
        System.out.println("amazon test");


    }

    @Test @Ignore
    public void youtubeTest(){

        System.out.println("youtube test");
    }

    @Test
    public void wiseTest(){
        System.out.println("wise test");

    }

    @Test
    public void test04(){
        int sayi1 =10;
        int sayi2 =50;

        if (sayi1>sayi2){
            System.out.println("karsilastirma testi PASSED");
        }else{
            System.out.println("Karsilastirma testi FAILED");
            throw new IllegalArgumentException();
        }
    }


}
