package testCases;

import java.io.IOException;
import java.util.HashMap;

import com.neerajProject.pages.HomePage;
import com.neerajProject.pages.TestBase;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.neerajProject.pages.HomePageLib;
import ru.yandex.qatools.allure.annotations.Title;

import static utilityFiles.PropertyReader.getProperties;
import static utilityFiles.XMLReader.getTestDataBasedOnEnviornment;


public class Test1 extends TestBase {

    //private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public org.apache.log4j.Logger Log = Logger.getLogger(Test1.class);

    /*public RemoteWebDriver getDriver() {
        return (RemoteWebDriver) webDriver.get();
    }
*/
    @Title("First Allure Test case")
    @Test
    public void function1Test1() throws IOException, InterruptedException {
        //Test data Support
        HashMap<String, String> testDataProduct1 = getTestDataBasedOnEnviornment(getProperties().get("PSA_TESTDATA_FILE"), "Product1", "QA");

        //PropertyReader propertyReader = new PropertyReader();
        //propertyReader.bringObjectProperty();
        //System.out.println(System.getProperty("env"));
        Log.info("Hi logging here");
        Log.error("Hi logging here Error");

        //PageBase webDriverOperations = new PageBase(driver);
        //webDriverOperations.click();
        HomePageLib app=new HomePageLib(driver);
        app.openfacebook();

        System.out.println(testDataProduct1.get("name"));

        if (System.getProperty("env").equalsIgnoreCase("test")) {
            System.out.println("Property updated and found");
        } else {
            System.out.println("Property not updated or not found");
        }
        //driver.get("http://en.wikipedia.org/");
        Assert.assertEquals("One".equals("Two"), true);

    }

    @Test(groups = "my")
    public void function2Test1() {
        System.out.println("In Function2 of test 1 class");
    }

    @Test
    public void jsoupTestReadHTML() throws InterruptedException, IOException {
        System.out.println("In Jsoup Function");
        Log.info("Hi logging here");
        Log.error("Hi logging here Error");
        System.out.println("Driver is here-->" + driver);
        System.out.println("Lets navigate Adobe Site");

        //To Test JQuery for website
        get("https://training.adobe.com/training/current-courses.html#p=1&country=India");
        WebElement element = findElementByJQuery("jQuery(\"span:contains('Search Course')\").click()");
        System.out.println("Lets click");
        element.click();
        System.out.println("Clicked");

        //To test HomePageLib which contains all functionality functions
        System.out.println("Lets navigate Facebook Site");
        get("http://facebook.com");
        Thread.sleep(3000);
        HomePage homePage = new HomePage(driver);
        homePage.clickFacebookEmail("testidtvt@gmail.com");

        System.out.println("Lets navigate Facebook Site Again and do some more operations");
        HomePageLib homePageLib=new HomePageLib(driver);
        homePageLib.openfacebook();

        System.out.println("Lets navigate Wikipedia Site");
        get("http://en.wikipedia.org/");

        System.out.println(returnHTML("#mp-itn b a"));
        WebElement element1 = driver.findElement(By.xpath("//a[text()='Log in']"));
        click(element1);

        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements newsHeadlines = doc.select("#mp-itn b a");

        for (Element e : newsHeadlines) {
            System.out.println("Here is JSOUP HTML" + e.toString());
        }
    }

}
