package utilityFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

import java.io.Serializable;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by NEERAJ on 7/9/2017.
 */
public class  ByJQuery extends By implements Serializable {
        private final String query;

        public ByJQuery(String query) {
            checkNotNull(query, "Cannot find elements with a null JQuery expression.");
            this.query = query;
        }

        @Override
        public List<WebElement> findElements(SearchContext context) {
            WebDriver driver = getWebDriverFromSearchContext(context);

            if (!isJQueryInThisPage(driver)) {
                injectJQuery(driver);
            }

            return new ByJavaScript("return $(" + query + ")").findElements(context);
        }

        private static WebDriver getWebDriverFromSearchContext(SearchContext context) {
            if (context instanceof WebDriver) {
                return (WebDriver)context;
            }
            if (context instanceof WrapsDriver) {
                return ((WrapsDriver)context).getWrappedDriver();
            }
            throw new IllegalStateException("Can't access a WebDriver instance from the current search context.");
        }

        private static boolean isJQueryInThisPage(WebDriver driver) {
            // TODO Some JavaScript test for a JQuery object.
            return false;
        }

        private static void injectJQuery(WebDriver driver) {
            // TODO Load JQuery from a file, inject it into the page via JS.
        }

        @Override
        public String toString() {
            return "By.jQuery: \"$(" + query + ")\"";
        }
    }


