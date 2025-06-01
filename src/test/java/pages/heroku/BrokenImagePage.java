package pages.heroku;

import org.openqa.selenium.By;
import utils.Browser;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BrokenImagePage {
    private static final String PAGE_URL = "https://the-internet.herokuapp.com/broken_images";
    private static final By IMAGE_LOCATOR = By.cssSelector(".example img");

    public void open() {
        Browser.visit(PAGE_URL);
    }

    public List<WebElement> getAllImages() {
        return Browser.getDriver().findElements(IMAGE_LOCATOR);
    }

    public boolean isImageBroken(WebElement image) {
        return image.getAttribute("naturalWidth").equals("0");
    }
}