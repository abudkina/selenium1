package ru.stqa.training.selenium;

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
    public void Booking_1() {

        //FareStreet
        Booking("https://www.onvoya.com/flights/booking?searchSessionId=00536e9a-8909-400d-878a-e1ba9b5054d9&itineraryKey=114JFK1525210200000BAE2273LGW1527784500000BAE&itineraryId=1eb67a27-4172-42a0-a6ab-94aca9c63070&provider=FareStreet&deepLink=null");
    }
    @Test
    public void Booking_2() {

    //SmartFares
        Booking ("https://www.onvoya.com/flights/booking?searchSessionId=fc457288-1c23-434f-93ca-42230668b5db&itineraryKey=10LAX1522348200000TKE413IST1522482600000TKE418VKO1523717400000TKE9IST1523797200000TKE&itineraryId=9725bf24-803a-4838-bb4a-4374cde1a623&provider=Smartfares&deepLink=null");
    }
    @Test
    public void Booking_3() {

        //WestJet
        Booking ("https://www.onvoya.com/flights/booking?searchSessionId=2b1c3b03-f693-429e-8b46-0203e24392fc&itineraryKey=0557YKF1534917600000WSE1508YYC1534931700000WSE&itineraryId=30edd89d-36fc-4f9b-840c-8e22f2ad8fc1&provider=WestJet&deepLink=null");
    }

    @Test
    public void Booking_4(){
        //Cheapoair
        Booking ("https://www.onvoya.com/flights/booking?searchSessionId=3a8163be-64af-4eb5-86cd-4577f4538fae&itineraryKey=104JFK1537204500000EIE8472DUB1537260300000EIE&itineraryId=d8514549-5a12-4013-8ffd-385a1431c729&provider=Cheapoair&deepLink=null");


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
