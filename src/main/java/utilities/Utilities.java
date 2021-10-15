package utilities;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Contains generic utilities methods.
 */
public class Utilities {

    /**
     * Opens given url in new browser tab.
     *
     * @param driver WebDriver instance
     * @param url    url to navigate to in new tab
     */
    public static void openInNewTab(WebDriver driver, String url) {
        String currentTab = driver.getWindowHandle();
        String init_tab = "window.open('about:blank','_blank');";
        ((JavascriptExecutor) driver).executeScript(init_tab);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        tabs.remove(currentTab);
        driver.switchTo().window(tabs.get(0));
        driver.get(url);
    }

    /**
     * Takes a screenshot and saves png file in Screenshots directory.
     *
     * @param driver WebDriver instance
     */
    public static void takeScreenshot(WebDriver driver) {
        Shutterbug.shootPage(driver).save("./Screenshots/");
    }

    /**
     * Deletes all files in Screenshots directory.
     */
    public static void cleanupScreenshotsDirectory() throws IOException {
        String path = "./Screenshots/";
        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.exists()) {
                    if (!f.delete()) {
                        throw new IOException("File " + f + " was not deleted.");
                    }
                }
            }
        }
    }

    /**
     * Provides a wait period until specific element is visible.
     *
     * @param driver  WebDriver instance
     * @param element given element to be visible
     */
    public static void waitUntilElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(visibilityOf(element));
    }
}
