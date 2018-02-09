package OnVoya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class Flexible {

    public WebDriver driver;
    public WebDriverWait wait;

    @Test (priority =1)
    public void FlexibleDates_OneWay () {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.navigate().to("https://www.onvoya.com/flights/search?From=NYC&To=DEL&Class=E&Departure=2018-03-04&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 30);


        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));


        driver.findElement(By.xpath("//*[@id=\"fareFlexible\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"departure-tb\"]/tr/td[4]/span")).click();

        WebElement a = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div"));
        wait.until(invisibilityOf(a));

        WebElement new2 = driver.findElement(By.id("searchBanner"));

            wait.until(invisibilityOf(new2));

        try {

        String FareStreet1 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
        String FareStreet2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[5]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
        String FareStreet3 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[10]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();

        if ((FareStreet1.equals(FareStreet2)) && (FareStreet2.equals(FareStreet3)))

        {System.out.println("********************************");
            System.out.println("Flexible dates is working");
            Assert.assertEquals("Search, Find, Book and Save on Flights - OnVoya", driver.getTitle());
        }
        }

        catch (Exception e) {

            System.out.println("********************************");
            System.out.println("Flexible dates is  not working");
            Assert.assertEquals("111", driver.getTitle());
             }
    }

    @Test (priority =2)
    public void MonthlyCalendar_OneWay () {

        driver.navigate().to("https://www.onvoya.com/flights/search?From=NYC&To=DEL&Class=E&Departure=2018-03-04&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 120);


        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));

        driver.findElement(By.xpath("//*[@id=\"fareMonthlyView\"]/div/div[1]/ul/li[4]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"fareMonthlyView\"]/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td[4]")).click();

        WebElement a = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div"));
        wait.until(invisibilityOf(a));

        WebElement new2 = driver.findElement(By.id("searchBanner"));

        wait.until(invisibilityOf(new2));

        try {

            String FareStreet1 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
            String FareStreet2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[5]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
            String FareStreet3 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[10]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();

            if ((FareStreet1.equals(FareStreet2)) && (FareStreet2.equals(FareStreet3)))

            {System.out.println("********************************");
                System.out.println("Flexible dates is working");
                Assert.assertEquals("Search, Find, Book and Save on Flights - OnVoya", driver.getTitle());
            }
        }

        catch (Exception e) {

            System.out.println("********************************");
            System.out.println("Flexible dates is  not working");
            Assert.assertEquals("111", driver.getTitle());
        }

//        driver.quit();
//        driver = null;

    }

    @Test (priority =3)
    public void FlexibleDates_RoundWay () {

//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 5);
        driver.navigate().to("https://www.onvoya.com/flights/search?From=NYC&To=DEL&Class=E&Departure=2018-03-04&Return=2018-03-08&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 120);


        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));


        driver.findElement(By.xpath("//*[@id=\"fareFlexible\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"departure-tb\"]/tr[4]/td[4]/span")).click();

        WebElement a = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div"));
        wait.until(invisibilityOf(a));

        WebElement new2 = driver.findElement(By.id("searchBanner"));

        wait.until(invisibilityOf(new2));

        try {

            String FareStreet1 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
            String FareStreet2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[5]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
            String FareStreet3 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[10]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();

            if ((FareStreet1.equals(FareStreet2)) && (FareStreet2.equals(FareStreet3)))

            {System.out.println("********************************");
                System.out.println("Flexible dates is working");
                Assert.assertEquals("Search, Find, Book and Save on Flights - OnVoya", driver.getTitle());
            }
        }

        catch (Exception e) {

            System.out.println("********************************");
            System.out.println("Flexible dates is  not working");
            Assert.assertEquals("111", driver.getTitle());
        }
    }

    @Test (priority =4)
    public void MonthlyCalendar_RoundWay () {

        driver.navigate().to("https://www.onvoya.com/flights/search?From=NYC&To=DEL&Class=E&Departure=2018-03-04&Return=2018-03-08&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 120);


        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));

        driver.findElement(By.xpath("//*[@id=\"fareMonthlyView\"]/div/div[1]/ul/li[4]/span")).click();

        WebElement b = driver.findElement(By.xpath("//*[@id=\"fareMonthlyView\"]/div/div[2]/div[2]/div[2]/table/tbody/tr[3]/td[4]"));
        b.click();
        wait.until(invisibilityOf(b));
        driver.findElement(By.xpath("//*[@id=\"fareMonthlyView\"]/div/div[2]/div[3]/div[2]/table/tbody/tr[2]/td[4]")).click();

        WebElement a = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div"));
        wait.until(invisibilityOf(a));

        WebElement new2 = driver.findElement(By.id("searchBanner"));

        wait.until(invisibilityOf(new2));

        try {

            String FareStreet1 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
            String FareStreet2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[5]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();
            String FareStreet3 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[10]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();

            if ((FareStreet1.equals(FareStreet2)) && (FareStreet2.equals(FareStreet3)))

            {System.out.println("********************************");
                System.out.println("Flexible dates is working");
                Assert.assertEquals("Search, Find, Book and Save on Flights - OnVoya", driver.getTitle());
            }
        }

        catch (Exception e) {

            System.out.println("********************************");
            System.out.println("Flexible dates is  not working");
            Assert.assertEquals("111", driver.getTitle());
        }

        driver.quit();
        driver = null;

    }

    }
