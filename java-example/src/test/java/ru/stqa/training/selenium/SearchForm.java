package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class SearchForm {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait (driver, 3);
    }

    @Test
    public void myFirstTest(){
        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.name("from")).sendKeys("New York (NYC)"); // находит по элементу поле и вставляет значение
        driver.findElement(By.className("search-input autocomplete")).click();
        //driver.findElement(By.className("//*[@id=\'searchSelected\']v")).click();
        driver.findElement(By.name("to")).sendKeys("London (LON)"); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\'searchSelected\']v")).click();
        driver.findElement(By.xpath("//*[@id='flight-search-form']/div[1]/div[2]/div[2]/div[1]/div[1]")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));

    }


    @After

    public void stop () {
        driver.quit();
        driver = null;
    }

}
