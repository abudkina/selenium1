package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        //driver = new InternetExplorerDriver();
       // driver = new FirefoxDriver();
       driver = new ChromeDriver();
        wait = new WebDriverWait (driver, 10);
}

@Test
    public void myFirstTest() throws InterruptedException {
        driver.get ("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("gfghfhtsfhsfh");
        driver.findElement(By.name("btnK")).click();
        wait.until(titleIs("gfghfhtsfhsfh - Поиск в Google"));
}

@After

    public void stop () {
        driver.quit();
        driver = null;
}
}
