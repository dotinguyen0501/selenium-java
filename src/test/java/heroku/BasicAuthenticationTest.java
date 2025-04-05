package heroku;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthenticationTest {
    /**
     * Open browser
     * Navigate to the page https://the-internet.herokuapp.com/basic_auth
     * Verify the text "Congratulations! You must have the proper credentials."
     * */
    @Test
    void VerifyLoginSuccessWithValidCredentials() {
        // Open browser
        // Navigate to the page https://the-internet.herokuapp.com/basic_auth
        // Verify the text "Congratulations! You must have the proper credentials."
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.cssSelector(".example > p")).getText().contains("Congratulations! You must have the proper credentials."));
        driver.close();
    }
}
