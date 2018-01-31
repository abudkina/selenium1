package ru.stqa.training.selenium;
/**
 * Created by budki on 31.01.2018.
 */

import  org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Search {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 30);
    }

     @Test
    public void Test1()  {

          SearchBest("jfk","lgw");
          SearchAll("sfo","del");
    }

   //@Test
    public void Test2()  {

        SearchBest("las","lax");
    }

    @Test
    public void Test3()  {

        SearchBestOne("jfk","lgw");
        SearchAllOne("bcn", "par");
    }

    @Test
    public void Test4()  {

        SearchBestMulti("jfk","was", "las", "lax" );
    }

    @After

    public void stop () {
        driver.quit();
        driver = null;
    }

    public void SearchBest(String from, String to) {

        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.name("from")).clear();
        driver.findElement(By.name("to")).clear();
        driver.findElement(By.name("from")).sendKeys(from); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.name("to")).sendKeys(to); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();
        System.out.println("Search - Round - Best" + from + " " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    public void SearchAll(String from, String to) {

        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.name("from")).clear();
        driver.findElement(By.name("to")).clear();
        driver.findElement(By.name("from")).sendKeys(from); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.name("to")).sendKeys(to); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[1]")).click();
        System.out.println("Search - Round - All" + from + " " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    public void SearchBestOne(String from, String to){

        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.name("from")).clear();
        driver.findElement(By.name("to")).clear();
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[1]/div[1]/div[2]/a")).click();
        driver.findElement(By.name("from")).sendKeys(from); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.name("to")).sendKeys(to); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();
        System.out.println("Search - OneWay - Best" + from + " " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));}

    public void SearchAllOne(String from, String to) {

        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.name("from")).clear();
        driver.findElement(By.name("to")).clear();
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[1]/div[1]/div[2]/a")).click();
        driver.findElement(By.name("from")).sendKeys(from); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.name("to")).sendKeys(to); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[1]")).click();
        System.out.println("Search - OneWay - All" + from + " " + to);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

}

    public void SearchBestMulti(String from, String to, String from2, String to2) {

        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.name("from")).clear();
        driver.findElement(By.name("to")).clear();
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[1]/div[1]/div[3]/a")).click(); //multi
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/input")).sendKeys(from); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/input")).sendKeys(to); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[1]/div/input")).sendKeys(from2); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[1]/div/input")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[3]/div/input")).sendKeys(to2); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[3]/div/input")).sendKeys(" ");

        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();

        System.out.println("Search Multi Best " + from + " " + to + " " + from2 + " " + to2);
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

}
