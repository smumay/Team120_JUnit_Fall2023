package Ubung;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class OgrenciAmazon extends TestBase {

    @Test
    public void itemSearchTest(){
        //Test Case 1: Searching for an Item
        //Test Scenario:
        //Open the Amazon.com website.
        //Locate the search text box.
        //Enter the name of an item.
        //Click the search button.
        //Expected Outcome:
        //The item is found in the search results.
        //Open the Amazon.com website.
        driver.get("https://www.amazon.com");
        //Locate the search text box.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //Enter the name of an item.
        //Click the search button.
        aramaKutusu.sendKeys("Kitap Hırsızı"+ Keys.ENTER);
        bekle(3);
        //Expected Outcome:
        //The item is found in the search results.
        WebElement actualResult = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(actualResult.isDisplayed());
    }
    @Test
    public void createAccountTest(){
        //Test Case 2: Creating an Account (Positive)
        //
        //Test Scenario:
        //Open the Amazon.com website.
        //Click on the "Account & Lists" button.
        //Select "Create your Amazon account."
        //Fill in the required fields with valid data for Your name, Mobile number or email, password, and re-enter password.
        //Click the "Continue" button.
        //Expected Outcome:
        //The user should see the "Solve this puzzle to protect your account" page.
        //Open the Amazon.com website.
        driver.get("https://www.amazon.com");
        //Click on the "Account & Lists" button.
        driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).click();
        //Select "Create your Amazon account."
        driver.findElement(By.id("createAccountSubmit")).click();
        //Fill in the required fields with valid data for Your name, Mobile number or email, password, and re-enter password.
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
        Faker faker = new Faker();
        String password = faker.internet().password();
        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        //Click the "Continue" button.
        driver.findElement(By.xpath("//span[@id='auth-continue']")).click();
        //Expected Outcome:
        //The user should see the "Solve this puzzle to protect your account" page.
        WebElement solvePuzzleIframe= driver.findElement(By.xpath("//iframe[@id='cvf-aamation-challenge-iframe']"));
        driver.switchTo().frame(solvePuzzleIframe);
        WebElement successfullEnter = driver.findElement(By.xpath("//span[@id='aacb-captcha-header']"));
        Assert.assertTrue(successfullEnter.isDisplayed());
    }
    @Test
    public void nameNegativeDataTest(){
        //Test Case 3: Creating an Account (Negative - Missing Your Name)
        //
        //Test Scenario:
        //Open the Amazon.com website.
        //Click on the "Account & Lists" button.
        //Select "Create your Amazon account."
        //Fill in the required fields without entering Your name.
        //Click the "Continue" button.
        //Expected Outcome:
        //The user should see a warning message: "Enter your name."
        //Open the Amazon.com website.
        driver.get("https://www.amazon.com");
        //Click on the "Account & Lists" button.
        driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).click();
        //Select "Create your Amazon account."
        driver.findElement(By.id("createAccountSubmit")).click();
        //Fill in the required fields without entering Your name.
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
        Faker faker = new Faker();
        String password = faker.internet().password();
        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        //Click the "Continue" button.
        driver.findElement(By.xpath("//span[@id='auth-continue']")).click();
        //Expected Outcome:
        //The user should see a warning message: "Enter your name"
        String expectedYazi = "Enter your name";
        String actualYaziElementi = driver.findElement(By.xpath("(//div[@role='alert'])[1]")).getText();
        Assert.assertEquals(expectedYazi,actualYaziElementi);
    }
    @Test
    public void passwordMismatchTest() {
        //Test Case 4: Creating an Account (Negative - Password Mismatch)
        //
        //Test Scenario:
        //Open the Amazon.com website.
        //Click on the "Account & Lists" button.
        //Select "Create your Amazon account."
        //Fill in the required fields with valid data for Your name, Mobile number or email, a password, and an incorrect re-entered password.
        //Click the "Continue" button.
        //Expected Outcome:
        //The user should see a warning message: "Passwords must match."
        //Open the Amazon.com website.
        driver.get("https://www.amazon.com");
        //Click on the "Account & Lists" button.
        driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).click();
        //Select "Create your Amazon account."
        driver.findElement(By.id("createAccountSubmit")).click();
        //Fill in the required fields with valid data for Your name, Mobile number or email, a password, and an incorrect re-entered password.
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();
        //Click the "Continue" button.
        driver.findElement(By.xpath("//span[@id='auth-continue']")).click();
        //Expected Outcome:
        //The user should see a warning message: "Passwords must match"
        String expectedYazi = "Passwords must match";
        String actualYaziElementi = driver.findElement(By.xpath("//div[@id='auth-password-mismatch-alert']")).getText();
        WebElement actualYaziElementi2 = driver.findElement(By.xpath("//div[@id='auth-password-mismatch-alert']"));
        Assert.assertEquals(expectedYazi,actualYaziElementi);
        Assert.assertTrue(actualYaziElementi.contains("Passwords must match"));
        Assert.assertTrue(actualYaziElementi2.isDisplayed());
    }
    @Test
    public void invalidPasswordTest() {
        //Test Case 5: Creating an Account (Negative - Short Password)
        //
        //Test Scenario:
        //Open the Amazon.com website.
        //Click on the "Account & Lists" button.
        //Select "Create your Amazon account."
        //Fill in the required fields with valid data for Your name, Mobile number or email, a password shorter than 6 characters, and re-enter the same short password.
        //Click the "Continue" button.
        //Expected Outcome:
        //The user should see a warning message: "Minimum 6 characters required for the password."
        //Open the Amazon.com website.
        driver.get("https://www.amazon.com");
        //Click on the "Account & Lists" button.
        driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).click();
        //Select "Create your Amazon account."
        driver.findElement(By.id("createAccountSubmit")).click();
        //Fill in the required fields with valid data for Your name, Mobile number or email, a password shorter than 6 characters, and re-enter the same short password.
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .perform();
        //Click the "Continue" button.
        driver.findElement(By.xpath("//span[@id='auth-continue']")).click();
        //Expected Outcome:
        //The user should see a warning message: "Minimum 6 characters required"
        String expectedYazi = "Minimum 6 characters required";
        String actualYaziElementi = driver.findElement(By.xpath("//div[@id='auth-password-invalid-password-alert']")).getText();
        Assert.assertEquals(expectedYazi,actualYaziElementi);
    }
}
