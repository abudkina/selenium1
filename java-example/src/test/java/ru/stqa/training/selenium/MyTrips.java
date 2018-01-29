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

public class MyTrips {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 10);
    }

    @Test
    public void myFirstTest(){
        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.xpath("//*[@id=\"banner\"]/div/div[3]/ul/li[1]/span")).click();
        driver.findElement(By.id("_58_login")).sendKeys("a.budkina@onvoya.com");
        driver.findElement(By.id("_58_password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\'yui_patched_v3_11_0_1_1517218687959_193\']/button")).click();
       // driver.findElement(By.xpath("//*[@id=\'yui_patched_v3_11_0_1_1517216709898_489\']")).click();
        driver.findElement(By.xpath("//*[@id=\"my-account\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"account-preferences\"]/a")).click();
        wait.until(titleIs("Account - OnVoya"));
    }


    @After

    public void stop () {
        driver.quit();
        driver = null;
    }

}
