package ru.stqa.training.selenium.Final_web2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;


public class Links extends Final{


    @Test
    public void Link (){
        driver.get ("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[1]/a")).click();
        wait.until(titleIs("About - OnVoya"));
        System.out.println("--- About Us - works --- ");

        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[2]/a")).click();
        wait.until(titleIs("Team - OnVoya"));
        System.out.println("--- Team - works --- ");

        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[4]/a")).click();
        wait.until(titleIs("Contact Us - OnVoya"));
        System.out.println("--- Contact Us - works --- ");

        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[3]/a")).click();
        wait.until(titleIs("OnVoya Help Desk"));
        System.out.println("--- FAQ - works --- ");

        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[2]/div/span[2]/a")).click();
        wait.until(titleIs("Privacy - OnVoya"));
        System.out.println("--- Privacy - works --- ");

        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[2]/div/span[3]/a")).click();
        wait.until(titleIs("Terms - OnVoya"));
        System.out.println("--- Terms - works --- ");




//*[@id="portlet_56_INSTANCE_ANyVkEOKo7rE"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/a/span


        driver.navigate().to("http://web2.onvoya.com"); // paris
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/a/span")).click();
        wait.until(urlContains("http://web2.onvoya.com/paris/"));
        System.out.println("--- Paris (picture) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // beijing
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[2]/a/span")).click();
        wait.until(urlContains("http://web2.onvoya.com/beijing/"));
        System.out.println("--- Beijing (picture) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // seoul
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/a/span/span[1]")).click();
        wait.until(urlContains("http://web2.onvoya.com/seoul/"));
        System.out.println("--- Seoul (picture) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // bangkok
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[3]/a/span")).click();
        wait.until(urlContains("http://web2.onvoya.com/bangkok/"));
        System.out.println("--- Bangkok (picture) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // rome
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[2]/a/span")).click();
        wait.until(urlContains("http://web2.onvoya.com/rome/"));
        System.out.println("--- Rome (picture) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // london
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[3]/a/span/span[1]")).click();
        wait.until(urlContains("http://web2.onvoya.com/london/"));
        System.out.println("--- London (picture) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // barcelona
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[4]/a/span")).click();
        wait.until(urlContains("http://web2.onvoya.com/barcelona/"));
        System.out.println("--- Barcelona (picture) - works --- ");





        //first column



        driver.navigate().to("https://www.web2.onvoya.com.com/"); // new-york
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[1]")).click();
        wait.until(urlContains("http://web2.onvoya.com/new-york/"));
        System.out.println("--- New - York (search) - works --- ");

//        driver.navigate().to("https://www.web2.onvoya.com.com/"); // los-angeles
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[2]")).click();
//        wait.until(urlContains("http://web2.onvoya.com/los-angeles/"));
//        System.out.println("--- Los-Angeles (search) - works --- ");
//
//        driver.navigate().to("http://www.web2.onvoya.com.com/"); // san-francisco
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[3]")).click();
//        wait.until(urlContains("http://web2.onvoya.com/san-francisco/"));
//        System.out.println("--- San-Francisco (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // london
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[4]")).click();
        wait.until(urlContains("http://web2.onvoya.com/london/"));
        System.out.println("--- London (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // rio de janeiro
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[5]")).click();
        wait.until(urlContains("http://web2.onvoya.com/rio-de-janeiro/"));
        System.out.println("--- Rio de Janeiro (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // beijing
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[6]")).click();
        wait.until(urlContains("http://web2.onvoya.com/beijing/"));
        System.out.println("--- Beijing (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // istanbul
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[7]")).click();
        wait.until(urlContains("http://web2.onvoya.com/istanbul/"));
        System.out.println("--- Istanbul (search) - works --- ");




        //second column




        driver.navigate().to("http://www.web2.onvoya.com.com/"); // crete
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[1]")).click();
        wait.until(urlContains("http://web2.onvoya.com/crete/"));
        System.out.println("--- Crete (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // rome
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[2]")).click();
        wait.until(urlContains("http://web2.onvoya.com/rome/"));
        System.out.println("--- Rome (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // barcelona
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[3]")).click();
        wait.until(urlContains("http://web2.onvoya.com/barcelona/"));
        System.out.println("--- Barcelona (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // paris
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[4]")).click();
        wait.until(urlContains("http://web2.onvoya.com/paris/"));
        System.out.println("--- Paris (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // porto
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[5]")).click();
        wait.until(urlContains("http://web2.onvoya.com/porto/"));
        System.out.println("--- Porto (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // prague
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[6]")).click();
        wait.until(urlContains("http://web2.onvoya.com/prague/"));
        System.out.println("--- Prague (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // amsterdam
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[7]")).click();
        wait.until(urlContains("http://web2.onvoya.com/amsterdam/"));
        System.out.println("--- Amsterdam (search) - works --- ");


        //third column



        driver.navigate().to("http://www.web2.onvoya.com.com/"); // St.Petersburg
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[1]")).click();
        wait.until(urlContains("http://web2.onvoya.com/st-petersburg/"));
        System.out.println("--- St.Petersburg (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // Hoi An
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[2]")).click();
        wait.until(urlContains("http://web2.onvoya.com/hoi-an/"));
        System.out.println("--- Hoi An (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); //bali
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[3]")).click();
        wait.until(urlContains("http://web2.onvoya.com/bali/"));
        System.out.println("--- Bali (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // dubai
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[4]")).click();
        wait.until(urlContains("http://web2.onvoya.com/dubai/"));
        System.out.println("--- Dubai (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // seoul
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[5]")).click();
        wait.until(urlContains("http://web2.onvoya.com/seoul/"));
        System.out.println("--- Seoul (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // bangkok
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[6]")).click();
        wait.until(urlContains("http://web2.onvoya.com/bangkok/"));
        System.out.println("--- Bangkok (search) - works --- ");

        driver.navigate().to("http://www.web2.onvoya.com.com/"); // phuket
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[7]")).click();
        wait.until(urlContains("http://web2.onvoya.com/phuket/"));
        System.out.println("--- Phuket (search) - works --- ");
    }


}
