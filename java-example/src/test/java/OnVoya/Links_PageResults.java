package OnVoya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Links_PageResults {

    private WebDriver driver;
    private WebDriverWait wait;
    String parentHandle;

    @Test(priority = 1)
    public void AboutUs (){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 7);
        driver.get ("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-14&Adult=1&Ref=WF1");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[1]/a")).click();
        Assert.assertEquals("About - OnVoya", driver.getTitle()); }

    @Test(priority = 2)
    public void Team (){
        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-14&Adult=1&Ref=WF1");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/footer/div/div[1]/div/div[1]/ul/li[2]/a")).click();
        wait.until(titleIs("Team - OnVoya"));
        Assert.assertEquals("Team - OnVoya", driver.getTitle()); }

    @Test(priority = 3)
    public void ContactUs (){
        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-14&Adult=1&Ref=WF1");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/footer/div/div[1]/div/div[1]/ul/li[4]/a")).click();
        Assert.assertEquals("Contact Us - OnVoya", driver.getTitle()); }

    @Test(priority = 4)
    public void Help (){
        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-14&Adult=1&Ref=WF1");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/footer/div/div[1]/div/div[1]/ul/li[3]/a")).click();
        Assert.assertEquals("OnVoya Help Desk", driver.getTitle());
    }

    @Test(priority = 5)
    public void Privacy (){
        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-14&Adult=1&Ref=WF1");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/footer/div/div[2]/div/span[2]/a")).click();
        Assert.assertEquals("Privacy - OnVoya", driver.getTitle());}

    @Test(priority = 6)
    public void Terms (){
        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-14&Adult=1&Ref=WF1");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/footer/div/div[2]/div/span[3]/a")).click();
        Assert.assertEquals("Terms - OnVoya", driver.getTitle());}

    @Test(priority = 7)

    public void Hotels(){

        driver.get ("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-14&Adult=1&Ref=WF1");
        parentHandle = driver.getWindowHandle(); // Save parent window

        driver.findElement(By.xpath("//*[@id=\"layout_6\"]/a/span[2]")).click();

        //переключаем действие на открытое окно

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() > 1) { // Check if more than 1 window is open
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (!parentHandle.equals(handle)) {
                    break;
                }
            }
        }


        String URL = driver.getCurrentUrl();
        boolean isContain = URL.contains("http://hotels.onvoya.com/");

        //если перешли на нужную страницу провайдера

        if (isContain==true) { System.out.println("*********************************");
            System.out.println("Redirect is successful for Hotels"); }

        //если страница не открылась

        else {System.out.println("*********************************");
            System.out.println("NOT SUCCESS FOR HOTELS");}

        driver.close();
        driver.switchTo().window(parentHandle); }

    @Test(priority = 8)

    public void Cars(){

        parentHandle = driver.getWindowHandle(); // Save parent window

        driver.findElement(By.xpath("//*[@id=\"layout_7\"]/a/span[2]")).click();

        //переключаем действие на открытое окно

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() > 1) { // Check if more than 1 window is open
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (!parentHandle.equals(handle)) {
                    break;
                }
            }
        }

        String URL = driver.getCurrentUrl();
        boolean isContain = URL.contains("http://cars.cartrawler.com/onvoya#/searchcars");

        //если перешли на нужную страницу провайдера

        if (isContain==true) { System.out.println("*********************************");
            System.out.println("Redirect is successful for Cars"); }

        //если страница не открылась

        else {System.out.println("*********************************");
            System.out.println("NOT SUCCESS FOR CARS");}

        driver.close();
        driver.switchTo().window(parentHandle); }

    @Test(priority = 9)

    public void FaceBook(){

        parentHandle = driver.getWindowHandle(); // Save parent window

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/footer/div/div[1]/div/div[2]/ul/li[1]/a/i")).click();

        //переключаем действие на открытое окно

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() > 1) { // Check if more than 1 window is open
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (!parentHandle.equals(handle)) {
                    break;
                }
            }
        }

        String URL = driver.getCurrentUrl();
        boolean isContain = URL.contains("https://www.facebook.com/onvoya");

        //если перешли на нужную страницу провайдера

        if (isContain==true) { System.out.println("*********************************");
            System.out.println("Redirect is successful for Facebook"); }

        //если страница не открылась

        else {System.out.println("*********************************");
            System.out.println("NOT SUCCESS FOR FACEBOOK");}

        driver.close();
        driver.switchTo().window(parentHandle); }

    @Test(priority = 10)

    public void Twitter(){

        parentHandle = driver.getWindowHandle(); // Save parent window

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/footer/div/div[1]/div/div[2]/ul/li[2]/a/i")).click();

        //переключаем действие на открытое окно

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() > 1) { // Check if more than 1 window is open
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (!parentHandle.equals(handle)) {
                    break;
                }
            }
        }

        String URL = driver.getCurrentUrl();
        boolean isContain = URL.contains("https://twitter.com/onvoya");

        //если перешли на нужную страницу провайдера

        if (isContain==true) { System.out.println("*********************************");
            System.out.println("Redirect is successful for Twitter"); }

        //если страница не открылась

        else {System.out.println("*********************************");
            System.out.println("NOT SUCCESS FOR TWITTER");}

        driver.close();
        driver.switchTo().window(parentHandle); }

    @Test(priority = 11)

    public void Instagram(){

        parentHandle = driver.getWindowHandle(); // Save parent window

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/footer/div/div[1]/div/div[2]/ul/li[3]/a/i")).click();

        //переключаем действие на открытое окно

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() > 1) { // Check if more than 1 window is open
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (!parentHandle.equals(handle)) {
                    break;
                }
            }
        }

        String URL = driver.getCurrentUrl();
        boolean isContain = URL.contains("https://www.instagram.com/onvoya/");

        //если перешли на нужную страницу провайдера

        if (isContain==true) { System.out.println("*********************************");
            System.out.println("Redirect is successful for Instagram"); }

        //если страница не открылась

        else {System.out.println("*********************************");
            System.out.println("NOT SUCCESS FOR INSTAGRAM");}

        driver.close();
        driver.switchTo().window(parentHandle);
    }

    @Test(priority = 12)

    public void Flights(){

        driver.findElement(By.xpath("//*[@id=\"layout_2\"]/a/span[2]")).click();
        wait.until(titleIs("Search Flights: Find Cheap Airfares and Compare Airline Tickets - OnVoya"));
        Assert.assertEquals("Search Flights: Find Cheap Airfares and Compare Airline Tickets - OnVoya", driver.getTitle());
        System.out.println("Redirect is successful for Flights");
        driver.close();
        driver.quit();
        driver = null;
    }
}
