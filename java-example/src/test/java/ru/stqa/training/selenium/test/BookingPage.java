package ru.stqa.training.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BookingPage {

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 10);
    }

      @Test
    public void Booking()  {

        //Cheapoair
      Booking("http://web2.onvoya.com/flights/booking?searchSessionId=3a5fa074-0441-4ac6-824d-0cd673c53248&itineraryKey=92JFK1534370700000UXE1015MAD1534431600000UXE&itineraryId=5889746f-d880-45d9-a5dc-f86ffe99cf8d&provider=Cheapoair&deepLink=null");
        //SmartFares

    }


    @After

    public void stop () {
        driver.quit();
        driver = null;
    }

    private void Booking (String url) {

        //driver.navigate().to("https://www.onvoya.com/flights/booking?searchSessionId=00536e9a-8909-400d-878a-e1ba9b5054d9&itineraryKey=114JFK1525210200000BAE2273LGW1527784500000BAE&itineraryId=1eb67a27-4172-42a0-a6ab-94aca9c63070&provider=FareStreet&deepLink=null");

        driver.navigate().to(url);

        // WebElement preloader = driver.findElement(By.id("preloader"));
        //  wait.until(invisibilityOf(preloader));


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

        String provider = driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div")).getText();

        // детали открываются

        driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[2]/div[2]/div/div[2]")).click();
        System.out.println("Details are opened");
        driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]")).click();
        System.out.println("Details are closed");

        //buy

        driver.findElement(By.xpath("//*[@id=\"book-now-btn\"]")).click();

        WebElement confirmation = driver.findElement(By.xpath("//*[@id=\"portlet_booking_WAR_bookingportlet\"]/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]"));
        wait.until(visibilityOf(confirmation));
        String PNR = driver.findElement(By.xpath("//*[@id=\"portlet_booking_WAR_bookingportlet\"]/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/b")).getText();
        System.out.println("Booking successful " + " Provider: " + provider + " PNR: " + PNR);
        System.out.println("*********************************************************");

    }

}
