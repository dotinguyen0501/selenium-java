package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class TableTest {
    @Test
    void tc05() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/tables");
        List<Double> dueList = driver
                .findElements(By.xpath("//table[@id='table1']//tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$", "")))
                .collect(Collectors.toList());
        double maxDue = Collections.max(dueList);
        int rowIndex = dueList.indexOf(maxDue) + 1;
        String lastname = driver.findElement(By.xpath(String.format("//table[@id='table1']//tbody/tr[%d]/td[1]", rowIndex)))
                .getText();
        String firstname = driver.findElement(By.xpath(String.format("//table[@id='table1']//tbody/tr[%d]/td[2]", rowIndex)))
                .getText();
        Assert.assertEquals(String.format("%s, %s", lastname, firstname), "Doe, Jason");
        driver.close();
    }


}

