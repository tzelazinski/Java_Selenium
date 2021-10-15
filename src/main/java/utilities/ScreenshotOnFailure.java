package utilities;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;

/**
 * This class provides functionality of taking screenshots on test failure.
 */
public class ScreenshotOnFailure implements MethodRule {

    private final WebDriver driver;

    public ScreenshotOnFailure(WebDriver driver) {
        this.driver = driver;
    }

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    Utilities.takeScreenshot(driver);
                    throw t;
                }
            }
        };
    }
}

