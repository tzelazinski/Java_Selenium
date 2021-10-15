package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * This class holds all "Paint Details" page objects with locators
 * and respective methods used to manipulate them.
 */
public class PaintDetailsPageObject extends PageObject {

    @FindBy(xpath = "//h1[@class='color-info__name-number']/span")
    List<WebElement> lbl_color_info_name_number;

    @FindBy(xpath = "//div[contains(text(), 'Details')]")
    WebElement lnk_color_info_details;

    @FindBy(xpath = "//dt[contains(text(), 'Hex Value')]/parent::dl/dd")
    WebElement lbl_color_details_hex;

    @FindBy(className = "view-family-link")
    WebElement lnk_color_details_view_family;

    public PaintDetailsPageObject(WebDriver driver) {
        super(driver);
        assertTrue(lnk_color_info_details.isDisplayed());
    }

    /**
     * Gathers paint details name and number into single string
     * from color presentation tile.
     *
     * @return concatenated string containing paint number and name
     */
    public String getPaintNameNumber() {
        List<String> nn_list = new ArrayList<>();
        for (WebElement element : lbl_color_info_name_number) {
            nn_list.add(element.getText());
        }
        return StringUtils.join(nn_list, " ");
    }

    /**
     * Clicks "Details" tab link in color details page.
     */
    public void clickColorDetailsTab() {
        lnk_color_info_details.click();
    }

    /**
     * Retrieves color details hex value.
     *
     * @return color details hex value in string format
     */
    public String getColorHexValue() {
        return lbl_color_details_hex.getText();
    }

    /**
     * Clicks Details "View All (given) Paint Colors" link in color details page.
     */
    public ColorsFamilyPageObject clickColorDetailsViewFamilyLink() {
        lnk_color_details_view_family.click();
        return new ColorsFamilyPageObject(driver);
    }
}
