package pages.heroku;

import org.openqa.selenium.By;
import utils.Browser;

import static utils.Browser.check;
import static utils.Browser.visit;

public class CheckboxesPage {
    private By getCheckbox(String checkboxName) {
        return By.xpath(String.format("//form[@id='checkboxes']/input[@type='checkbox'][%d]", checkboxName));
    }
    public CheckboxesPage open(){
        visit("https://the-internet.herokuapp.com/checkboxes");
        return this;
    }
    public void check(String checkboxName) {
        Browser.check(getCheckbox(checkboxName));

    }
    public void uncheck(String checkboxName) {
        Browser.uncheck(getCheckbox(checkboxName));

    }
    public boolean isChecked(String checkboxName) {
       return Browser.isSelected(getCheckbox(checkboxName));
    }

}
