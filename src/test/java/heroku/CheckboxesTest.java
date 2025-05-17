package heroku;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.heroku.CheckboxesPage;
import pages.heroku.MoatazeldebsyPage;
import utils.Browser;

public class CheckboxesTest {
    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");
    }

    @Test
    void verifyCheckboxesIsChecked() {
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.open();
        checkboxesPage.check("1");
        Assert.assertTrue(checkboxesPage.isChecked("1"));
    }

    @Test
    void verifyCheckAllButtonWorkingFine() {
        MoatazeldebsyPage moatazeldebsyPage = new MoatazeldebsyPage();
        moatazeldebsyPage.open();
        moatazeldebsyPage.checkAll();
        Assert.assertTrue(moatazeldebsyPage.isCheckboxChecked("1"));
        Assert.assertTrue(moatazeldebsyPage.isCheckboxChecked("2"));
        Assert.assertTrue(moatazeldebsyPage.isCheckboxChecked("3"));
    }

    @Test
    void VerifyUncheckAllButtonWorkingFine() {
        MoatazeldebsyPage moatazeldebsyPage = new MoatazeldebsyPage();
        moatazeldebsyPage.open();
        moatazeldebsyPage.uncheckAll();
        Assert.assertFalse(moatazeldebsyPage.isCheckboxChecked("1"));
        Assert.assertFalse(moatazeldebsyPage.isCheckboxChecked("2"));
        Assert.assertFalse(moatazeldebsyPage.isCheckboxChecked("3"));
    }

    @Test
    void VerifyAbleToUncheckAllCheckboxes_afterAllChecked() {
        MoatazeldebsyPage moatazeldebsyPage = new MoatazeldebsyPage();
        moatazeldebsyPage.open();

        moatazeldebsyPage.checkAll();
        Assert.assertTrue(moatazeldebsyPage.isCheckboxChecked("1"));
        Assert.assertTrue(moatazeldebsyPage.isCheckboxChecked("2"));
        Assert.assertTrue(moatazeldebsyPage.isCheckboxChecked("3"));

        moatazeldebsyPage.uncheckAll();
        Assert.assertFalse(moatazeldebsyPage.isCheckboxChecked("1"));
        Assert.assertFalse(moatazeldebsyPage.isCheckboxChecked("2"));
        Assert.assertFalse(moatazeldebsyPage.isCheckboxChecked("3"));
    }

    @AfterClass
    void tearDown() {
        Browser.closeBrowser();
    }
}
