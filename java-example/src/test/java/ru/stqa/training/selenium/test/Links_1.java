package ru.stqa.training.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class Links_1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 5);
    }


    @Test
    public void Links(){
        driver.navigate().to("http://www.web2.onvoya.com.com/"); // rome
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[6]")).click();
        wait.until(urlContains("https://www.web2.onvoya.com.com/rome/"));
    }


    @After

    public void stop () {
        driver.quit();
        driver = null;
    }

}
