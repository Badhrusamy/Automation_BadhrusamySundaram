package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BigBucket {
    public static <string> void main(String[] args) throws InterruptedException, MalformedURLException {


        WebDriver driver;


        AppiumServiceBuilder service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Dell\\node_modules\\appium\\build\\lib\\main.js"));
        service.withIPAddress("192.168.29.93").usingPort(4723).build();


        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("OPPO CPH2521");
        options.setPlatformName("Android");
        options.setCapability("platformVersion", "14.0");
        options.setApp("C:\\Users\\Dell\\Downloads\\bigbasket.apk");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Login button
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/btn_login_signup']")).click();

        Thread.sleep(3000);

        //continue
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.truecaller:id/confirm']")).click();

        Thread.sleep(3000);


        Thread.sleep(3000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc='Bigbasket'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/button_done']")).click();


        //Click categories

        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/bbBottomNavItemText' and @text='Categories']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id='com.bigbasket.mobileapp:id/parent_layout'])[11]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/title' and @text='All Fruits & Vegetables']")).click();


        //Click FreshVegetables
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.view.View[@content-desc='Fresh Vegetables']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        //Add Groceries
        if (driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.bigbasket.mobileapp:id/btnAddToBasket\"])[1]")).isDisplayed()) {
            driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.bigbasket.mobileapp:id/btnAddToBasket\"])[1]")).click();
        }
//
        if (driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Add\"])[1]")).isDisplayed())
       {
           driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Add\"])[1]")).click();

       }

//
//        if (driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.bigbasket.mobileapp:id/btnAddToBasket\"])[2]")).isDisplayed())
//        {
//            driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.bigbasket.mobileapp:id/btnAddToBasket\"])[2]")).click();
//
//        }


//        if(driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Add\"])[2]")).isDisplayed())
//        {
//         driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Add\"])[2]")).click();
//
//     }


        //Click Basket
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/bbBottomNavItemText' and @text='Basket']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement banner = driver.findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id='com.bigbasket.mobileapp:id/viewProductDetails'])[1]"));
        Point bannerPoint = banner.getLocation();
        Dimension screenSize = driver.manage().window().getSize();
        int startX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
        int endX = 0;

        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action
                .press(PointOption.point(startX, bannerPoint.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(endX, bannerPoint.getY()));
                //.release();
        driver.switchTo();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


        //Delete in swipe
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/deleteView']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Proceed
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/checkoutButton']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Choose timeslot
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='com.bigbasket.mobileapp:id/slotViewRelativeLayout']/android.widget.LinearLayout")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id='com.bigbasket.mobileapp:id/selectedSlotView'])[6]/android.widget.RelativeLayout")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Proceedtopay
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/proceedToPayButton']")).click();

       //Payment
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//android.widget.LinearLayout[@content-desc='btn_pay'])[1]/android.widget.ImageView")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + "Place Order & Pay" + "\"));"));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Place order and pay
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc='btn_pay']/android.widget.LinearLayout")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Continue UPI

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Continue']")).click();


    }


}





