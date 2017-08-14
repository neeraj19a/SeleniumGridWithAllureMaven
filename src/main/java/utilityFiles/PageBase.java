package utilityFiles;

import java.util.*;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;
import com.neerajProject.pages.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

public class PageBase extends TestBase {


    public WebDriverWait wait = new WebDriverWait(driver, 18);
    public org.apache.log4j.Logger Log = Logger.getLogger(PageBase.class);
    private WebElement webElem;

    public PageBase(RemoteWebDriver driver) {
       this.driver=driver;
    }
/*

    public PageBase(RemoteWebDriver driver){
       this.driver=driver;
    }
*/

    public Boolean get(String URL) {
        Log.info("Navigating to -->" + URL);
        driver.get(URL);
        Log.info("Waiting for Page to Load ");
        WebDriverWait wait = new WebDriverWait(driver, 45);
        return wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {

                boolean flag = (((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
                return flag;

            }
        });
    }

    public WebElement findandReplace(String xpath,String replacewith){
        String path= String.format(xpath,replacewith );
        WebElement element=driver.findElement(By.xpath(path));
        return element;
    }

    public List<WebElement> findandReplace(String xpath,String replacewith[]){
        List<WebElement> elements=new ArrayList<>();
        for(String replace:replacewith) {
            String path = String.format(xpath, replace);
            elements.add(driver.findElement(By.xpath(path)));
        }

        return elements;
    }


    public PageBase onElement(WebElement element) {
        this.webElem = element;
        return this;
    }

    public PageBase click() {
        Log.info("Hi logging Click Here");
        webElem.click();
        return this;
    }

    public PageBase click(WebElement element) {
        Log.info("Clicking on Element-->" + element);
        element.click();
        return this;
    }

    public PageBase setText(WebElement element, String text) {
        Log.info("Setting Text " + text + " for WebElement-->" + element.toString());
        element.sendKeys(text);
        return this;
    }


    /**
     * This function will wait till whole page gets loaded with the mentioned
     * URL
     *
     * @param pageURL
     * @return
     */
    public boolean waitForPageToLoad(final String pageURL) {

        Log.info("Waiting for Page to Load with URL---->" + pageURL);
        WebDriverWait wait = new WebDriverWait(driver, 45);
        return wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {

                boolean flag = (((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
                boolean flag1 = driver.getCurrentUrl().contains(pageURL);
                return flag && flag1;

            }
        });
    }

    public void dynamicwait(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }

    public void printcookie() {
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
    }

    public void createorEditCookieValue(String cookiename, String cookievalue) {
        Cookie cookie = driver.manage().getCookieNamed(cookiename);
        driver.manage().deleteCookie(cookie);
        Cookie name = new Cookie(cookiename, cookievalue);
        driver.manage().addCookie(name);
    }

    /**
     * This function is used to scroll vertical
     *
     * @param startValue
     * @param endValue
     */

    public void scrollVerticallWithCords(int startValue, int endValue) {
        try {
            ((JavascriptExecutor) driver).executeScript("scroll(" + startValue
                    + "," + endValue + " );");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This function is used to get Tool Tip Text by hovering mouse
     *
     * @param Hover
     * @return
     */

    public String getToolTipTextEditAd(WebElement Hover) {

        Actions ActionChains = new Actions(driver);
        ActionChains.moveToElement(Hover).build().perform();
        String Tooltip = Hover.getAttribute("title");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Tooltip;
    }

    /**
     * This function is used to generate the String of random length
     *
     * @param length
     * @return
     */

    public static String getRandomString(int length) {
        final String charset = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }

    /**
     * This function is used to navigate directly to a particular URL
     *
     * @param driver
     * @param URL
     */
    public void navigatethirdparty(WebDriver driver, String URL) {

        driver.navigate().to(URL);
    }

    /**
     * Generic method to Switch to Pop Up, enter element as parameter by which
     * clicking on it pop up opens
     *
     * @param popup
     * @return
     */
    public String switchtoPopup(WebElement popup) {
        String mainWindowHandle = driver.getWindowHandle();
        popup.click();
        Set s = driver.getWindowHandles();
        Iterator ite = s.iterator();
        while (ite.hasNext()) {
            String popupHandle = ite.next().toString();
            if (!popupHandle.contains(mainWindowHandle)) {
                driver.switchTo().window(popupHandle);
            }
        }

        return mainWindowHandle;
    }

    /**
     * wait for element to be visible and enabled in order to be clickable
     *
     * @param
     * @param element
     * @return
     */

    // Revisit
    public boolean waitForElementToBeClickable(By element) {
        try {
            wait = new WebDriverWait(driver, 90);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * scroll element to bring in view, scroll down the page
     *
     * @param element
     */
    public void scrollElementIntoView(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(false);", element);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Wait for Element to be clickable
     *
     * @param element
     * @return
     */
    public boolean waitForElementToBeVisible(WebElement element) {
        try {
            wait = new WebDriverWait(driver, 90);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Function to read HTML Source from WebElement
     *
     * @param locator
     * @return
     */
    public  List<String> returnHTML(String locator) {
        Log.info(("Looking for HTML with locator -->" + locator));
        List<WebElement> we = driver.findElements(By.cssSelector(locator));
        List<String> elements = new ArrayList<>();
        for (WebElement ok : we) {
            elements.add(ok.getAttribute("outerHTML"));
        }
        System.out.println("Here are Elements-->" + elements);
        System.out.println();
        return elements;
    }

    //http://aksahu.blogspot.in/2013/12/finding-web-elements-by-executing.html
    //Example
    // To get the element String aJQueryString = "jQuery(\"div.sorted\")";
    // To get parent of the element String aJQueryString = "jQuery(\"div.sorted\").parent()";
    // To mouseover on the element String aJQueryString = "jQuery(\"div.sorted\").mouseover()";
    public WebElement findElementByJQuery(final String jQueryScript) {
        WebElement element = null;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(50, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        try {
            element = wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver d) {
                    String script = "return " + jQueryScript + ".get(0);";
                    JavascriptExecutor jse = (JavascriptExecutor) d;
                    WebElement webElement = (WebElement) jse
                            .executeScript(script);
                    System.out.println("Here is WebElemet with JQuery" + webElement.getTagName() + "and size" + webElement.getSize());
                    return webElement;
                }
            });
        } catch (Exception e) {
            Log.error("Failed to find the element by executing JQuery script '"
                    + jQueryScript + "'." + e);
        }
        return element;
    }


    public List<WebElement> findElementsByJQuery(final String jQueryScript) {
        List<WebElement> elements = null;

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(50, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        try {
            elements = wait.until(new Function<WebDriver, List<WebElement>>() {
                @Override
                public List<WebElement> apply(WebDriver d) {
                    List<WebElement> webElements = new ArrayList<WebElement>();
                    for (int i = 0; ; i++) {
                        String script = "return " + jQueryScript + ".get(" + i
                                + ");";
                        JavascriptExecutor jse = (JavascriptExecutor) d;
                        WebElement webElement = (WebElement) jse
                                .executeScript(script);
                        if (webElement != null) {
                            webElements.add(webElement);
                        } else {
                            break;
                        }
                    }
                    return webElements;
                }
            });
        } catch (Exception e) {
            Log.error("Failed to find the elements by executing JQuery script '"
                    + jQueryScript + "'." + e);
        }
        return elements;
    }
}
