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
        checkboxesPage.check(1);
        Assert.assertTrue(checkboxesPage.isChecked(1));
    }
    @Test
    void debugVerifyCheckboxesIsChecked() {
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.open();

        // Debug: Print initial state of checkbox 1
        System.out.println("Initial state of checkbox 1: " + checkboxesPage.isChecked(1));

        checkboxesPage.check(1);

        // Debug: Print state of checkbox 1 after checking
        System.out.println("State of checkbox 1 after checking: " + checkboxesPage.isChecked(1));

        Assert.assertTrue(checkboxesPage.isChecked(1));
    }

    @Test
    void debugVerifycheckAllButtonWorkingFine() {
        MoatazeldebsyPage moatazeldebsyPage = new MoatazeldebsyPage();
        moatazeldebsyPage.open();

        // Debug: Print initial state of checkboxes
        System.out.println("Initial state of checkbox 1: " + moatazeldebsyPage.isCheckboxChecked("1"));
        System.out.println("Initial state of checkbox 2: " + moatazeldebsyPage.isCheckboxChecked("2"));
        System.out.println("Initial state of checkbox 3: " + moatazeldebsyPage.isCheckboxChecked("3"));

        moatazeldebsyPage.checkAll();

        // Debug: Print state of checkboxes after uncheckAll
        System.out.println("State of checkbox 1 after checkAll: " + moatazeldebsyPage.isCheckboxChecked("1"));
        System.out.println("State of checkbox 2 after checkAll: " + moatazeldebsyPage.isCheckboxChecked("2"));
        System.out.println("State of checkbox 3 after checkAll: " + moatazeldebsyPage.isCheckboxChecked("3"));

        Assert.assertTrue(moatazeldebsyPage.isCheckboxChecked("1"));
        Assert.assertTrue(moatazeldebsyPage.isCheckboxChecked("2"));
        Assert.assertTrue(moatazeldebsyPage.isCheckboxChecked("3"));
    }

    @Test

    void debugVerifyUncheckAllButtonWorkingFine() {
        MoatazeldebsyPage moatazeldebsyPage = new MoatazeldebsyPage();
        moatazeldebsyPage.open();

        // Debug: Print initial state of checkboxes
        System.out.println("Initial state of checkbox 1: " + moatazeldebsyPage.isCheckboxChecked("1"));
        System.out.println("Initial state of checkbox 2: " + moatazeldebsyPage.isCheckboxChecked("2"));
        System.out.println("Initial state of checkbox 3: " + moatazeldebsyPage.isCheckboxChecked("3"));

        moatazeldebsyPage.uncheckAll();

        // Debug: Print state of checkboxes after uncheckAll
        System.out.println("State of checkbox 1 after uncheckAll: " + moatazeldebsyPage.isCheckboxChecked("1"));
        System.out.println("State of checkbox 2 after uncheckAll: " + moatazeldebsyPage.isCheckboxChecked("2"));
        System.out.println("State of checkbox 3 after uncheckAll: " + moatazeldebsyPage.isCheckboxChecked("3"));

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
