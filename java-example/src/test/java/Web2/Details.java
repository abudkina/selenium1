package Web2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Details {

    public WebDriver driver;
    public WebDriverWait wait;
    public String from;
    public String to;
    String airportD ;
    String airportA ;

    String cityD ;
    String cityA ;

    @Test
    public void detailsFaresOneWay () {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        airportD = "JFK";
        airportA = "DEL";

        cityD = "New York";
        cityA = "Delhi";

        driver.navigate().to("http://web2.onvoya.com/flights/search?From="+airportD+"&To="+airportA+"&Class=E&Departure=2018-08-04&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);

        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));

        compareFromToOneWay();
        }

     @Test
     public void detailsFaresRound () {

            driver.navigate().to("http://web2.onvoya.com/flights/search?From="+airportD+"&To="+airportA+"&Class=E&Departure=2018-08-04&Return=2018-08-08&Adult=1&Ref=WF1");
            wait = new WebDriverWait(driver, 90);
            WebElement new2 = driver.findElement(By.id("resultMask"));
            wait.until(invisibilityOf(new2));

            compareFromToRoundWay();
    }

    public void compareFromToOneWay () {

        for (int i=1;i<21;i++){

            String departure = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[1]/div[1]/div[1]/div/div/div[1]/div[2]/div[2]")).getText();

            String arrive = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[1]/div[1]/div[1]/div/div/div[1]/div[4]/div[2]")).getText();

            driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[1]/div[2]/div/div[1]/a")).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String cities = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[2]/div[1]/div/div[1]/span[1]")).getText();

            String date = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[2]/div[1]/div/div[1]/span[2]")).getText();

            if ((!departure.contains(airportD)) || (!arrive.contains(airportA)) || (!cities.contains(cityD)) || (!cities.contains(cityA)) || (!date.contains("04 Aug")))

            {System.out.println("Error");}
        }

    }

    public void compareFromToRoundWay () {

        for (int i=1;i<26;i++){

            String departure = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[1]/div[1]/div[1]/div/div/div[1]/div[2]/div[2]")).getText();

            String arrive = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[1]/div[1]/div[1]/div/div/div[1]/div[4]/div[2]")).getText();

            String departure_2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/div[2]/div[2]")).getText();

            String arrive_2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/div[4]/div[2]")).getText();

            driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[1]/div[2]/div/div[1]/a")).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String cities = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[2]/div[1]/div/div[1]/span[1]")).getText();

            String date = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[2]/div[1]/div/div[1]/span[2]")).getText();

            String cities_2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div[2]/div[1]/div/div[5]/span[1]")).getText();

            String date_2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div[2]/div[1]/div/div[5]/span[2]")).getText();

            if ((!departure.contains(airportD)) || (!arrive.contains(airportA)) || (!departure_2.contains(airportA)) || (!arrive_2.contains(airportD)) || (!cities.contains(cityD)) || (!cities_2.contains(cityD)) || (!cities.contains(cityA)) || (!cities_2.contains(cityA))|| (!date.contains("04 Aug")) || (!date_2.contains("08 Aug")))

            {System.out.println("Error");}
        }

    }

    }

