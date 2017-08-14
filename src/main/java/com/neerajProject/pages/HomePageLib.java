package com.neerajProject.pages;

import javax.swing.JOptionPane;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilityFiles.PageBase;


public class HomePageLib extends TestBase {

    HomePage homePage;

    public HomePageLib(RemoteWebDriver driver){

        this.driver=driver;
        Log.info("Driver in Home Page Lib"+driver);
        homePage = new HomePage(driver);

    }

    @Test(priority=1)
    public void opengmail() throws InterruptedException {
        String baseurl = "https://mail.google.com/";
        driver.manage().window().maximize();
        driver.get(baseurl);
        //wops.waitForPageToLoad("mail.google.com");
        homePage.clickGmailCreateAccount();
        homePage.clicksetGmailFirstName("Steve");
        homePage.clicksetGmailLastName("Mark");
        //homePage.clicksetGmailAddress(email);
        homePage.clicksetGmailPassword("sur39918102007");
        homePage.clicksetGmailPasswordAgain("sur39918102007");
        homePage.clickGmailMonth();
        homePage.clicksetGmailDay("11");
        homePage.clicksetGmailYear("1989");
        homePage.clickGmailGender();
        homePage.clicksetRecoverEmail("testidtvt@gmail.com");
        String testcaptcha = JOptionPane.showInputDialog("Please enter the captch value: ");
        Thread.sleep(15000);
        homePage.clicksetCaptcha(testcaptcha);
        Thread.sleep(6000);
        homePage.clickTerms();
        homePage.clickSubmit();
        Thread.sleep(15000);

    }

    @Test(priority=2)
    public void openfacebook() throws InterruptedException {
        String baseurl = "https://www.facebook.com/";
        Log.info("In Facebook");
        driver.manage().window().maximize();
        get(baseurl);
        //wops.waitForPageToLoad("facebook.com");
        homePage.clicksetFirstName("Steve");
        homePage.clicksetLastName("Mathew");
        //String myemail=email;
        //homePage.clicksetEmail(email);
        //homePage.clicksetConfirmEmail(email);
        homePage.clicksetPassword("sur39918102007");
        homePage.clicksetday();
        homePage.clicksetMonth();
        homePage.clicksetYear();
        homePage.clicksetSex();
        homePage.clickCreateAccount();
        //wops.waitForPageToLoad("gettingstarted");
        //homePage.clickNext();

    }


   /* @Test(priority = 1)
    public void sendmessagtraffic() throws InterruptedException {

        String baseurl = "https://traffup.net/login";
        driver.manage().window().maximize();
        driver.get(baseurl);
        //wops.waitForPageToLoad("login");
        homePage.clickTrafficEmail("mortalglobe@gmail.com");
        homePage.clickTrafficPassword("sur39918102007");
        String testcaptcha = JOptionPane.showInputDialog("Please enter the captch value: ");
        Thread.sleep(5000);
        homePage.clickTrafficCode(testcaptcha);
        homePage.clickTrafficLogin();


        homePage.clickTrafficLikes();
        //wops.waitForPageToLoad("likes");
        List<WebElement> likepages;
        ArrayList<String> namepages = new ArrayList<String>();

        likepages = driver.findElements(By.xpath(".//tbody/tr/td[2]/div"));

        for (int i = 0; i < likepages.size() - 1; i++) {
            namepages.add(likepages.get(i).getText().replaceAll("[0-9]", "").replaceAll("SKIP", "").replaceAll("likes", "").replaceAll("Traffup.net", "").replaceAll(".K", "").trim());
        }


        System.out.println("Here" + namepages);
        System.out.println("Size" + namepages.size());


        String facebookurl = "https://www.facebook.com/";
        driver.get(facebookurl);
        Thread.sleep(5000);
        //wops.waitForPageToLoad("facebook.com");
        homePage.clickFacebookEmail("testidtvt@gmail.com");
        homePage.clickFacebookPassword("nakul19a");
        homePage.clickFacebookLogin();
        //wops.waitForPageToLoad("facebook.com");
        for (int k = 1; k < namepages.size() - 1; k++) {
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
            builder.sendKeys(Keys.DELETE);
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.clear();
            homePage.clickFacebookSearch(namepages.get(k).toString());
            Thread.sleep(2000);
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.sendKeys(Keys.END);
            homePage.FacebookSearch.click();
            //wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
            //Thread.sleep(9000);

            try {
          //      wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
                if (driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).isDisplayed()) {

                    driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).click();
                }
            } catch (Exception e) {
                continue;
            }


            //for(int i=0;i<suggestions.size();i++){
            //Thread.sleep(8000);
            //suggestions.get(i).click();
            //wops.waitForPageToLoad(namepages.get(k).toString());
            //Thread.sleep(15000);

            try {

            //    wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")));
                if (driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).isDisplayed()) {


                    driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).click();
              //      wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".fbNubFlyoutBody.scrollable")));

                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys("Hi Pls like my page mortalglobe Once u like my page I will like your page back https://www.facebook.com/MortalGlobe-701107149984634 Feel free to like I got ur reference through http://traffup.net/ Thanks");
                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                //    wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//a[@class='close button']")));
                    Thread.sleep(4000);
                    driver.findElement(By.xpath(".//a[@class='close button']")).click();

                }
            } catch (Exception e) {
                continue;
            }


        }

        Thread.sleep(8000);
        String baseurl1 = "https://traffup.net/login";
        driver.manage().window().maximize();
        driver.get(baseurl1);

        homePage.clickTrafficLikes();
//        wops.waitForPageToLoad("likes");
        List<WebElement> likepages1;
        ArrayList<String> namepages1 = new ArrayList<String>();
        likepages1 = driver.findElements(By.xpath(".//tbody/tr/td[2]/div"));

        for (int i = 0; i < likepages1.size() - 1; i++) {
            namepages1.add(likepages1.get(i).getText().replaceAll("[0-9]", "").replaceAll("SKIP", "").replaceAll("likes", "").replaceAll("Traffup.net", "").replaceAll(".K", "").trim());
        }


        System.out.println("Here" + namepages1);
        System.out.println("Size" + namepages1.size());

        String facebookurl1 = "https://www.facebook.com/";
        driver.get(facebookurl1);
        Thread.sleep(5000);
  //      wops.waitForPageToLoad("facebook.com");
        //homePage.clickFacebookEmail("testidtvt@gmail.com");
        //homePage.clickFacebookPassword("nakul19a");
        //homePage.clickFacebookLogin();
    //    wops.waitForPageToLoad("facebook.com");
        for (int k = 1; k < namepages1.size() - 1; k++) {
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
            builder.sendKeys(Keys.DELETE);
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.clear();
            homePage.clickFacebookSearch(namepages1.get(k).toString());
            Thread.sleep(2000);
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.sendKeys(Keys.END);
            homePage.FacebookSearch.click();
            //wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
            //Thread.sleep(9000);

            try {
      //          wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
                if (driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).isDisplayed()) {

                    driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).click();
                }
            } catch (Exception e) {
                continue;
            }


            //for(int i=0;i<suggestions.size();i++){
            //Thread.sleep(8000);
            //suggestions.get(i).click();
            //wops.waitForPageToLoad(namepages.get(k).toString());
            //Thread.sleep(15000);
            Thread.sleep(4000);
            try {
                Thread.sleep(4000);
        //        wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")));
                if (driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).isDisplayed()) {

                    Thread.sleep(4000);
                    driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).click();

                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys("Hi Pls like my page mortalglobe Once u like my page I will like your page back https://www.facebook.com/MortalGlobe-701107149984634 Feel free to like I got ur reference through http://traffup.net/ Thanks");
                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
          //          wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@class='close button']")));
                    driver.findElement(By.xpath(".//a[@class='close button']")).click();

                }
            } catch (Exception e) {
                continue;
            }


        }


        Thread.sleep(8000);
        String baseurl2 = "https://traffup.net/login";
        driver.manage().window().maximize();
        driver.get(baseurl2);

        homePage.clickTrafficLikes();
//        wops.waitForPageToLoad("likes");
        List<WebElement> likepages2;
        ArrayList<String> namepages2 = new ArrayList<String>();
        likepages2 = driver.findElements(By.xpath(".//tbody/tr/td[2]/div"));

        for (int i = 0; i < likepages2.size() - 1; i++) {
            namepages2.add(likepages2.get(i).getText().replaceAll("[0-9]", "").replaceAll("SKIP", "").replaceAll("likes", "").replaceAll("Traffup.net", "").replaceAll(".K", "").trim());
        }


        System.out.println("Here" + namepages2);
        System.out.println("Size" + namepages2.size());

        String facebookurl2 = "https://www.facebook.com/";
        driver.get(facebookurl2);
        Thread.sleep(5000);
  //      wops.waitForPageToLoad("facebook.com");
        //homePage.clickFacebookEmail("testidtvt@gmail.com");
        //homePage.clickFacebookPassword("nakul19a");
        //homePage.clickFacebookLogin();
    //    wops.waitForPageToLoad("facebook.com");
        for (int k = 1; k < namepages2.size() - 1; k++) {
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
            builder.sendKeys(Keys.DELETE);
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.clear();
            homePage.clickFacebookSearch(namepages2.get(k).toString());
            Thread.sleep(2000);
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.sendKeys(Keys.END);
            homePage.FacebookSearch.click();
            //wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
            //Thread.sleep(9000);

            try {
//                wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
                if (driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).isDisplayed()) {

                    driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).click();
                }
            } catch (Exception e) {
                continue;
            }


            //for(int i=0;i<suggestions.size();i++){
            //Thread.sleep(8000);
            //suggestions.get(i).click();
            //wops.waitForPageToLoad(namepages.get(k).toString());
            //Thread.sleep(15000);
            Thread.sleep(4000);
            try {
                Thread.sleep(4000);
//                wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")));
                if (driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).isDisplayed()) {

                    Thread.sleep(4000);
                    driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).click();

                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys("Hi Pls like my page mortalglobe Once u like my page I will like your page back https://www.facebook.com/MortalGlobe-701107149984634 Feel free to like I got ur reference through http://traffup.net/ Thanks");
                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
  //                  wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@class='close button']")));
                    driver.findElement(By.xpath(".//a[@class='close button']")).click();

                }
            } catch (Exception e) {
                continue;
            }


        }

        Thread.sleep(8000);
        String baseurl3 = "https://traffup.net/login";
        driver.manage().window().maximize();
        driver.get(baseurl3);

        homePage.clickTrafficLikes();
        wops.waitForPageToLoad("likes");
        List<WebElement> likepages3;
        ArrayList<String> namepages3 = new ArrayList<String>();
        likepages3 = driver.findElements(By.xpath(".//tbody/tr/td[2]/div"));

        for (int i = 0; i < likepages3.size() - 1; i++) {
            namepages3.add(likepages3.get(i).getText().replaceAll("[0-9]", "").replaceAll("SKIP", "").replaceAll("likes", "").replaceAll("Traffup.net", "").replaceAll(".K", "").trim());
        }


        System.out.println("Here" + namepages3);
        System.out.println("Size" + namepages3.size());

        String facebookurl3 = "https://www.facebook.com/";
        driver.get(facebookurl3);
        Thread.sleep(5000);
        wops.waitForPageToLoad("facebook.com");
        //homePage.clickFacebookEmail("testidtvt@gmail.com");
        //homePage.clickFacebookPassword("nakul19a");
        //homePage.clickFacebookLogin();
        wops.waitForPageToLoad("facebook.com");
        for (int k = 1; k < namepages3.size() - 1; k++) {
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
            builder.sendKeys(Keys.DELETE);
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.clear();
            homePage.clickFacebookSearch(namepages3.get(k).toString());
            Thread.sleep(2000);
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.sendKeys(Keys.END);
            homePage.FacebookSearch.click();
            //wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
            //Thread.sleep(9000);

            try {
                wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
                if (driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).isDisplayed()) {

                    driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).click();
                }
            } catch (Exception e) {
                continue;
            }


            //for(int i=0;i<suggestions.size();i++){
            //Thread.sleep(8000);
            //suggestions.get(i).click();
            //wops.waitForPageToLoad(namepages.get(k).toString());
            //Thread.sleep(15000);
            Thread.sleep(4000);
            try {
                Thread.sleep(4000);
                wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")));
                if (driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).isDisplayed()) {

                    Thread.sleep(4000);
                    driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).click();

                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys("Hi Pls like my page mortalglobe Once u like my page I will like your page back https://www.facebook.com/MortalGlobe-701107149984634 Feel free to like I got ur reference through http://traffup.net/ Thanks");
                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                    wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@class='close button']")));
                    driver.findElement(By.xpath(".//a[@class='close button']")).click();

                }
            } catch (Exception e) {
                continue;
            }


        }

        Thread.sleep(8000);
        String baseurl4 = "https://traffup.net/login";
        driver.manage().window().maximize();
        driver.get(baseurl4);

        homePage.clickTrafficLikes();
        wops.waitForPageToLoad("likes");
        List<WebElement> likepages4;
        ArrayList<String> namepages4 = new ArrayList<String>();
        likepages4 = driver.findElements(By.xpath(".//tbody/tr/td[2]/div"));

        for (int i = 0; i < likepages4.size() - 1; i++) {
            namepages4.add(likepages4.get(i).getText().replaceAll("[0-9]", "").replaceAll("SKIP", "").replaceAll("likes", "").replaceAll("Traffup.net", "").replaceAll(".K", "").trim());
        }


        System.out.println("Here" + namepages4);
        System.out.println("Size" + namepages4.size());

        String facebookurl4 = "https://www.facebook.com/";
        driver.get(facebookurl4);
        Thread.sleep(5000);
        wops.waitForPageToLoad("facebook.com");
        //homePage.clickFacebookEmail("testidtvt@gmail.com");
        //homePage.clickFacebookPassword("nakul19a");
        //homePage.clickFacebookLogin();
        wops.waitForPageToLoad("facebook.com");
        for (int k = 1; k < namepages4.size() - 1; k++) {
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
            builder.sendKeys(Keys.DELETE);
            homePage.FacebookSearch.clear();
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.clear();
            homePage.clickFacebookSearch(namepages4.get(k).toString());
            Thread.sleep(2000);
            homePage.FacebookSearch.click();
            homePage.FacebookSearch.sendKeys(Keys.END);
            homePage.FacebookSearch.click();
            //wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
            //Thread.sleep(9000);

            try {
                wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
                if (driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).isDisplayed()) {

                    driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).click();
                }
            } catch (Exception e) {
                continue;
            }


            //for(int i=0;i<suggestions.size();i++){
            //Thread.sleep(8000);
            //suggestions.get(i).click();
            //wops.waitForPageToLoad(namepages.get(k).toString());
            //Thread.sleep(15000);
            Thread.sleep(4000);
            try {
                Thread.sleep(4000);
                wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")));
                if (driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).isDisplayed()) {

                    Thread.sleep(4000);
                    driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).click();

                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys("Hi Pls like my page mortalglobe Once u like my page I will like your page back https://www.facebook.com/MortalGlobe-701107149984634 Feel free to like I got ur reference through http://traffup.net/ Thanks");
                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                    driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                    wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@class='close button']")));
                    driver.findElement(By.xpath(".//a[@class='close button']")).click();

                }
            } catch (Exception e) {
                continue;
            }


        }

    }


    //@Test(priority=2)
    public void secondtry() throws InterruptedException {

        String baseurl = "https://traffup.net/login";
        driver.manage().window().maximize();
        driver.get(baseurl);
        *//*wops.waitForPageToLoad("login");
        homePage.clickTrafficEmail("mortalglobe@gmail.com");
		homePage.clickTrafficPassword("sur39918102007");
		String testcaptcha= JOptionPane.showInputDialog("Please enter the captch value: ");
		Thread.sleep(5000);
		homePage.clickTrafficCode(testcaptcha);
		homePage.clickTrafficLogin();
		*//*
        homePage.clickTrafficLikes();
        wops.waitForPageToLoad("likes");
        //List<WebElement> likepages;

        //likepages=driver.findElements(By.xpath(".//tbody/tr/td[2]/div"));

        //for(int i=0;i<likepages.size()-1;i++){
        //namepages.add(likepages.get(i).getText().replaceAll("[0-9]","").replaceAll("SKIP", "").replaceAll("likes", "").replaceAll("Traffup.net", "").replaceAll(".K", "").trim());
        //}


        //System.out.println("Here"+namepages);
        //System.out.println("Size"+namepages.size());

        String facebookurl = "https://www.facebook.com/";
        driver.get(facebookurl);
        Thread.sleep(5000);
        wops.waitForPageToLoad("facebook.com");
        homePage.clickFacebookEmail("testidtvt@gmail.com");
        homePage.clickFacebookPassword("nakul19a");
        homePage.clickFacebookLogin();
        wops.waitForPageToLoad("facebook.com");
        //for(int k=1;k<namepages.size()-1;k++){
        homePage.FacebookSearch.clear();
        homePage.FacebookSearch.click();
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
        builder.sendKeys(Keys.DELETE);
        homePage.FacebookSearch.clear();
        homePage.FacebookSearch.click();
        homePage.FacebookSearch.clear();
        //homePage.clickFacebookSearch(namepages.get(k).toString());
        Thread.sleep(2000);
        homePage.FacebookSearch.click();
        homePage.FacebookSearch.sendKeys(Keys.END);
        homePage.FacebookSearch.click();
        //wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
        //Thread.sleep(9000);

        try {
            wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
            if (driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).isDisplayed()) {

                driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).click();
            }
        } catch (Exception e) {
            //continue;
        }


        //for(int i=0;i<suggestions.size();i++){
        //Thread.sleep(8000);
        //suggestions.get(i).click();
        //wops.waitForPageToLoad(namepages.get(k).toString());
        //Thread.sleep(15000);

        try {
            Thread.sleep(4000);
            wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")));
            if (driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).isDisplayed()) {

                Thread.sleep(4000);
                driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).click();

                driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys("Hi Pls like my page mortalglobe Once u like my page I will like your page back https://www.facebook.com/MortalGlobe-701107149984634 Feel free to like I got ur reference through http://traffup.net/ Thanks");
                driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                wops.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@class='close button']")));
                driver.findElement(By.xpath(".//a[@class='close button']")).click();

            }
        } catch (Exception e) {
            //	continue;
        }


    }
    //driver.close();
    //}


    //@Test(priority=2)
    public void facebookmsg() throws InterruptedException {
        String facebookurl = "https://www.facebook.com/";
        driver.get(facebookurl);
        Thread.sleep(5000);
        wops.waitForPageToLoad("facebook.com");
        homePage.clickFacebookEmail("testidtvt@gmail.com");
        homePage.clickFacebookPassword("nakul19a");
        homePage.clickFacebookLogin();
        wops.waitForPageToLoad("facebook.com");
        //for(int k=1;k<namepages.size()-1;k++){
        homePage.FacebookSearch.clear();
        homePage.FacebookSearch.click();
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
        builder.sendKeys(Keys.DELETE);
        homePage.FacebookSearch.clear();
        homePage.FacebookSearch.click();
        homePage.FacebookSearch.clear();
        //homePage.clickFacebookSearch(namepages.get(k).toString());
        Thread.sleep(2000);
        homePage.FacebookSearch.click();
        homePage.FacebookSearch.sendKeys(Keys.END);
        //wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
        //Thread.sleep(9000);

        try {
            wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")));
            if (driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).isDisplayed()) {

                driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).isDisplayed();
                driver.findElement(By.xpath("(.//span[@class='fragmentEnt']/../..)[1]")).click();
            }
        } catch (Exception e) {
            //continue;
        }


        //for(int i=0;i<suggestions.size();i++){
        //Thread.sleep(8000);
        //suggestions.get(i).click();
        //wops.waitForPageToLoad(namepages.get(k).toString());
        //Thread.sleep(15000);

        try {

            Thread.sleep(4000);
            wops.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")));
            if (driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).isDisplayed()) {

                Thread.sleep(3000);
                driver.findElement(By.xpath(".//span[@id='pagesHeaderLikeButton']/../div[1]/button")).click();

                driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys("Hi Pls like my page mortalglobe Once u like my page I will like your page back https://www.facebook.com/MortalGlobe-701107149984634 Feel free to like I got ur reference through http://traffup.net/ Thanks");
                driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                driver.findElement(By.xpath(".//div[contains(@class,'FlyoutFooter')]/div/textarea")).sendKeys(Keys.ENTER);
                driver.findElement(By.xpath(".//a[@class='close button']")).click();

            }
        } catch (Exception e) {
            //continue;
        }


    }

    //}


    public String randomString() {
        String charset = "qwertyuioasdfghjklzxcvbnmp";
        StringBuilder sb = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < 4; i++) {
            int pos = ran.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }

        return sb.toString();
    }

    public boolean validateemailregistered() {
        dynamicwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'email ng-binding')]")));
        String emailtext = driver.findElement(By.xpath("//div[contains(@class,'email ng-binding')]")).getText();
        if (emailtext.contains(email)) {
            return true;
        } else {
            return false;
        }
    }

    public String randomInteger() {
        String charset = "1234567890";
        StringBuilder sb = new StringBuilder();
        Random ran = new Random(9);
        for (int i = 0; i < 9; i++) {
            int pos = ran.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }

        return sb.toString();
    }
*/
    //@AfterMethod
    /*public void quit() {
        driver.close();
    }
*/}
