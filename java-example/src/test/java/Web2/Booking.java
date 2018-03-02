package Web2;

//import com.sun.tools.internal.xjc.Driver;

import com.beust.jcommander.Parameters;
import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//import static org.openqa.selenium.support.ui.ExpectedConditions.

public class Booking {

    private boolean booking;
    private int i;
    String parentHandle;
    String provider;
    public WebDriver driver;
    public WebDriverWait wait;


    @Test
    public void Cheapoair(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        driver.navigate().to("http://web2.onvoya.com/flights/search?From=DEL&To=NYC&Class=E&Departure=2018-03-20&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);

        Fares ("Cheapoair");

 }

    @Test
    public void SmartFares() {


        Fares ("Smartfares");

        driver.quit();
        driver = null;
}

    @Test
    public void FareDepot(){

        Fares ("Faredepot"); }

    @Test
    public void FareLogix(){

        driver.navigate().to("http://web2.onvoya.com/flights/search?From=YTO&To=NYC&Class=E&Departure=2018-03-08&Adult=1&Ref=WF1");
        Fares ("WestJet");
        driver.quit();
        driver = null;}

    @Test
    public void FareStreet (){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        driver.navigate().to("http://web2.onvoya.com/flights/search?From=NYC&To=LON&Class=E&Departure=2018-03-04&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);

        Fares ("FareStreet");

}

    @Test
    public void Kiwi (){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        driver.navigate().to("http://web2.onvoya.com/flights/search?From=NYC&To=LON&Class=E&Departure=2018-03-04&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 30);

        Fares_Redirect ("Kiwi");}

    @Test
    public void Opodo (){

        Fares_Redirect ("Opodo");}

    @Test
    public void Expedia (){

        Fares_Redirect ("Expedia");

    }

    @Test
    public void American_Airlines (){

        driver.navigate().to("http://web2.onvoya.com/flights/search?From=LAX&To=LAS&Class=E&Departure=2018-03-04&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 30);

        Fares_Redirect ("American Airlines");}

   @Test
    public void eDreams (){

        Fares_Redirect ("eDreams");
        driver.quit();
        driver = null;
    }


    public void Fares (String Provider) {

        //дожидаемся когда пропадет лоадер

        try {

            WebElement new1 = driver.findElement(By.id("resultMask"));
            wait.until(invisibilityOf(new1));
        }

        catch (Exception e) { }

        //задаем значение букинга = есть/нет

        booking = false;

        parentHandle = driver.getWindowHandle(); // Save parent window

        // ищем среди первых 125 fares нужного провайдера

        driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();

        for (i = 1; i < 126; i++) {

            String provider_text = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();

            try {

                WebElement new1 = driver.findElement(By.id("resultMask"));
                wait.until(invisibilityOf(new1));}

            catch (Exception e) {}
          // если есть, то открываем букинг страницу

            if (provider_text.equals(Provider)) {
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();
                fillingOut();

                // заканчиваем поиски провайдера

                break;
            }}

        // если провайдер не найден среди первых 126 полетов -  пишем, что нет fares для провайдера
           if (!booking) {

            System.out.println("*********************************************************");
            System.out.println("Not fares for "+ Provider);

    }}

    public void fillingOut() {

        //ждем загрузки страницы

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //переключаем действие на открытое окно

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

        //проверяем, что на букинг странице можно заполнить поля, иначе на ней написано "flight is not available"

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
               Assert.assertEquals("111", driver.getTitle());
           }

           driver.findElement(By.xpath("//*[@id=\"book-now-btn\"]")).click();

           String First_name = "e.g. John";
           String First_name_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[1]/div/div[2]/div/div[3]/div[1]/div/span")).getText();
           if (!First_name.equals(First_name_error)){System.out.println("Error");}

           String Last_name = "e.g. Smith";
           String Last_name_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[1]/div/div[2]/div/div[3]/div[3]/div/span")).getText();
           if (!Last_name.equals(Last_name_error)){System.out.println("Error");}

           String Birthday = "e.g. MM/DD/YYYY";
           String Birthday_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[1]/div/div[2]/div/div[4]/div[1]/div/span")).getText();
           if (!Birthday.equals(Birthday_error)){System.out.println("Error");}

           String Email = "e.g. email@email.com";
           String Email_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[2]/div/div[2]/div[1]/div[1]/div/span")).getText();
           if (!Email.equals(Email_error)){System.out.println("Error");}

           String Number = "e.g. +1 123 456 78 90";
           String Number_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[2]/div/div[2]/div[1]/div[2]/div/span")).getText();
           if (!Number.equals(Number_error)){System.out.println("Error");}

           String Billing_First_name_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[3]/div/div[2]/div[1]/div[1]/div/span")).getText();
           if (!First_name.equals(Billing_First_name_error)){System.out.println("Error");}

           String Billing_Last_name_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[3]/div/div[2]/div[1]/div[2]/div/span")).getText();
           if (!Last_name.equals(Billing_Last_name_error)){System.out.println("Error");}

           String Address = "e.g. 123 Main Street";
           String Address_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/span")).getText();
           if (!Address.equals(Address_error)){System.out.println("Error");}

           String City = "e.g. New York";
           String City_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[3]/div/div[2]/div[2]/div[2]/div/span")).getText();
           if (!City.equals(City_error)){System.out.println("Error");}

           String Zip = "e.g. 12345";
           String Zip_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[3]/div/div[2]/div[3]/div[3]/div/span")).getText();
           if (!Zip.equals(Zip_error)){System.out.println("Error");}

           String Card = "e.g. XXXX-XXXX-XXXX-XXXX";
           String Card_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[3]/div/div[2]/div[4]/div[1]/div/div/span")).getText();
           if (!Card.equals(Card_error)){System.out.println("Error");}

           String Expiration = "e.g. MM/YY";
           String Expiration_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[3]/div/div[2]/div[4]/div[2]/div/span")).getText();
           if (!Expiration.equals(Expiration_error)){System.out.println("Error");}

           String CVV = "e.g. 123";
           String CVV_error =  driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[3]/div/div[2]/div[4]/div[3]/div/span")).getText();
           if (!CVV.equals(CVV_error)){System.out.println("Error");}

           //заполняем поля на букинг странице

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

           //сохраняем название провайдера

           String provider_details = driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div")).getText();

           //детали открываются

           driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[2]/div[2]/div/div[2]")).click();
           System.out.println("Details are opened");
           driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]")).click();
           System.out.println("Details are closed");

           //buy

           driver.findElement(By.xpath("//*[@id=\"book-now-btn\"]")).click();

           wait = new WebDriverWait(driver, 10);

           //дожидаемся подтверждения бронирования, иначе полет недоступен

           try {

               WebElement confirmation = driver.findElement(By.xpath("//*[@id=\"portlet_booking_WAR_bookingportlet\"]/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]"));
               wait.until(visibilityOf(confirmation));
               String PNR = driver.findElement(By.xpath("//*[@id=\"portlet_booking_WAR_bookingportlet\"]/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/b")).getText();
               System.out.println("Booking successful " + " Provider: " + provider_details + " PNR: " + PNR);
               System.out.println("*********************************************************");
               System.out.println("SUCCESS");
               booking = true;
           } catch (Exception e) {
               System.out.println("Flight is not available " + provider_details);
               System.out.println("*********************************************************");
               booking = true;
               driver.close();
               driver.switchTo().window(parentHandle);
               Assert.assertEquals("111", driver.getTitle());
           }

           //переключаемся на предыдущее окно
//        driver.manage().window().maximize();
           driver.close();
           driver.switchTo().window(parentHandle);

        }

    public void Fares_Redirect (String Provider) {

        //дожидаемся загрузки результатов

        provider = Provider;
        try {

            WebElement new1 = driver.findElement(By.id("resultMask"));
            wait.until(invisibilityOf(new1));
        } catch (Exception e) {
        }

       parentHandle = driver.getWindowHandle(); // Save parent window

        //ищем среди первых 25 полетов нужный провайдер

        for (i = 1; i < 26; i++) {

            String provider_text = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
            if (provider_text.equals(provider)) {
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();
                redirect();
                break;
            }}

        if (booking==false) {


            WebElement button = driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button"));
            wait.until(visibilityOf(button));
            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
            for ( i = 26; i < 51; i++) {
                String provider_text = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
                if (provider_text.equals(provider)) {
                    driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();
                    redirect();
                    break;
                }
            }}

        if (booking==false) {

            WebElement button = driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button"));
            wait.until(visibilityOf(button));
            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
            for ( i = 51; i < 76; i++) {
                String provider_text = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
                if (provider_text.equals(provider)) {
                    driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();
                    redirect();
                    break;
                }
            }}

        if (booking==false) {

            WebElement button = driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button"));
            wait.until(visibilityOf(button));
            driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
            for ( i = 76; i < 101; i++) {
                String provider_text = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
                if (provider_text.equals(provider)) {
                    driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();
                    redirect();
                    break;
                }
            }}

        if (booking==false) {

            System.out.println("*********************************************************");
            System.out.println("Not fares for "+ provider);
        }}

    public void redirect () {

        //переключаемся на открытую страницу

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

         //проверяем, что url станицы соответствует провайдеру

         String URL = driver.getCurrentUrl();
         String providerName = provider.toLowerCase();
         if (provider == "American Airlines") {providerName = "aa";}
         boolean isContain = URL.contains(providerName);

         //если перешли на нужную страницу провайдера

         if (isContain==true) { System.out.println("*********************************");
             System.out.println("Redirect is successful for "+ provider);
         booking = true;}

         //если страница не открылась

         else {System.out.println("*********************************");
             System.out.println("NOT SUCCESS FOR "+ provider);}

         driver.close();
         driver.switchTo().window(parentHandle);
     }

}
