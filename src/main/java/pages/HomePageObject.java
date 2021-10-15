package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.Utilities;

import static org.junit.Assert.assertTrue;

/**
 * This class holds all "Home Page" objects with locators
 * and respective methods used to manipulate them.
 */
public class HomePageObject extends PageObject {

    @FindBy(id = "ensAllow")
    WebElement btn_accept_cookies;

    @FindBy(xpath = "//button[@id='tab-1']")
    WebElement lnk_topbar_shop;

    @FindBy(id = "tab-1-sublink-3")
    WebElement lnk_shop_left_homeowner;

    @FindBy(linkText = "Paint")
    WebElement lnk_shop_homeowner_interiors_paint;

    public HomePageObject(WebDriver driver) {
        super(driver);
        assertTrue(lnk_topbar_shop.isDisplayed());
    }

    /**
     * Clicks on "OK" button in cookies popup.
     */
    public void acceptAllCookies() {
        btn_accept_cookies.click();
    }

    /**
     * Clicks on "Shop Products & Color" topbar dropdown link.
     */
    public void clickOnTopbarShopLink() {
        lnk_topbar_shop.click();
    }

    /**
     * Hovers over "Homeowner Paints, Stains & Supplies" link.
     */
    public void hoverOverHomeownerLink() {
        Actions action = new Actions(driver);
        action.moveToElement(lnk_shop_left_homeowner).build().perform();
    }

    /**
     * Performs hover and clicks "Paint" link on Home Interiors list.
     *
     * @return new InteriorPaintPageObject
     */
    public InteriorPaintPageObject clickHomeownerPaintLink() {
        hoverOverHomeownerLink();
        Utilities.takeScreenshot(driver);
        lnk_shop_homeowner_interiors_paint.click();
        return new InteriorPaintPageObject(driver);
    }
}
