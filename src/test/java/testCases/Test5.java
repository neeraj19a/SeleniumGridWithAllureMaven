package testCases;

import com.neerajProject.pages.TestBase;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by NEERAJ on 8/14/2017.
 */



public class Test5 extends TestBase{


/*

    @DataProvider(name="devices")
    public Object[][] device_id(){
        return new  Object[][]{
                {"192.168.1.4:5555","4725"},
                {"ZY2227L635","4726"}

        };
    }
*/

    @Test
    public void testTinder(String Device_ID) throws InterruptedException, IOException {
        if(Device_ID.equals("ZY2227L635")){
            System.out.println("App launched on Moto X Play");
        }

        else if (Device_ID.equals("192.168.1.4:5555")) {
            System.out.println("App launched on Moto G");

        }


        Thread.sleep(15000);
        appiumDriver.findElement(By.id("button_login_real")).click();
        Thread.sleep(20000);

        WebElement ele1 = driver.findElementById("rec_card_image");
        WebElement ele2 = driver.findElementById("revised_pass");
        //Perform drag and drop operation using TouchAction class. //Created object of TouchAction class.
        TouchAction action = new TouchAction(appiumDriver);
        System.out.println("It Is dragging element.");
        action.longPress(ele1).moveTo(ele2).release().perform();
        System.out.println("Element has been droped at destination successfully.");


    }

    @Test
    public void testJabong1() throws InterruptedException, IOException{
        System.out.println("App launched1");
        Thread.sleep(15000);
        driver.findElement(By.id("button_login_real")).click();
        Thread.sleep(20000);

        WebElement ele1 = driver.findElementById("rec_card_image");
        WebElement ele2 = driver.findElementById("revised_pass");
        //Perform drag and drop operation using TouchAction class. //Created object of TouchAction class.
        TouchAction action = new TouchAction(appiumDriver);
        System.out.println("It Is dragging element.");
        action.longPress(ele1).moveTo(ele2).release().perform();
        System.out.println("Element has been droped at destination successfully.");


    }


    @Test
    public void testJabong2() throws InterruptedException, IOException{
        System.out.println("App launched2");
        Thread.sleep(15000);
        driver.findElement(By.id("button_login_real")).click();
        Thread.sleep(20000);

        WebElement ele1 = driver.findElementById("rec_card_image");
        WebElement ele2 = driver.findElementById("revised_pass");
        //Perform drag and drop operation using TouchAction class. //Created object of TouchAction class.
        TouchAction action = new TouchAction(appiumDriver);
        System.out.println("It Is dragging element.");
        action.longPress(ele1).moveTo(ele2).release().perform();
        System.out.println("Element has been droped at destination successfully.");

    }


}
