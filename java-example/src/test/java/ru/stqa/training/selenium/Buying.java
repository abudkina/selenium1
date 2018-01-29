package ru.stqa.training.selenium;

        import  org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.util.concurrent.TimeUnit;

        import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
        import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
        //import static org.openqa.selenium.support.ui.ExpectedConditions.


public class Buying {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before

    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 30);
    }


   // @Test
    public void Buy()  {
        driver.get ("http://www.onvoya.com/");
        driver.findElement(By.name("from")).sendKeys("jfk"); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.name("to")).sendKeys("lgw"); // находит по элементу поле и вставляет значение
        driver.findElement(By.xpath("//*[@id=\"searchSelected\"]")).click();
        driver.findElement(By.name("from")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[2]/div[2]/div[1]/div[2]")).click();
        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));
    }

    @Test
    public void Book() {
        driver.navigate().to("https://www.onvoya.com/flights/search?searchSessionId=1c9015d8-033a-4597-8ca8-6cd28bc6622e");
      //  WebElement new1 = driver.findElement(By.xpath("//*[@id=\"searchBanner\"]/div"));
       // wait.until(visibilityOf(new1));
      //  driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[2]/div/div[1]/a")).click();
     //   WebElement new2 = driver.findElement(By.xpath("//*[@id=\"resultMask\"]"));
       // wait.until(visibilityOf(new2));
        driver.manage().timeouts().setScriptTimeout (30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[2]/div/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();
        wait.until(titleIs("111"));

    }


    @After

    public void stop () {
        driver.quit();
        driver = null;
    }
}
