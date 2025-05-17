package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.heroku.BrokenImagePage;
import utils.Browser;

import java.sql.SQLOutput;
import java.util.List;

public class BrokenImagesTest {
    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");

    }

    @Test
    void VerifyBrokenImages() {
        BrokenImagePage brokenImagePage = new BrokenImagePage();
        brokenImagePage.open();
        List<WebElement> images = brokenImagePage.getAllImages();
        images.forEach(image -> {
            String imageUrl = image.getAttribute("src");
            String naturalWidth = image.getAttribute("naturalWidth");
            String naturalHeight = image.getAttribute("naturalHeight");
            System.out.println("---------------------------------------------------");
            System.out.println("Image URL: " + imageUrl);
            System.out.println("Natural Width: " + naturalWidth);
            System.out.println("Natural Height: " + naturalHeight);
        });
        Assert.assertEquals(images.get(0).getAttribute("naturalWidth"), "0");
        Assert.assertEquals(images.get(1).getAttribute("naturalHeight"), "0");
    }
    }

