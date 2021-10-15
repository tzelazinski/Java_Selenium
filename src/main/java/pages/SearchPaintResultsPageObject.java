package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

/**
 * This class holds all "Interior Paint Search Results" page objects with locators
 * and respective methods used to manipulate them.
 */
public class SearchPaintResultsPageObject extends PageObject {

    @FindBy(className = "punchout-search__results-title")
    WebElement lbl_search_results_summary;

    public SearchPaintResultsPageObject(WebDriver driver) {
        super(driver);
        assertTrue(lbl_search_results_summary.isDisplayed());
    }

    /**
     * Clicks on specific paint in search results given paint id number .
     *
     * @param paint_id paint id number to click in search results.
     * @return new PaintDetailsPageObject
     */
    public PaintDetailsPageObject openPaintDetails(String paint_id) {
        WebElement searched_paint_in_results = driver.findElement(By.id("title-" + paint_id));
        searched_paint_in_results.click();
        return new PaintDetailsPageObject(driver);
    }
}
