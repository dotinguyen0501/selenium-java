package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;



public class CheckboxesPage {
    private final String url = "https://the-internet.herokuapp.com/checkboxes";

    // Locators for the checkboxes (1-based index)
    private By getCheckbox(int index) {
        return By.cssSelector("input[type='checkbox']");
    }

    public CheckboxesPage open() {
        Browser.visit(url);
        return this;
    }

    public void check(int index) {
        WebElement checkbox = Browser.findElements(By.cssSelector("input[type='checkbox']")).get(index - 1);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheck(int index) {
        WebElement checkbox = Browser.findElements(By.cssSelector("input[type='checkbox']")).get(index - 1);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isChecked(int index) {
        return Browser.isSelected(getCheckbox(index));
    }
}