package practice;

import org.junit.*;

public class P02 {

    @BeforeClass
    public static void beforeClass(){

        System.out.println("Before class calisti . testler calismaya baslayabilir");
    }

    @AfterClass
    public static void afterClass(){

        System.out.println("Tüm testler basariyla tamamlandi.");
    }

    @Before
    public void setUp(){
        System.out.println(" Before , Yeni Bir Test Kodu Calistiriliyor");
    }

    @After
    public void tearDown(){
        System.out.println("After, Bu test tamamlandi. siradaki test calisirilacak");

    }


    @Test
    public void test01(){
        System.out.println("01 Numarali test calistirildi");
    }

    @Test
    public void test02(){
        System.out.println("02 numarali test calistirildi");
    }
}
