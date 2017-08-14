package com.neerajProject.pages;

import com.google.common.base.Function;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.allure.annotations.Attachment;
import utilityFiles.PageBase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class TestBase extends TestListenerAdapter implements IHookable {

    String methodName = "";

    private WebElement webElem;
    public RemoteWebDriver driver;

    public org.apache.log4j.Logger Log = Logger.getLogger(TestBase.class);
    int testCaseCount = 0;
    private List<RemoteWebDriver> newDriversList;


    @BeforeMethod(alwaysRun = true)
    public void setup() throws MalformedURLException {
    /*    if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
            System.out.println("Opening Firefox Browser");
            driver = new FirefoxDriver();
        } else {
            File chromeDriver = new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
            System.out.println("Opening Chrome Browser");
            System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
            driver = new ChromeDriver();
        }
        org.apache.log4j.BasicConfigurator.configure();
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\log4j.properties");
*/

        System.out.println("Here in Before Method");
        org.apache.log4j.BasicConfigurator.configure();
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\log4j.properties");

        InitiateDriver initiateDriver = new InitiateDriver();
        driver = initiateDriver.getDriver();
        newDriversList = new ArrayList<RemoteWebDriver>();
        Log.info(this.getClass().getName());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Log.info("Executing class : " + this.getClass().getCanonicalName() + ", test case number : " + ++testCaseCount);


          /*  try {
                Log.info("In Try Block");
                    driver.get("http://www.quikr.com");
            } catch (Exception e) {
                Log.info("In Catch Block");
                driver.get("http://www.quikr.com");
            }
        */
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenShot();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Closing Browser");
            if (newDriversList.size() != 0) {
                for (RemoteWebDriver webDriver : newDriversList) {
                    webDriver.quit();
                }
            }

        }
    }


    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            methodName = testResult.getMethod().getMethodName();
            takeScreenShot();
        }
    }

    @Attachment(value = "Failure in method", type = "image/png")
    private byte[] takeScreenShot() {
        System.out.println("==========Found failure in method---->  " + methodName + "  <----- Taking screenshot============");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


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

    public WebElement findandReplace(String xpath, String replacewith) {
        String path = String.format(xpath, replacewith);
        WebElement element = driver.findElement(By.xpath(path));
        return element;
    }

    public List<WebElement> findandReplace(String xpath, String replacewith[]) {
        List<WebElement> elements = new ArrayList<>();
        for (String replace : replacewith) {
            String path = String.format(xpath, replace);
            elements.add(driver.findElement(By.xpath(path)));
        }

        return elements;
    }


    public TestBase onElement(WebElement element) {
        this.webElem = element;
        return this;
    }

    public TestBase click() {
        Log.info("Hi logging Click Here");
        webElem.click();
        return this;
    }

    public TestBase click(WebElement element) {
        Log.info("Clicking on Element-->" + element);
        element.click();
        return this;
    }

    public TestBase setText(WebElement element, String text) {
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

    /*public void dynamicwait(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }
*/
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
    /*public boolean waitForElementToBeClickable(By element) {
        try {
            wait = new WebDriverWait(driver, 90);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            return false;
        }

        return true;
    }
*/

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
   /* public boolean waitForElementToBeVisible(WebElement element) {
        try {
            wait = new WebDriverWait(driver, 90);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return false;
        }

        return true;
    }
*/

    /**
     * Function to read HTML Source from WebElement
     *
     * @param locator
     * @return
     */
    public List<String> returnHTML(String locator) {
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
                .ignoring(java.util.NoSuchElementException.class);
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
                .ignoring(java.util.NoSuchElementException.class);
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
