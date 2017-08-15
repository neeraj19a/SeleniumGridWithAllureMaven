package com.neerajProject.pages;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by NEERAJ on 8/15/2017.
 */
public class AppiumTestBase extends TestListenerAdapter implements IHookable {


    String methodName = "";

    public AppiumDriver appiumDriver;
    public org.apache.log4j.Logger Log = Logger.getLogger(TestBase.class);

    int testCaseCount = 0;
    private List<RemoteWebDriver> newDriversList;




    @Parameters("Device_ID")
    @BeforeMethod(alwaysRun = true)
    public void setup(String device) throws MalformedURLException {
        String port="";
        try {
            System.out.println("Device is"+device);
            if(device.equalsIgnoreCase("ZY2227L635")){
                port="4726";
            }
            else {
                port="4725";
            }
            System.out.println("Port is"+port);

            InitiateDriver initiateDriver = new InitiateDriver(device, port);
            appiumDriver = initiateDriver.getAppiumDriver();
            Log.info("Here is appium Driver-->" + appiumDriver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
/*
    @DataProvider(name = "devices",parallel=true)
    public Object[][] device_id() {
        return new Object[][]{
                {"192.168.1.4:5555", "4725"},
                {"ZY2227L635", "4726"}

        };
    }*/

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
        return ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.BYTES);
    }


}
