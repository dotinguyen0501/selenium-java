package pages.heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;

import java.util.List;

import static utils.Browser.*;

public class MoatazeldebsyPage {
    public void open() {
        Browser.visit("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
    }
    public void checkAll() {
        List<WebElement> checkboxes = Browser.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

        public void uncheckAll() {
            List<WebElement> checkboxes = Browser.findElements(By.cssSelector("input[type='checkbox']"));
            for (WebElement checkbox : checkboxes) {
                if (checkbox.isSelected()) {
                    checkbox.click();
                }
            }
        }

    public boolean isCheckboxChecked(String checkboxName) {
        return Browser.isSelected(By.xpath(String.format("//input[@data-test='checkbox-checkbox%s']", checkboxName)));
    }
}
