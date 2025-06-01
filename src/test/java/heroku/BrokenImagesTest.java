package heroku;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.heroku.BrokenImagePage;
import utils.Browser;

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
            //Assert.assertTrue(naturalWidth.equals("0") || naturalHeight.equals("0"), "Image is not broken.");
        });
    }
}

