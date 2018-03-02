package Web2;
/**
 * Created by budki on 31.01.2018.
 */

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;



public class Search {

    public WebDriver driver;
    public WebDriverWait wait;

      @Test (priority  = 1)
    public void TestRound1()  {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        Calendar_Class_Homepage();
        SearchBest("NYC","LON");
    }

    @Test (priority  = 2)
    public void TestRound2()  {

        SearchAll("VRN","MOW");
    }

    @Test (priority  = 3)
    public void TestRound3()  {

        SearchBest("DEL","PAR");
    }

    @Test (priority  = 4)
    public void TestRound4()  {


        SearchAll("SFO","CHI");
    }


    @Test (priority  = 5)
    public void TestOne1()  {

        SearchBestOne("IST","BJS");
}

    @Test (priority  = 6)
    public void TestOne2()  {

        SearchAllOne("BCN", "TYO"); }

    @Test (priority  = 7)
    public void TestOne3()  {

        SearchBestOne("NUR","YMQ"); }

    @Test (priority  = 8)
    public void TestOne4()  {


        SearchAllOne("BGC", "YTO");
        driver.quit();
        driver = null;
    }

    @Test(priority  = 9)
    public void Test_Multi()  {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        Multicity_Search();
        driver.quit();
        driver = null;
    }


    public void SearchBest(String from, String to) {

          //переходим на страницу

        driver.navigate().to ("http://web2.onvoya.com/");

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).clear();

        driver.findElement(By.xpath("//*[@id=\"traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"traveler\"]")).click();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        //заполняем поля from и to

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(elementToBeClickable(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/div/div/div[2]")));
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/div/div/div[2]")).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[1]/div[2]/table[2]/tbody/tr[2]/td[3]/div/span")).click();

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[2]/div[2]/table[2]/tbody/tr[2]/td[3]/div/span")).click();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //нажимаем на show best

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();
        System.out.println("Round - BEST " + from + " - " + to);
        //дожидаемся title страницы
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    public void SearchAll(String from, String to) {

        driver.navigate().to ("http://web2.onvoya.com/");

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).clear();

        driver.findElement(By.xpath("//*[@id=\"traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"traveler\"]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //заполняем поля from и to

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(elementToBeClickable(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/div/div/div[2]")));
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/div/div/div[2]")).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[1]/div[2]/table[2]/tbody/tr[2]/td[3]/div/span")).click();

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[2]/div[2]/table[2]/tbody/tr[2]/td[3]/div/span")).click();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //нажимаем на show all

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[1]")).click();
        System.out.println("Round - ALL " + from + " - " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    public void SearchBestOne(String from, String to){

        driver.navigate().to ("http://web2.onvoya.com/");

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[1]/div[1]/div[2]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).clear();

        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //заполняем поля from и to

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(elementToBeClickable(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/div/div/div[2]")));
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/div/div/div[2]")).click();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();

        //нажимаем на show best

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();
        System.out.println("OneWay - BEST " + from + " - " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));}

    public void SearchAllOne(String from, String to) {

        driver.navigate().to ("http://web2.onvoya.com/");

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[1]/div[1]/div[2]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).clear();

        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //заполняем поля from и to

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(elementToBeClickable(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/div/div/div[2]")));
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/div/div/div[2]")).click();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();

        //нажимаем на show all

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[1]")).click();
        System.out.println("OneWay - ALL " + from + " - " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    public void Calendar_Class_Homepage(){

        driver.navigate().to("http://web2.onvoya.com/flights/");

        driver.findElement(By.xpath("//*[@id=\"departDate\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[1]/div[2]/table[2]/tbody/tr[3]/td[4]/div/span")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[2]/div[2]/table[2]/tbody/tr[3]/td[6]/div/span")).click();

        driver.findElement(By.xpath("//*[@id=\"traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[3]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[4]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[5]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[6]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"traveler\"]")).click();
    }

    public void Multicity_Search () {


        driver.navigate().to("http://web2.onvoya.com/flights/");

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[1]/div[1]/div[3]/a")).click(); //multi

        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/input")).clear();

        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/input")).sendKeys("NYC"); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement a = driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/div/div/div[3]"));
        a.click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/input")).sendKeys("BOS"); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement b = driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/div/div/div[2]"));
        wait.until(elementToBeClickable(b));
        b.click();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[3]/div[2]/table[2]/tbody/tr[2]/td[3]/div/span")).click();

        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

//ВТОРОЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[1]/div/input")).click();

        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[3]/div/input")).sendKeys("MOW");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement c = driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[3]/div/div/div/div[2]"));
        wait.until(elementToBeClickable(c));
        c.click();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[4]/div[2]/table[2]/tbody/tr[2]/td[3]/div/span")).click();

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

//ТРЕТИЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-3\"]/div[1]/div[1]/div/input")).click();


        driver.findElement(By.xpath("//*[@id=\"row-3\"]/div[1]/div[3]/div/input")).sendKeys("LON");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement d = driver.findElement(By.xpath("//*[@id=\"row-3\"]/div[1]/div[3]/div/div/div/div[3]"));
        wait.until(elementToBeClickable(d));
        d.click();

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[5]/div[2]/table[1]/tbody/tr[4]/td[4]/div/span")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

//ЧЕТВЕРТЫЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-4\"]/div[1]/div[1]/div/input")).click();

        driver.findElement(By.xpath("//*[@id=\"row-4\"]/div[1]/div[3]/div/input")).sendKeys("PAR");

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement f = driver.findElement(By.xpath("//*[@id=\"row-4\"]/div[1]/div[3]/div/div/div/div[2]"));
        wait.until(elementToBeClickable(f));
        f.click();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[6]/div[2]/table[1]/tbody/tr[5]/td[4]/div/span")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();


        //ПЯТЫЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-5\"]/div[1]/div[1]/div/input")).click();

        driver.findElement(By.xpath("//*[@id=\"row-5\"]/div[1]/div[3]/div/input")).sendKeys("CHI");

        try {
            Thread.sleep(2700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement g = driver.findElement(By.xpath("//*[@id=\"row-5\"]/div[1]/div[3]/div/div/div/div[2]"));
        wait.until(elementToBeClickable(g));
        g.click();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[7]/div[2]/table[2]/tbody/tr[3]/td[3]/div/span")).click();

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

        //ШЕСТОЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-6\"]/div[1]/div[1]/div/input")).click();

        driver.findElement(By.xpath("//*[@id=\"row-6\"]/div[1]/div[3]/div/input")).sendKeys("TOR");

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement t = driver.findElement(By.xpath("//*[@id=\"row-6\"]/div[1]/div[3]/div/div/div/div[2]"));
        wait.until(elementToBeClickable(t));
        t.click();

        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[8]/div[2]/table[2]/tbody/tr[1]/td[3]/div/span")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"multicity-traveler\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[3]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[4]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[4]")).click();

        driver.findElement(By.xpath("//*[@id=\"multicity-traveler\"]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[1]")).click();
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

}