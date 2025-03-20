package exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BraveTest {
    @Test
    void openBraveWithDefaultMode(){
        ChromeOptions braveOptions = new ChromeOptions();
        braveOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        WebDriver driver = new ChromeDriver(braveOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
    }
    @Test
    void openBraveWithHeadLessMode(){
        ChromeOptions braveOptions = new ChromeOptions();
        braveOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        braveOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(braveOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
    }
}
