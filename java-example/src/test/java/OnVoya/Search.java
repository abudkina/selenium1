package OnVoya;
/**
 * Created by budki on 31.01.2018.
 */

import  org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeSelected;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Search {

    public WebDriver driver;
    public WebDriverWait wait;

      @Test (priority  = 1)
    public void TestRound1()  {

          driver = new ChromeDriver();
          wait = new WebDriverWait(driver, 5);

        SearchBest("JFK","LGW");
    }

    @Test (priority  = 2)
    public void TestRound2()  {

        SearchAll("SFO","DEL");
    }

    @Test (priority  = 3)
    public void TestRound3()  {

        SearchBest("DXB","LAX");
    }

    @Test (priority  = 4)
    public void TestRound4()  {

        SearchAll("DME","IST");
    }


    @Test (priority  = 5)
    public void TestOne1()  {

        SearchBestOne("JFK","LGW"); }

    @Test (priority  = 6)
    public void TestOne2()  {
        SearchAllOne("BGC", "BCN");}

    @Test (priority  = 7)
    public void TestOne3()  {
        SearchBestOne("POI","DUB");}

    @Test (priority  = 8)
    public void TestOne4()  {

        SearchAllOne("NUR", "VRN");

        driver.quit();
        driver = null;
    }


    //@Test
    public void TestMulti()  {

        SearchBestMulti("JFK","BOS", "DEL", "SFO");
    }


    public void SearchBest(String from, String to) {

        driver.navigate().to ("http://www.onvoya.com/");
        //driver.findElement(By.name("from")).clear();
        //driver.findElement(By.name("to")).clear();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();
        System.out.println("Round - BEST " + from + " - " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    public void SearchAll(String from, String to) {

        driver.navigate().to ("http://www.onvoya.com/");
        //driver.findElement(By.name("from")).clear();
        //driver.findElement(By.name("to")).clear();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[1]")).click();
        System.out.println("Round - ALL " + from + " - " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    public void SearchBestOne(String from, String to){

        driver.navigate().to ("http://www.onvoya.com/");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[1]/div[1]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(" "); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(" "); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();
        System.out.println("OneWay - BEST " + from + " - " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));}

    public void SearchAllOne(String from, String to) {

        driver.navigate().to ("http://www.onvoya.com/");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[1]/div[1]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(" "); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(" "); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[1]")).click();
        System.out.println("OneWay - ALL " + from + " - " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    public void SearchBestMulti(String from, String to, String from2, String to2) {

        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.name("from")).clear();
        driver.findElement(By.name("to")).clear();
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[1]/div[1]/div[3]/a")).click(); //multi
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение
//        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/input")).sendKeys(" ");
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"add-more-leg\"]/div")));
        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[1]/div/input")).click(); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[1]/div/input")).sendKeys(from2); // находит по элементу поле и вставляет значение
        WebElement click = driver.findElement(By.xpath("//*[@id=\"searchSelected\"]"));
//        click.click();
        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[1]/div/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[3]/div/input")).sendKeys(to2); // находит по элементу поле и вставляет значение
       // wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));
//        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[3]/div/input")).sendKeys(" ");

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();

        System.out.println("Search Multi Best " + from + " - " + to + " - " + from2 + " - " + to2);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

}