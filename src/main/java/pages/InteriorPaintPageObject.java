package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

/**
 * This class holds all "Interior Paint" page objects with locators
 * and respective methods used to manipulate them.
 */
public class InteriorPaintPageObject extends PageObject {

    @FindBy(id = "SimpleSearchForm_SearchTerm")
    WebElement input_search;

    public InteriorPaintPageObject(WebDriver driver) {
        super(driver);
        assertTrue(input_search.isDisplayed());
    }

    /**
     * Searches for paint using search field on top of the page.
     *
     * @param text paint name to search for
     * @return new SearchPaintResultsObject
     */
    public SearchPaintResultsPageObject searchPaint(String text) {
        input_search.sendKeys(text + Keys.RETURN);
        return new SearchPaintResultsPageObject(driver);
    }
}
