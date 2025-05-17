package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest {

    @Test
    /*tc_01: Login with valid credentials*/
    void LoginWithValidCredentials() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        driver.close();
    }
    @Test
    /*tc_02: Login with invalid credentials*/
    void LoginWithInvalidCredentials() {
        // Open browser
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/login");
        //Fill username tomsmit
        driver.findElement(By.id("username")).sendKeys("toms");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("button")).click();
        Assert.assertEquals(driver.findElement(By.id("flash")).getText(), "Your username is invalid!\n×");
        Assert.assertEquals(driver.findElement(By.id("flash")).getCssValue("background-color"), "rgba(198, 15, 19, 1)");

        driver.close();
    }

    @Test
    /*tc_04: Login with valid username and invalid password*/
    void LoginWithInvalidPassword() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.tagName("button")).click();
        Assert.assertEquals(driver.findElement(By.id("flash")).getText(), "Your password is invalid!\n×");
        Assert.assertEquals(driver.findElement(By.id("flash")).getCssValue("background-color"), "rgba(198, 15, 19, 1)");

        driver.close();}

    }


