package pages.heroku;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Browser;
import utils.Browser.*;

import static utils.Browser.*;

public class FormAuthenticationPage {
    public FormAuthenticationPage open() {
        visit("https://the-internet.herokuapp.com/login");
        return this;
    }
    public void login(String username, String password) {
        WebDriver driver = Browser.getDriver();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
    }
//    public void login(String username, String password)  {
//        fill(By.id("username"), username);
//        fill(By.id("password"), password);
//        click(By.tagName("button"));
//    }
    public String getWelcomeMessage(){
        return getText(By.tagName("h4"));
    }
    public void quit() {
        closeBrowser();
    }
}
