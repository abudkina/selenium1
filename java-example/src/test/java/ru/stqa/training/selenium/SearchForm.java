package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class SearchForm {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       wait = new WebDriverWait (driver, 30);
    }

    @Test
    public void myFirstTest(){
        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.name("from")).sendKeys("jfk"); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.name("to")).sendKeys("lgw"); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));
    }


    @After

    public void stop () {
        driver.quit();
        driver = null;
    }

}
