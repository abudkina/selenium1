package Web2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Stops {

    public WebDriver driver;
    public WebDriverWait wait;
    int p;
    boolean result;
    int results;
    int stop;
    int length;

    @Test
    public void Sorting() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        driver.navigate().to("http://web2.onvoya.com/flights/search?From=NYC&To=LON&Class=E&Departure=2018-04-01&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);

        try {

            WebElement new1 = driver.findElement(By.id("resultMask"));
            wait.until(invisibilityOf(new1));
        } catch (Exception e) {
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String a = driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[1]/label/span[2]")).getText();
        length = Integer.parseInt(a);
        if (length<25) {length = Integer.parseInt(a);}
        else {length = 25;}

        stop=0;

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SortingStops();


        a = driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[2]/label/span[2]")).getText();
        length = Integer.parseInt(a);
        if (length<25) {length = Integer.parseInt(a);}
        else {length = 25;}

        stop=1;

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SortingStops();

        a = driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[3]/label/span[2]")).getText();
        length = Integer.parseInt(a);
        if (length<25) {length = Integer.parseInt(a);}
        else {length = 25;}

        stop=2;

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SortingStops();

        a = driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[4]/label/span[2]")).getText();
        length = Integer.parseInt(a);
        if (length<25) {length = Integer.parseInt(a);}
        else {length = 25;}

        stop=3;

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SortingStopsMoreThree();

        driver.quit();
        driver = null;
    }

    private void SortingStops(){

        results=0;

        for (int i = 1; i <= 20; i++) {

            p=0;

            driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+ i +"]/div/div[1]/div[2]/div/div[1]/a")).click();

            try {
                Thread.sleep(1600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String a = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[2]/div[1]")).getText();

            if (a.contains("Change planes") || (stop!=0)) {

                a = a.replaceAll("Change planes", "*");

                for (int j = 1; j < a.length(); j++) {

                    if (a.charAt(j) == '*') {
                        p += 1;
                    }
                }

                if (p == stop) {

                    result = true;

                    results +=1;}

                else {System.out.println("Not stops"); }}

            if (stop==0) {

                if (a.contains("Change planes"))

                {System.out.println("Not working!!!");}

                else {results=25;}

            driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+ i +"]/div/div[1]/div[2]/div/div[1]/a")).click();
        }}

        if (results != length) { System.out.println("Not working "+length+ " " + results); }}

    private void SortingStopsMoreThree(){

        results=0;

        for (int i = 1; i <= length; i++) {

            p=0;

            driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+ i +"]/div/div[1]/div[2]/div/div[1]/a")).click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String a = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[2]/div[1]")).getText();

            if (a.contains("Change planes")) {

                a = a.replaceAll("Change planes", "*");

                for (int j = 1; j < a.length(); j++) {

                    if (a.charAt(j) == '*') {
                        p += 1;
                    }
                }

                if (p >= stop) {

                    result = true;

                    results +=1;}

            }

            else {System.out.println("Not stops"); }

            driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+ i +"]/div/div[1]/div[2]/div/div[1]/a")).click();
        }

        if (results != length) { System.out.println("Not working "+length + " " + results); }

    }

}
