package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
    @Test
    void dragandDropTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        action.dragAndDrop(source, target).perform();
        Assert.assertEquals(source.getText(), "B");
        Assert.assertEquals(target.getText(), "A");
        driver.quit();
    }

    @Test
    void horizontalSliderTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        Actions action = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        action.clickAndHold(slider).moveByOffset(100, 0).release().perform();
        String value = driver.findElement(By.id("range")).getText();
        Assert.assertEquals(value, "5");
        driver.quit();

    }

    @Test
    void infiniteScrollTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        Actions action = new Actions(driver);
        for (int i = 0; i < 10; i++) {
            action.scrollByAmount(0, 100).perform();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='jscroll-added']")).isDisplayed());
        driver.quit();

    }
}
