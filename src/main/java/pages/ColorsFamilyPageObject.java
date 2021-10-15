package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Utilities;

import static org.junit.Assert.assertTrue;

/**
 * This class holds all "Colors Family" page objects with locators
 * and respective methods used to manipulate them.
 */
public class ColorsFamilyPageObject extends PageObject {

    @FindBy(id = "SearchBarInput3")
    WebElement input_search_by_center;

    @FindBy(xpath = "//div[@class='color-swatch__button-group']/a")
    WebElement lnk_view_details;

    public ColorsFamilyPageObject(WebDriver driver) {
        super(driver);
        assertTrue(input_search_by_center.isDisplayed());
    }

    /**
     * Searches for paint using "Search by color name or number" field in the center of the page.
     *
     * @param text string to search
     */
    public void searchPaintFamilyColorCenter(String text) {
        input_search_by_center.sendKeys(text + Keys.RETURN);
        Utilities.waitUntilElementVisible(driver, lnk_view_details);
    }

    /**
     * Retrieves filtered color "View Details Title" attribute.
     *
     * @return title attribute
     */
    public String getColorViewDetailsTitle() {
        return lnk_view_details.getAttribute("title");
    }
}
