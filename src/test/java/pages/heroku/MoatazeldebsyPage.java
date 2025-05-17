package pages.heroku;

import org.openqa.selenium.By;
import utils.Browser;

public class MoatazeldebsyPage {
    public void open() {
        Browser.visit("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
    }
    public void checkAll() {
        Browser.click(By.xpath("//button[text()='Check All']"));
    }
    public void uncheckAll() {
        Browser.click(By.xpath("//button[text()='Uncheck All']"));
    }
    public boolean isCheckboxChecked(String checkboxName) {
        return Browser.isSelected(By.xpath(String.format("//input[@data-test='checkbox-checkbox%s']", checkboxName)));
    }
}
