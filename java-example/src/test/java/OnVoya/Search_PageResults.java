package OnVoya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class Search_PageResults {

    private WebDriver driver;
    private WebDriverWait wait;

    @Test(priority =1)
    public void OneWay_PageResults(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 90);

        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-20&Adult=1&Ref=WF1");
        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).clear();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"onewayDepart\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[4]/div[2]/table[2]/tbody/tr[1]/td[7]/div/span")).click();

        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[3]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[4]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[5]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[6]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"oneway-traveler\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).sendKeys("NYC"); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).click();

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/input")).sendKeys("LON"); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[3]/div/div/div/div[3]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.xpath("//*[@id=\"onewayDepart\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[4]/div[2]/table[2]/tbody/tr[1]/td[7]/div/span")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}

    @Test (priority = 2)
    public void Round_PageResults(){
        //ROUND TRIP

        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-14&Adult=1&Ref=WF1");
        WebElement new2 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new2));

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div[1]/div[1]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).clear();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"departDate\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[1]/div[2]/table[2]/tbody/tr[1]/td[7]/div/span")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[2]/div[2]/table[2]/tbody/tr[1]/td[7]/div/span")).click();

        driver.findElement(By.xpath("//*[@id=\"traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[3]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[4]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[5]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[6]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"traveler\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[1]/div/input")).sendKeys("MOW"); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"searchSelected\"]")));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).click();

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/input")).sendKeys("LON"); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"round-trip\"]/div/div[1]/div[3]/div/div/div/div[2]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div[2]/div[2]/input")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}

    @Test (priority = 3)
    public void Multi_PageResults(){
//            MULTI TRIP

        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-14&Adult=1&Ref=WF1");
        WebElement new2 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new2));

        driver.findElement(By.xpath("//*[@id=\"oneway-trip\"]/div/div[1]/div[1]/div/input")).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div[1]/div[3]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/input")).clear();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"multicityDepart-1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[5]/div[2]/table[2]/tbody/tr[1]/td[7]/div")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"multicity-traveler\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[3]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[4]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[5]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"traveller-container\"]/div[1]/div[6]/div[2]/div[3]/button/span")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"select-traveller\"]/ul/li[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"multicity-traveler\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/input")).sendKeys("MOW"); // находит по элементу поле и вставляет значение
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/div/div/div[2]")));

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[1]/div/div/div/div[2]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/input")).click();

        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/input")).sendKeys("LON"); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(1700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div[1]/div[3]/div/div/div/div[3]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[5]/div[2]/table[2]/tbody/tr[1]/td[7]/div")).click();

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

        //ВТОРОЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[1]/div/input")).click(); // находит по элементу поле и вставляет значение

        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[3]/div/input")).sendKeys("NYC"); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"row-2\"]/div[1]/div[3]/div/div/div/div[3]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[6]/div[2]/table[1]/tbody/tr[2]/td[7]/div/span")).click();

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

        //ТРЕТИЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-3\"]/div[1]/div[1]/div/input")).click(); // находит по элементу поле и вставляет значение

        driver.findElement(By.xpath("//*[@id=\"row-3\"]/div[1]/div[3]/div/input")).sendKeys("PAR"); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"row-3\"]/div[1]/div[3]/div/div/div/div[3]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[7]/div[2]/table[1]/tbody/tr[3]/td[7]/div/span")).click();

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

        //ЧЕТВЕРТЫЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-4\"]/div[1]/div[1]/div/input")).click(); // находит по элементу поле и вставляет значение

        driver.findElement(By.xpath("//*[@id=\"row-4\"]/div[1]/div[3]/div/input")).sendKeys("CHI"); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"row-4\"]/div[1]/div[3]/div/div/div/div[3]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[8]/div[2]/table[1]/tbody/tr[4]/td[7]/div/span")).click();

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

        //ПЯТЫЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-5\"]/div[1]/div[1]/div/input")).click(); // находит по элементу поле и вставляет значение

        driver.findElement(By.xpath("//*[@id=\"row-5\"]/div[1]/div[3]/div/input")).sendKeys("TOR"); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"row-5\"]/div[1]/div[3]/div/div/div/div[3]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[9]/div[2]/table[2]/tbody/tr[1]/td[7]/div/span")).click();

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"add-more-leg\"]/div")).click();

        //ШЕСТОЙ ПОЛЕТ

        driver.findElement(By.xpath("//*[@id=\"row-6\"]/div[1]/div[1]/div/input")).click(); // находит по элементу поле и вставляет значение

        driver.findElement(By.xpath("//*[@id=\"row-6\"]/div[1]/div[3]/div/input")).sendKeys("TYO"); // находит по элементу поле и вставляет значение

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"row-6\"]/div[1]/div[3]/div/div/div/div[3]")).click();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"dp_widget_container\"]/div[10]/div[2]/table[1]/tbody/tr[2]/td[7]/div/span")).click();

        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div[2]/div[2]/input")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
        driver = null;
    }
}
