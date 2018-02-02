package ru.stqa.training.selenium;

//import com.sun.tools.internal.xjc.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
//import static org.openqa.selenium.support.ui.ExpectedConditions.
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class NewTab {


    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        //   ChromeOptions options = new ChromeOptions();
        //   options.addArguments("start-fullscreen");
        //    driver = new ChromeDriver(options);
        //   DesiredCapabilities caps = new DesiredCapabilities();
        //   caps.setCapability(ChromeOptions.CAPABILITY,options);
        //    driver = new ChromeDriver(caps);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 40);
    }

   // @Test
    public void Test_1() {
        Booking ("https://www.onvoya.com/flights/search?From=JFK&To=LGW&Class=E&Departure=2018-02-16&Return=2018-02-26&Adult=1&Ref=WF1","Cheapoair");}

    @Test
    public void Test_2() {
        Booking ("https://www.onvoya.com/flights/search?From=JFK&To=LGW&Class=E&Departure=2018-02-16&Return=2018-02-26&Adult=1&Ref=WF1","SmartFares");}

    @Test
    public void Test_3() {
        Booking ("https://www.onvoya.com/flights/search?From=NYC&To=LON&Class=E&Departure=2018-02-16&Return=2018-02-26&Adult=1&Ref=WF1","FareDepot");}

    @After

    public void stop() {
        driver.quit();
        driver = null;
    }

    public void Booking (String link, String provider) {


        driver.navigate().to(link);

        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));

        String parentHandle = driver.getWindowHandle(); // Save parent window

        for (int i = 1; i < 26; i++) {

        String provider_text = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
        if (provider_text.equals(provider)) {
            driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();

            try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    Set<String> handles = driver.getWindowHandles();
            if (handles.size() > 1) { // Check if more than 1 window is open
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (!parentHandle.equals(handle)) {
                break;
            }
        }
    }

                driver.findElement(By.xpath("//*[@id=\"travellerFirstName1\"]")).sendKeys("Linda");
                driver.findElement(By.xpath("//*[@id=\"travellerMiddleName1\"]")).sendKeys("M.");
                driver.findElement(By.xpath("//*[@id=\"travellerLastName1\"]")).sendKeys("Book");
                driver.findElement(By.xpath("//*[@id=\"travellerDOB1\"]")).sendKeys("04231995");
                driver.findElement(By.xpath("//*[@id=\"travellerTSARedressNumber1\"]")).sendKeys("12345678");

                driver.findElement(By.xpath("//*[@id=\"confirmEmailAddress\"]")).sendKeys("a.budkina@onvoya.com");
                driver.findElement(By.xpath("//*[@id=\"contactPhoneNo\"]")).sendKeys("+79190100733");

                driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Linda");
                driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Book");
                driver.findElement(By.xpath("//*[@id=\"billingAddress\"]")).sendKeys("123 Main Street");
                driver.findElement(By.xpath("//*[@id=\"billingCity\"]")).sendKeys("New York");
                driver.findElement(By.xpath("//*[@id=\"billingZip\"]")).sendKeys("35801");
                driver.findElement(By.xpath("//*[@id=\"cardNumber\"]")).sendKeys("4111111111111111");
                driver.findElement(By.xpath("//*[@id=\"expiryDate\"]")).sendKeys("0620");
                driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("123");
                System.out.println("*********************************************************");
                System.out.println("All fields are filled out");


    Select select = new Select(driver.findElement(By.xpath("//*[@id=\"billingState\"]")));
                select.selectByVisibleText("Alabama");

    String provider_details = driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div")).getText();

    //детали открываются

                driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[2]/div[2]/div/div[2]")).click();
                System.out.println("Details are opened");
                driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]")).click();
                System.out.println("Details are closed");

    //buy

                driver.findElement(By.xpath("//*[@id=\"book-now-btn\"]")).click();

        WebElement confirmation = driver.findElement(By.xpath("//*[@id=\"portlet_booking_WAR_bookingportlet\"]/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]"));
        wait.until(visibilityOf(confirmation));


        String PNR = driver.findElement(By.xpath("//*[@id=\"portlet_booking_WAR_bookingportlet\"]/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/b")).getText();
        System.out.println("Booking successful " + " Provider: " + provider_details + " PNR: " + PNR);
        System.out.println("*********************************************************");


//        driver.manage().window().maximize();
        driver.close();
        break;
        }
            for (int j = 1; j < 26; j++) {

                String provider_text1 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+j+"]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
                if (!provider_text1.equals(provider)) {
        System.out.println("Not fares for "+provider);
        }}

// Return to parent window
        driver.switchTo().window(parentHandle);

    }}}




