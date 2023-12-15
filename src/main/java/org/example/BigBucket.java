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
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.File;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BigBucket {
    //public static <string> void main(String[] args) throws InterruptedException, MalformedURLException {

    @Test
    public void validateResponse() throws InterruptedException, MalformedURLException {
        WebDriver driver;


        AppiumServiceBuilder service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Dell\\node_modules\\appium\\build\\lib\\main.js"));
        service.withIPAddress("192.168.29.93").usingPort(4723).build();


        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("OPPO CPH2521");
        options.setPlatformName("Android");
        options.setCapability("platformVersion", "14.0");
        options.setApp("C:\\Users\\Dell\\Downloads\\bigbasket.apk");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Reporter.log("Driver Initiated Successfully");
        //Thread.sleep(5000);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Login with OTP
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/btn_login_signup']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.truecaller:id/continueWithDifferentNumber']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.google.android.gms:id/credential_primary_label' and @text='086681 34785']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Reporter.log("Login successfull");

        //Change delivery address

        //Current location

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Use my current location']")).isDisplayed()) {

            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Use my current location']")).click();
        }
//
//        else
//        {
//
//            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/selected_address']")).click();
//            driver.findElement(AppiumBy.xpath("//android.widget.RadioButton[@resource-id='com.bigbasket.mobileapp:id/radioButton']")).click();
//        }
//
//        if (driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/selected_address']")).isDisplayed()) {
//
//            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/selected_address']")).click();
//        }
//
//
//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/btnChooseLocation']")).click();


        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")).click();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        if (driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/btnUseThisLocation']")).isDisplayed()) {

            driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/btnUseThisLocation']")).click();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Reporter.log("Delivery address set Successfully");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/txtDoorDescription' and @text='1 lakh+ products at lowest prices']")).click();

        Reporter.log("Big basket selected");
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/button_done']")).click();

        Reporter.log("Navigated to Homepage successfully");
        //Click categories


        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/bbBottomNavItemText' and @text='Categories']")).click();
        Reporter.log("Navigated to categories successfully");

        driver.findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id='com.bigbasket.mobileapp:id/parent_layout'])[11]")).click();
        Reporter.log("Selected Fruits & Vegetables");
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/title' and @text='All Fruits & Vegetables']")).click();

        Reporter.log("Clicked All Fruits & Vegetables");
        //Click FreshVegetables
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.view.View[@content-desc='Fresh Vegetables']")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Reporter.log("Clicked FreshVegetables");

        //Add fruits & vegetables
        if (driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.bigbasket.mobileapp:id/btnAddToBasket\"][1])")).isDisplayed()) {
            driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.bigbasket.mobileapp:id/btnAddToBasket\"][1])")).click();
        }

        if (driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Add\"])[1]")).isDisplayed()) {
            driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Add\"])[1]")).click();

        }


        //Click categories

        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/bbBottomNavItemText' and @text='Categories']")).click();
        Reporter.log("Navigated to categories successfully");
        // Add  Groceries
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/title' and @text='Foodgrains, Oil & Masala']")).click();
        //Select Wheat
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/title' and @text='Atta, Flours & Sooji']")).click();
        //Click Wheat atta
        driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc='Product Image'])[6]")).click();


        if (driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/btnAddToBasket'])[1]")).isDisplayed()) {

            driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/btnAddToBasket'])[1]")).click();

        }
        if (driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc='Add'])[1]")).isDisplayed()) {
            driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc='Add'])[1]")).click();

        }

//        if (driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=com.bigbasket.mobileapp:id/btnAddToBasket][1])")).isDisplayed()) {
//            driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=com.bigbasket.mobileapp:id/btnAddToBasket][1])")).click();
//        }


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


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
        Reporter.log("Deleted the item Successfully");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Verfiy the items in the cart

        //Fresh onion

        WebElement cartItem1 = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bigbasket.mobileapp:id/view_foreground'])[1]"));
        String cartItemText = cartItem1.getText();
        if (cartItemText.contains("Fresh-onion")) {

            Reporter.log("Fresh-onion added to cart as per my requirements");
        }
        assert cartItemText.contains("Fresh-onion");


        WebElement cartItem2 = driver.findElement(By.xpath("((//android.widget.LinearLayout[@resource-id='com.bigbasket.mobileapp:id/view_foreground'])[2]"));
        String cartItemText2 = cartItem2.getText();
        if (cartItemText.contains("Chicken")) {

            Reporter.log("Chicken added to cart as per my requirements");
        }
        // Perform verification, for example using assertions
        assert cartItemText2.contains("Chicken");

        WebElement cartItem3 = driver.findElement(By.xpath("(//android.widget.LinearLayout[@resource-id='com.bigbasket.mobileapp:id/view_foreground'])[3]"));
        String cartItemText3 = cartItem3.getText();
        if (cartItemText.contains("Prawns")) {

            Reporter.log("Prawns added to cart as per my requirements");
        }
        // Perform verification, for example using assertions
        assert cartItemText3.contains("Prawns");


        //select address
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.bigbasket.mobileapp:id/checkoutButton\"]")).click();

        //Default address
        driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id=\"com.bigbasket.mobileapp:id/radioButton\"]")).click();
        //Click confirm
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.bigbasket.mobileapp:id/btn_confirm\"]")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        //Proceed
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/checkoutButton']")).click();
        Reporter.log("Navigated for proceed for payment");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Choose timeslot
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@resource-id='com.bigbasket.mobileapp:id/slotViewRelativeLayout']/android.widget.LinearLayout")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout[@resource-id='com.bigbasket.mobileapp:id/selectedSlotView'])[6]/android.widget.RelativeLayout")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Proceedtopay
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/proceedToPayButton']")).click();
        Reporter.log("Proceed for payment Successfully");
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
        Reporter.log("Navigated to Payment Gateway Successfully");

    }


}





