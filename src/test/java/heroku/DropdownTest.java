package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropdownTest {
    @Test
    void VerifyabletoSelectOption1() {
        // Open browser
        // Navigate to the page https://the-internet.herokuapp.com/dropdown
        // Select option 1
        // Verify option 1 is selected
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //driver.findElement(By.id("dropdown")).click();
        WebElement select = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select dropdown = new Select(select);
        dropdown.selectByIndex(1);
        Assert.assertTrue(driver.findElement(By.xpath("//option[@value='1']")).isSelected());
        driver.close();
    }
    @Test
    void ableSelectMultipleOptions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        WebElement select = driver.findElement(By.id("fruits"));
        Select dropdown = new Select(select);
        dropdown.selectByIndex(1);
        dropdown.selectByIndex(2);
        dropdown.selectByIndex(3);
        Assert.assertTrue(dropdown.getAllSelectedOptions().size() == 3);
        driver.close();
    }
    @Test
    void ableDeSelectAllOptions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        WebElement select = driver.findElement(By.id("fruits"));
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText("Banana");
        dropdown.selectByVisibleText("Apple");
        dropdown.selectByVisibleText("Orange");
        dropdown.deselectAll();
        Assert.assertTrue(dropdown.getAllSelectedOptions().size() == 0);
        driver.close();
    }
    @Test
    void   ableDeSelectOption(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        WebElement select = driver.findElement(By.id("fruits"));
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText("Banana");
        dropdown.deselectByVisibleText("Banana");
        dropdown.selectByVisibleText("Apple");
        dropdown.selectByVisibleText("Orange");
        Assert.assertTrue(dropdown.getAllSelectedOptions().size() == 2);
        driver.close();
    }
    @Test
    void verifyTextFieldIsDisabled(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("form input[type='text']"));
        Assert.assertFalse(driver.findElement(By.cssSelector("input[type='text']")).isEnabled());
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebElement progressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));
        // Verify the progress bar is displayed
        Assert.assertTrue(progressBar.isDisplayed());

        // Wait for the status to change to "Disable"
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(message.getText(), "It's enabled!");

        driver.close();

    }
}
