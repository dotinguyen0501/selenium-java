package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v131.emulation.Emulation;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.ConnectionType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class ChromeTest {
    @Test
    void openWithDefaultMode() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();

    }
    @Test
    void openWithHeadLessMode(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        assertEquals(driver.getTitle(), "Selenium");
        driver.quit();

    }
    @Test
    void openWithMobileViewPort(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 430);
        deviceMetrics.put("height", 932);
        Map<String, Object> mobileEmulator = new HashMap<>();
        mobileEmulator.put("deviceMetrics", deviceMetrics);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulator);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        assertEquals(driver.getTitle(), "Selenium");
      //  driver.quit();
    }
    @Test
    void openWithBetaChromeVersion(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("134.0.0");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }
    @Test
    void openBrowserWithFakeGeoLocation(){
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        // Mountain view
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(55.755826),
                Optional.of(37.6173),
                Optional.of(1)
        ));
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[.='Where am I?']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#lat-value")).getText(),"37.386052");
        Assert.assertEquals(driver.findElement(By.cssSelector("#long-value")).getText(),"-122.083851");

        //driver.quit();
    }
    @Test
    void simulate3GNetworkCondition(){
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // Enable Network emulation
        devTools.send(Network.enable(Optional.of(100000000), Optional.empty(), Optional.empty()));

        // Set network conditions to emulate 3G or 4G
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                75000,
                25000,
                Optional.of(ConnectionType.NONE),
                Optional.of(0),
                Optional.of(0),
                Optional.of(false)
        ));
        driver.get("https://selenium.dev");
    }


}
