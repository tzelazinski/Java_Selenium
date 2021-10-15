package SherwinColors;

import org.junit.Assert;
import org.junit.Test;
import pages.*;
import testBase.FunctionalTestBase;
import utilities.Utilities;

/**
 * This test suite contains tests for searching paint and validating details.
 */
public class SherwinPaintTest extends FunctionalTestBase {

    /**
     * For this specific test suite test data can be stored like this, in class.
     * But if necessary to expand test scope to 10, 50 or 100 different paint colors,
     * test data can be stored for example in xls or csv file and be parsed to below variables
     * and make this test data driven.
     */
    private final static String paint_name_search_1 = "tuberose paint";
    private final static String paint_id_number = "6578";
    private final static String paint_details_url = "https://www.sherwin-williams.com/homeowners/color/find-and-explore-colors/paint-colors-by-family/SW6578-tuberose";
    private final static String paint_details_hex_value = "#d47c8c";
    private final static String paint_name_search_2 = paint_name_search_1.split(" ")[0];
    private final static String paint_details_name_number = "SW " + paint_id_number + " " + paint_name_search_2.substring(0, 1).toUpperCase() + paint_name_search_2.substring(1);
    private final static String paint_family_view_details_title = "View details for " + paint_details_name_number;


    @Test
    public void tuberoseSearchTest() {
        HomePageObject homepage = new HomePageObject(driver);
        homepage.acceptAllCookies();
        Utilities.takeScreenshot(driver);
        homepage.clickOnTopbarShopLink();
        InteriorPaintPageObject interiorpaintpage = homepage.clickHomeownerPaintLink();
        Utilities.takeScreenshot(driver);

        SearchPaintResultsPageObject searchpaintresults = interiorpaintpage.searchPaint(paint_name_search_1);
        Utilities.takeScreenshot(driver);

        PaintDetailsPageObject paintdetails = searchpaintresults.openPaintDetails(paint_id_number);
        Utilities.takeScreenshot(driver);
        Assert.assertEquals(paint_details_url, driver.getCurrentUrl());
        Assert.assertEquals(paint_details_name_number, paintdetails.getPaintNameNumber());
        paintdetails.clickColorDetailsTab();
        Utilities.takeScreenshot(driver);
        Assert.assertEquals(paint_details_hex_value, paintdetails.getColorHexValue());
        ColorsFamilyPageObject colorsfamily = paintdetails.clickColorDetailsViewFamilyLink();
        Utilities.takeScreenshot(driver);

        colorsfamily.searchPaintFamilyColorCenter(paint_name_search_2);
        Utilities.takeScreenshot(driver);
        Assert.assertEquals(paint_family_view_details_title, colorsfamily.getColorViewDetailsTitle());

        Utilities.openInNewTab(driver, paint_details_url);
        Utilities.takeScreenshot(driver);
        Assert.assertEquals(paint_details_name_number, paintdetails.getPaintNameNumber());
    }
}
