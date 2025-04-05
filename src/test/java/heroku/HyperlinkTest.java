package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HyperlinkTest {
    @Test
    void VerifyHyperlink(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");
        driver.findElement(By.cssSelector(".example > ul > li > a[href=\"status_codes/200\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".example > p")));
        Assert.assertEquals(driver.findElement(By.cssSelector(".example > p")).getText(), "This page returned a 200 status code");
        driver.close();

    }
}
