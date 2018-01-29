package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;


public class Links {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 5);
    }


    @Test
    public void Link(){
        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[1]/a")).click();
        wait.until(titleIs("About - OnVoya"));
        System.out.println("--- About Us - works --- ");
        driver.navigate().to("http://www.onvoya.com/");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[2]/a")).click();
        wait.until(titleIs("Team - OnVoya"));
        System.out.println("--- Team - works --- ");
        driver.navigate().to("http://www.onvoya.com/");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[4]/a")).click();
        wait.until(titleIs("Contact Us - OnVoya"));
        System.out.println("--- Contact Us - works --- ");
        driver.navigate().to("http://www.onvoya.com/");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[3]/a")).click();
        wait.until(titleIs("OnVoya Help Desk"));
        System.out.println("--- FAQ - works --- ");
        driver.navigate().to("http://www.onvoya.com/");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[2]/div/span[2]/a")).click();
        wait.until(titleIs("Privacy - OnVoya"));
        System.out.println("--- Privacy - works --- ");
        driver.navigate().to("http://www.onvoya.com/");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[2]/div/span[3]/a")).click();
        wait.until(titleIs("Terms - OnVoya"));
        System.out.println("--- Terms - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // paris
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/a/span")).click();
        wait.until(urlContains("https://www.onvoya.com/paris/"));
        System.out.println("--- Paris (picture) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // beijing
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[2]/a/span")).click();
        wait.until(urlContains("https://www.onvoya.com/beijing/"));
        System.out.println("--- Beijing (picture) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // seoul
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/a/span/span[1]")).click();
        wait.until(urlContains("https://www.onvoya.com/seoul/"));
        System.out.println("--- Seoul (picture) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // bangkok
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[3]/a/span")).click();
        wait.until(urlContains("https://www.onvoya.com/bangkok/"));
        System.out.println("--- Bangkok (picture) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // rome
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[2]/a/span")).click();
        wait.until(urlContains("https://www.onvoya.com/rome/"));
        System.out.println("--- Rome (picture) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // london
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[3]/a/span/span[1]")).click();
        wait.until(urlContains("https://www.onvoya.com/london/"));
        System.out.println("--- London (picture) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // barcelona
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[4]/a/span")).click();
        wait.until(urlContains("https://www.onvoya.com/barcelona/"));
        System.out.println("--- Barcelona (picture) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // new-york
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[1]")).click();
        wait.until(urlContains("https://www.onvoya.com/new-york/"));
        System.out.println("--- New - York (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // los-angeles
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[2]")).click();
        wait.until(urlContains("https://www.onvoya.com/los-angeles/"));
        System.out.println("--- Los-Angeles (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // san-francisco
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[3]")).click();
        wait.until(urlContains("https://www.onvoya.com/san-francisco/"));
        System.out.println("--- San-Francisco (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // crete
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[4]")).click();
        wait.until(urlContains("https://www.onvoya.com/crete/"));
        System.out.println("--- Crete (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // london
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[5]")).click();
        wait.until(urlContains("https://www.onvoya.com/london/"));
        System.out.println("--- London (search) - works --- ");
       // driver.navigate().to("http://www.onvoya.com/"); // rome
      //  driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[6]")).click();
       // wait.until(urlContains("https://www.onvoya.com/rome/"));
       // System.out.println("--- Rome (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // seoul
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[7]")).click();
        wait.until(urlContains("https://www.onvoya.com/seoul/"));
        System.out.println("--- Seoul (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // barcelona
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[1]")).click();
        wait.until(urlContains("https://www.onvoya.com/barcelona/"));
        System.out.println("--- Barcelona (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // bangkok
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[2]")).click();
        wait.until(urlContains("https://www.onvoya.com/bangkok/"));
        System.out.println("--- Bangkok (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // bali
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[3]")).click();
        wait.until(urlContains("https://www.onvoya.com/bali/"));
        System.out.println("--- Bali (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // dubai
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[4]")).click();
        wait.until(urlContains("https://www.onvoya.com/dubai/"));
        System.out.println("--- Dubai (search) - works --- ");
      //  driver.navigate().to("http://www.onvoya.com/"); // paris
       // driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[5]")).click();
       // wait.until(urlContains("https://www.onvoya.com/paris/"));
        // System.out.println("--- Paris (search) - works --- ");
        driver.navigate().to("http://www.onvoya.com/"); // beijing
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[6]")).click();
        wait.until(urlContains("https://www.onvoya.com/beijing/"));
        System.out.println("--- Beijing (search) - works --- ");
    }

    @After

    public void stop () {
        driver.quit();
        driver = null;
    }

}
