package ru.stqa.training.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class Example {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 30);
    }

    @Test

    public void Sort(){

        driver.navigate().to("http://web2.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-04&Return=2018-03-08&Adult=1&Child=1&Ref=WF1");
        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));
        detailsOpened(driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[2]/div")));

        SortStops_1();
    }

    private void detailsOpened (WebElement a) {

        a.click();
        System.out.println("Details are opened");}


    private void SortStops_1 () {

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();


        String firstStop = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[2]")).getText();
        int firstNumber = Integer.parseInt(firstStop);

        String fiveStop = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[5]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[2]")).getText();
        int fiveNumber = Integer.parseInt(fiveStop);

        String tenStop = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[10]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[2]")).getText();
        int tenNumber = Integer.parseInt(tenStop);

        String feevStop = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[15]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[2]")).getText();
        int feevNumber = Integer.parseInt(feevStop);

        if ((firstNumber==1) && (fiveNumber==1) && (tenNumber==1) && (feevNumber==1)){

            System.out.println("Sort Stop = 1 - working"); }

         else {System.out.println("SORT STOPS = 1 NOT WORKING");}

        }



    @After

    public void stop () {
        driver.quit();
        driver = null;
    }
}
