package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {
@Test
    void VerifycheckboxesIsChecked() {
        // Open browser
        // Navigate to the page https://the-internet.herokuapp.com/checkboxes
        // Verify checkbox-2 is checked
        // Verify checkbox-1 is not checked
       // Verify checkbox-1 should be able to check
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    driver.get("https://the-internet.herokuapp.com/checkboxes");
    Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[@type='checkbox'][2]")).isSelected());
    Assert.assertFalse(driver.findElement(By.xpath("//form[@id='checkboxes']/input[@type='checkbox'][1]")).isSelected());
    driver.findElement(By.xpath("//form[@id='checkboxes']/input[@type='checkbox'][1]")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[@type='checkbox'][1]")).isSelected());

    driver.close();
    }
    @Test
    void VerifyCheckAllButtonWorkingFine(){
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
    wait.until(ExpectedConditions.titleContains("Test Automation Practices"));
    driver.findElement(By.xpath("//button[text()='Check All']")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
    Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
    Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
    driver.close();

    }
    @Test
    void VerifyUncheckAllButtonWorkingFine(){
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
    wait.until(ExpectedConditions.titleContains("Test Automation Practices"));
    driver.findElement(By.xpath("//button[text()='Uncheck All']")).click();
    Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
    Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
    Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
    driver.close();
    }
    @Test
    void VerifyAbleToUncheckAllCheckboxes_afterAllChecked(){
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
    wait.until(ExpectedConditions.titleContains("Test Automation Practices"));
    driver.findElement(By.cssSelector(".mt-6.space-x-4 > button:nth-child(1)")).click();
    Assert.assertTrue(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox1']")).isSelected());
    Assert.assertTrue(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox2']")).isSelected());
    Assert.assertTrue(driver.findElement(By.cssSelector("input[data-test='checkbox-checkbox3']")).isSelected());

    driver.findElement(By.cssSelector(".mt-6.space-x-4 > button:nth-child(2)")).click();
    Assert.assertFalse(driver.findElement(By.cssSelector("label [data-test='checkbox-checkbox1']")).isSelected());
    Assert.assertFalse(driver.findElement(By.cssSelector("label [data-test='checkbox-checkbox2']")).isSelected());
    Assert.assertFalse(driver.findElement(By.cssSelector("label [data-test='checkbox-checkbox3']")).isSelected());

    driver.close();

    }

}
