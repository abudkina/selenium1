package Web2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class Details {

    public WebDriver driver;
    public WebDriverWait wait;
    public String from;
    public String to;
    public String date;

    @Test
    public void detailsFaresOneWay () {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.navigate().to("http://web2.onvoya.com/flights/search?From=NYC&To=DEL&Class=E&Departure=2018-03-04&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 120);

        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));

        driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).click();
        from = driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).getText();// взять название без 6 последних символов
        from.substring(0,6);
        to = driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).getText();// взять название без 6 последних символов
        to.substring(0,6);
        date = driver.findElement(By.xpath("//*[@id=\"onewayDepart\"]")).getText();// взять дату

    }

    public void compareFromToOneWay () {

        for (int i=1;i<26;i++){

            driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" +i+ "]/div/div/div[2]")).click();
            String FromTo = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[2]/div[1]/div/div[1]/span[1]")).getText();
            String Date = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div[2]/div[1]/div/div[1]/span[1]")).getText();
            if (FromTo.contains(from) && FromTo.contains(to) && Date.contains(date)) {

                System.out.println("Details are the same");

            }
            else {
                System.out.println("*******************************");
                System.out.println("DETAILS ARE NOT THE SAME");
                Assert.assertEquals("111", driver.getTitle());}
        }

    }

    }

