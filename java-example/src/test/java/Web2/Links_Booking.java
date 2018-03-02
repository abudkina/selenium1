package Web2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Links_Booking {

    private WebDriver driver;
    private WebDriverWait wait;
    String parentHandle;
    String winHandleBefore;
    private String url;

    @Test(priority=1)
    public void Terms(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        driver.navigate().to("http://web2.onvoya.com/flights/search?From=DEL&To=NYC&Class=E&Departure=2018-03-20&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);

        try {

            WebElement new1 = driver.findElement(By.id("resultMask"));
            wait.until(invisibilityOf(new1));
        }

        catch (Exception e) { }

        //задаем значение букинга = есть/нет

        parentHandle = driver.getWindowHandle(); // Save parent window
        driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"moreResult\"]/button")).click();

        // ищем среди первых 25 fares нужного провайдера

        for (int i = 1; i < 126; i++) {

            String provider_text = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[1]/div")).getText();

            try {

                WebElement new1 = driver.findElement(By.id("resultMask"));
                wait.until(invisibilityOf(new1));}

            catch (Exception e) {}
            // если есть, то открываем букинг страницу

            if ((provider_text.equals("Cheapoair")||(provider_text.equals("Smartfares")||(provider_text.equals("FareStreet")||(provider_text.equals("WeatJet")))))) {
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[2]/div[1]/div[2]/div/a")).click();


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

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

                //проверяем, что на букинг странице можно заполнить поля, иначе на ней написано "flight is not available"

                try {

                    WebElement BookNow = driver.findElement(By.xpath("//*[@id=\"book-now-btn\"]"));
                    wait.until(visibilityOf(BookNow));
                }

                catch (Exception e) {

                    System.out.println("Booking page is not opened");
                    System.out.println("*********************************************************");
                    Assert.assertEquals("111", driver.getTitle());
                }

                winHandleBefore = driver.getWindowHandle();
                url = driver.getCurrentUrl();

                driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[4]/div/p[2]/a[1]")).click();

                //переключаем действие на открытое окно

                // Switch to new window opened
                for(String winHandle : driver.getWindowHandles()){
                    driver.switchTo().window(winHandle);
                }

                Assert.assertEquals("Terms - OnVoya", driver.getTitle());
                driver.close();
                driver.switchTo().window(winHandleBefore);
                break;
            }
        }
    }

    @Test (priority=2)
    public void Privacy(){

        driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[4]/div/p[2]/a[2]")).click();

        //переключаем действие на открытое окно

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        Assert.assertEquals("Privacy - OnVoya", driver.getTitle());
        driver.close();
        driver.switchTo().window(winHandleBefore);


    }

    @Test (priority=3)
    public void ContactUs(){

        driver.findElement(By.xpath("//*[@id=\"booking-form\"]/div/div[1]/div[5]/div/a")).click();

        //переключаем действие на открытое окно

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        Assert.assertEquals("Contact Us - OnVoya", driver.getTitle());
        driver.close();
        driver.switchTo().window(winHandleBefore);


    }

    @Test (priority=4)
    public void Facebook(){

        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[2]/ul/li[1]/a/i")).click();

        //переключаем действие на открытое окно

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
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
        driver.switchTo().window(winHandleBefore);

    }

    @Test (priority=5)
    public void Twitter(){

        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[2]/ul/li[2]/a/i")).click();

        //переключаем действие на открытое окно

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
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
        driver.switchTo().window(winHandleBefore);

    }

    @Test (priority=6)
    public void Instagram(){

        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[2]/ul/li[3]/a/i")).click();

        //переключаем действие на открытое окно

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
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
        driver.switchTo().window(winHandleBefore);

    }

    @Test (priority=7)
    public void Hotels(){

        driver.findElement(By.xpath("//*[@id=\"layout_6\"]/a/span[2]")).click();

        //переключаем действие на открытое окно

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
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
        driver.switchTo().window(winHandleBefore);

    }

    @Test (priority=8)
    public void Cars(){

        driver.findElement(By.xpath("//*[@id=\"layout_7\"]/a/span[2]")).click();

        //переключаем действие на открытое окно

        // Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
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
        driver.switchTo().window(winHandleBefore);

    }

    @Test (priority=9)
    public void Flights(){

        driver.findElement(By.xpath("//*[@id=\"layout_2\"]/a/span[2]")).click();

        wait.until(titleIs("Search Flights: Find Cheap Airfares and Compare Airline Tickets - OnVoya"));
        Assert.assertEquals("Search Flights: Find Cheap Airfares and Compare Airline Tickets - OnVoya", driver.getTitle());

    }

    @Test (priority=10)
    public void AboutUs(){

        driver.navigate().to(url);
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[1]/a")).click();
        Assert.assertEquals("About - OnVoya", driver.getTitle());

    }

    @Test (priority=11)
    public void TeamUs(){

        driver.navigate().to(url);
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[2]/a")).click();
        Assert.assertEquals("Team - OnVoya", driver.getTitle());

    }

    @Test (priority=12)
    public void FAQ(){

        driver.navigate().to(url);
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[3]/a")).click();
        Assert.assertEquals("OnVoya Help Desk", driver.getTitle());

    }

    @Test (priority=13)
    public void PrivacyP(){

        driver.navigate().to(url);
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[2]/div/span[2]/a")).click();
        Assert.assertEquals("Privacy - OnVoya", driver.getTitle());

    }

    @Test (priority=14)
    public void TermsC(){

        driver.navigate().to(url);
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[2]/div/span[3]/a")).click();
        Assert.assertEquals("Terms - OnVoya", driver.getTitle());
        driver.close();
        driver.quit();

    }
}
