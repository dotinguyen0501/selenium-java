package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    /**
     * Open browser
     * Navigate to the login page https://the-internet.herokuapp.com/login
     * Fill in the username tomsmith
     * Fill in the password SuperSecretPassword!
     * **/
    @Test
    /*tc_01: Login with valid credentials*/
    void LoginWithValidCredentials() {
        // Open browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        //Fill username tomsmith

        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }
    @Test
    /*tc_02: Login with invalid credentials*/
    void LoginWithInvalidCredentials() {
        // Open browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        //Fill username tomsmit
        driver.findElement(By.id("username")).sendKeys("toms");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("button")).click();
        Assert.assertEquals(driver.findElement(By.id("flash")).getText(), "Your username is invalid!\n×");
        Assert.assertEquals(driver.findElement(By.id("flash")).getCssValue("background-color"), "rgba(198, 15, 19, 1)");
    }

    @Test
    /*tc_04: Login with valid username and invalid password*/
    void LoginWithInvalidPassword() {
        WebDriver driver  = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.tagName("button")).click();
        Assert.assertEquals(driver.findElement(By.id("flash")).getText(), "Your password is invalid!\n×");
        Assert.assertEquals(driver.findElement(By.id("flash")).getCssValue("background-color"), "rgba(198, 15, 19, 1)");
    }
    @Test
    /*tc_05: Login with empty username and valid password*/
    void LoginWithEmptyUsername() {}
    @Test
    /*tc_06: Login with valid username and empty password*/
    void LoginWithEmptyPassword() {}
    @Test
    /*tc_07: Login with empty username and empty password*/
    void LoginWithEmptyUsernameAndPassword() {}
    @Test
    /*tc_08: Login with SQL Injection*/
    void LoginWithSQLInjection() {}
    @Test
    /*tc_09: Login with XSS Injection*/
    void LoginWithXSSInjection() {}
    @Test
    /*tc_10: Login with special characters*/
    void LoginWithSpecialCharacters() {}
    @Test
    /*tc_11: Login with long username and password*/
    void LoginWithLongUsernameAndPassword() {}
    @Test

    /*tc_12: Login with short username and password*/
    void LoginWithShortUsernameAndPassword() {}
    @Test
    /*tc_13: Login with valid username and password in different case*/
    void LoginWithValidUsernameAndPasswordInDifferentCase() {}
    @Test
    /*tc_14: Login with valid username and invalid password in multiple times*/
    void LoginWithValidUsernameAndInvalidPasswordInMultipleTimes() {}


    }


