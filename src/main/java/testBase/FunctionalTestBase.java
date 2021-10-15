package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import utilities.PropertiesOperations;
import utilities.ScreenshotOnFailure;
import utilities.Utilities;

import java.util.concurrent.TimeUnit;

/**
 * This is the base class for setting up browser driver given browser type
 * stored in configuration file.
 * Driver is initialised, browser is maximized and given start page is loaded.
 * After test is finished it takes care of cleanup and closing the browser.
 */

public class FunctionalTestBase {

    public static WebDriver driver;

    @Rule
    public ScreenshotOnFailure failure = new ScreenshotOnFailure(driver);

    /**
     * This method runs before any test suite, initialises the
     * driver and navigates to given url.
     */
    @BeforeClass
    public static void LaunchBrowserAndNavigate() throws Exception {

        String browser = PropertiesOperations.getPropertyValueByKey("browser");
        String url = PropertiesOperations.getPropertyValueByKey("start_url");

        Utilities.cleanupScreenshotsDirectory();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    /**
     * Deletes cookies after test case execution.
     */
    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    /**
     * Closes browser window with all the tabs and popups after test suite execution.
     */
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}