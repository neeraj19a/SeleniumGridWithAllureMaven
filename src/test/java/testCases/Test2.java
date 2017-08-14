package testCases;

import com.neerajProject.pages.HomePage;
import com.neerajProject.pages.TestBase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test2 extends TestBase {


    @Test
    public  void function1Test1() {
        System.out.println("In Function1 of test 2 class");
        driver.get("https://hello.is/about");
    }

    @Test
    public  void jsoupTestClassSecond() throws InterruptedException, IOException {
        System.out.println("In Jsoup Function Class Second");
        System.out.println("Driver is here-->"+driver);
        System.out.println("Lets navigate Google");

        driver.get("http://google.com");
        Thread.sleep(10000);
        Log.info("Hi logging here");
        Log.error("Hi logging here Error");

        System.out.println("Lets click");
         get("http://en.wikipedia.org/");
        Log.info("Printing Cookie");
        printcookie();

        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements newsHeadlines = doc.select("#mp-itn b a");

        for (Element e : newsHeadlines) {
            System.out.println("Here is JSOUP HTML" + e.toString());
        }
    }

}
