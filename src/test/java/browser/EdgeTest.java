package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EdgeTest {
    @Test
    void openEdgeWithDefaultMode(){
        WebDriver driver = new EdgeDriver();
        //open the browser and navigate to the website
        driver.get("https://www.selenium.dev/");
        //Verify the title of the site
        Assert.assertEquals(driver.getTitle(), "Selenium");
        //close the browser
        driver.quit();
    }
    @Test
    void openEdgeWithHeadLessMode(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        //driver.quit();
    }
}
