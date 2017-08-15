package com.neerajProject.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by NEERAJ on 7/15/2017.
 */
public class InitiateDriver {

    public RemoteWebDriver driver;
    public AppiumDriver appiumDriver;
    DesiredCapabilities cap = new DesiredCapabilities();


    @Factory(dataProvider = "parallelDp")
    public InitiateDriver() throws MalformedURLException {
        if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getBrowserCapabilities("firefox"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } else if (System.getProperty("browser").equalsIgnoreCase("ANDROID") && System.getProperty("Device_ID").equalsIgnoreCase("ZY2227L635")) {
            setupcapabilities(System.getProperty("Device_ID"));
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4726/wd/hub"), cap);

            /*
            System.out.println("Moto X Play");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4726/wd/hub"), cap);

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ANDROID");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            //desiredCapabilities.setCapability("applicationName", this.applicationName);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "https://github.com/appium/java-client/raw/master/src/test/java/io/appium/java_client/ApiDemos-debug.apk");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), desiredCapabilities);
*/

        } else {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getBrowserCapabilities("Chrome"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }


    }

    public AppiumDriver getAppiumDriver()
    {
        if (appiumDriver == null)
            throw new RuntimeException("We have not instantiated the driver.");
        return appiumDriver;
    }

    public void setupcapabilities(String device)
    {
        File appDir = new File("..\\MyNewFramework\\");
        File app = new File(appDir, "com.tinder_4.5.5.apk");

        cap.setCapability("deviceName", device);
        cap.setCapability("automationName", "Appium");
        cap.setCapability("platformName", "ANDROID");
        cap.setCapability("app-package", "com.tinder");
        cap.setCapability("app-activity", "com.tinder.activities.ActivityMain");
        cap.setCapability("udid", device);
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    }

    private DesiredCapabilities getBrowserCapabilities(String browser) {
        DesiredCapabilities capabilities = null;
        //String appName = System.getProperty("appName") == null ? getProperties().get("AppName") : System.getProperty("appName");
        //String appPath =System.getProperty("appPath") == null ? getProperties().get("AppPath") : System.getProperty("appPath");

        try {
            if (browser.equalsIgnoreCase("Firefox")) {
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setPlatform(Platform.ANY);
            } else if (browser.equalsIgnoreCase("IE")) {
                //InternetExplorerDriverManager.getInstance().setup();
                //System.setProperty("webdriver.ie.driver", "../../../../resources/IEDriverServer.exe");
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setBrowserName("internet explorer");
                capabilities.setPlatform(Platform.WINDOWS);
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setCapability("ie.ensureCleanSession", true);
            } else if (browser.equalsIgnoreCase("Chrome")) {
                //ChromeDriverManager.getInstance().setup();
                /*if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
                    System.setProperty("webdriver.chrome.driver", "/home/" + System.getProperty("user.name") + "/Documents/chromedriver");
                } else {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\" + System.getProperty("user.name") + "/Documents/chromedriver");
                }
                */
                File chromeDriver = new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
                System.out.println("Opening Chrome Browser");
                System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
                capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capabilities.setPlatform(Platform.ANY);
            }

           /* else if (runOn.equalsIgnoreCase("ANDROID_APP"))
            {

                File appDir = new File(appPath);
                File app = new File(appDir, appName);
                capabilities=new DesiredCapabilities();
                capabilities.setCapability("deviceName", "");
                capabilities.setCapability("platformName", "Android");
                //  capabilities.setCapability("appWaitActivity", "com.quikr.homepage.helper.HomePageActivity_new");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "com.quikr");
                capabilities.setCapability("appActivity", "com.quikr.old.SplashActivity");
            }
            */
         else {
                // default is firefox
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setPlatform(Platform.ANY);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return capabilities;
    }

    public RemoteWebDriver getDriver() {
        if (driver == null)
            throw new RuntimeException("We have not instantiated the driver.");
        return driver;
    }
}

