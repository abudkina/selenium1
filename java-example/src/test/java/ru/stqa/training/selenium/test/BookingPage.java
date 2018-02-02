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

    //  @Test
    public void Booking()  {

        //Cheapoair
      Booking("http://web2.onvoya.com/flights/booking?searchSessionId=d937d858-f132-4d99-8044-d5205288cc17&itineraryKey=3SFO1519776300000CIE181TPE1519891200000CIE&itineraryId=f359e63d-152d-4644-9a8c-81724abf0687&provider=Cheapoair&deepLink=null");
        //SmartFares

    }

   // @Test
    public void Booking_1()  {

        //Cheapoair
        Booking("http://web2.onvoya.com/flights/booking?searchSessionId=d937d858-f132-4d99-8044-d5205288cc17&itineraryKey=0003SFO1519776300000CIE0181TPE1519891200000CIE&itineraryId=e125391c-0879-4d9d-97c6-716951c616a9&provider=Smartfares&deepLink=null");
        //SmartFares

    }

    @Test
    public void Booking_2()  {

        //Cheapoair
        Booking("http://web2.onvoya.com/flights/booking?searchSessionId=f637ae7d-c6b3-4760-9646-3fbb4d7a7786&itineraryKey=3SFO1519776300000CIE181TPE1519891200000CIE&itineraryId=0d8409c5-2bce-4773-b72e-ae6a47ea6ca3&provider=FareStreet&deepLink=null");
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
