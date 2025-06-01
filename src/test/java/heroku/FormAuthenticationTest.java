package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.heroku.FormAuthenticationPage;
import utils.Browser;

import java.text.Normalizer;

public class FormAuthenticationTest {
    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");
    }

    @Test
        /*tc_01: Login with valid credentials*/
    void LoginWithValidCredentials() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(Browser.getDriver().getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertEquals(formAuthenticationPage.getWelcomeMessage(), "Welcome to the Secure Area. When you are done click logout below.");

    }

    @Test
        /*tc_02: Login with invalid credentials*/
    void LoginWithInvalidCredentials() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("invalidUser", "invalidPassword");
        Assert.assertEquals(Browser.getDriver().getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertEquals(Browser.getDriver().findElement(By.id("flash")).getText(), "Your username is invalid!\n×");
    }

    @Test
        /*tc_04: Login with valid username and invalid password*/
    void LoginWithInvalidPassword() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith", "invalidPassword");
        Assert.assertEquals(Browser.getDriver().getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertEquals(Browser.getDriver().findElement(By.id("flash")).getText(), "Your password is invalid!\n×");
    }
}

