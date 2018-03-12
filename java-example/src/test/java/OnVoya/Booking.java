package OnVoya;

//import com.sun.tools.internal.xjc.Driver;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
//import static org.openqa.selenium.support.ui.ExpectedConditions.
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


    public class Booking {

        private boolean booking;
        private int i;
        String parentHandle;
        String provider;
        public WebDriver driver;
        public WebDriverWait wait;
        public String data = "2018-03-30";


        @Test
        public void Cheapoair(){

            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 5);

            driver.navigate().to("https://www.onvoya.com/flights/search?From=DEL&To=NYC&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
            wait = new WebDriverWait(driver, 90);

            Fares ("Cheapoair"); }

    @Test
    public void SmartFares() {

        driver.navigate().to("https://www.onvoya.com/flights/search?From=DEL&To=NYC&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);
        Fares ("Smartfares");
        driver.quit();
        driver = null;}


        @Test
        public void FareDepot(){

            driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
            wait = new WebDriverWait(driver, 90);
            Fares ("Faredepot"); }

        @Test
        public void FareLogix(){

            driver.navigate().to("https://www.onvoya.com/flights/search?From=YTO&To=NYC&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
            wait = new WebDriverWait(driver, 90);

            Fares ("WestJet");
            driver.quit();
            driver = null;}


        @Test
        public void FareStreet (){

            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 5);
            driver.navigate().to("https://www.onvoya.com/flights/search?From=NYC&To=LON&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
            wait = new WebDriverWait(driver, 90);

            Fares ("FareStreet");
        }

    @Test
    public void Kiwi (){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        driver.navigate().to("https://www.onvoya.com/flights/search?From=NYC&To=LON&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);

        Fares_Redirect ("Kiwi");}

    @Test
    public void Opodo (){

        driver.navigate().to("https://www.onvoya.com/flights/search?From=NYC&To=LON&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);
        Fares_Redirect ("Opodo");}

    @Test
    public void Expedia (){

        driver.navigate().to("https://www.onvoya.com/flights/search?From=NYC&To=LON&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);
        Fares_Redirect ("Expedia");
        driver.quit();
        driver = null;

    }

    @Test
    public void American_Airlines (){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=LAS&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);

        Fares_Redirect ("American Airlines");}

    @Test
    public void eDreams (){

        driver.navigate().to("https://www.onvoya.com/flights/search?From=DEL&To=NYC&Class=E&Departure="+data+"&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);
        Fares_Redirect ("eDreams");

    }


        public void Fares (String Provider) {

            try {

                WebElement new1 = driver.findElement(By.id("resultMask"));
                wait.until(invisibilityOf(new1));
            }

            catch (Exception e) { }

            booking = false;
            parentHandle = driver.getWindowHandle(); // Save parent window

            // ищем среди первых 125 fares нужного провайдера

            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();

            for (i = 1; i < 126; i++) {

                String provider_text = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
                if (provider_text.equals(Provider)) {
                    driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();
                    fillingOut();
                    break;
                }}

            if (!booking) {

                System.out.println("*********************************************************");
                System.out.println("Not fares for "+ Provider);
                booking = true;
                Assert.assertEquals("Error - not fares", driver.getTitle());

            }}

        public void fillingOut() {

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

            wait = new WebDriverWait(driver, 5);

            try {

                WebElement BookNow = driver.findElement(By.xpath("//*[@id=\"book-now-btn\"]"));
                wait.until(visibilityOf(BookNow));
            }

            catch (Exception e) {

                System.out.println("Booking page is not opened");
                System.out.println("*********************************************************");
                booking = true;
                driver.close();
                driver.switchTo().window(parentHandle);
                Assert.assertEquals("Error - Booking page is not opened", driver.getTitle());
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

            wait = new WebDriverWait(driver, 10);

            try {

                WebElement confirmation = driver.findElement(By.xpath("//*[@id=\"portlet_booking_WAR_bookingportlet\"]/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]"));
                wait.until(visibilityOf(confirmation));
                String PNR = driver.findElement(By.xpath("//*[@id=\"portlet_booking_WAR_bookingportlet\"]/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/b")).getText();
                System.out.println("Booking successful " + " Provider: " + provider_details + " PNR: " + PNR);
                System.out.println("*********************************************************");
                System.out.println("SUCCESS");
                booking = true;
            } catch (Exception e) {
                System.out.println("Flight is not available "+ provider_details);
                System.out.println("*********************************************************");
                booking = true;
                Assert.assertEquals("Error - Flight is not available", driver.getTitle());
            }

//        driver.manage().window().maximize();
            driver.close();
            driver.switchTo().window(parentHandle);

        }

        public void Fares_Redirect (String Provider) {

            provider = Provider;
            try {

                WebElement new1 = driver.findElement(By.id("resultMask"));
                wait.until(invisibilityOf(new1));
            } catch (Exception e) {
            }

            parentHandle = driver.getWindowHandle(); // Save parent window

            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();

            for (i = 1; i < 126; i++) {

                String provider_text = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
                if (provider_text.equals(provider)) {
                    driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();
                    redirect();
                    break;
                }}



            if (booking==false) {

                System.out.println("*********************************************************");
                System.out.println("Not fares for "+ provider);
            }}

        public void redirect () {

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

            String URL = driver.getCurrentUrl();
            String providerName = provider.toLowerCase();
            if (provider == "American Airlines") {providerName = "aa";}
            boolean isContain = URL.contains(providerName);
            if (isContain==true) { System.out.println("*********************************");
                System.out.println("Redirect is successful for "+ provider);
                booking = true;}
            if (isContain==false) {System.out.println("*********************************");
                System.out.println("NOT SUCCESS FOR "+ provider);}

            driver.close();
            driver.switchTo().window(parentHandle);
        }

    }




