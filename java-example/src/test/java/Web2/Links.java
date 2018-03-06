package Web2;

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;


public class Links {

    private WebDriver driver;
    private WebDriverWait wait;
    String parentHandle;
    String provider;


    //для каждой ссылки/картинки/города нажимаем на ссылку
    //перехожим на нее
    //проверяем title или url


    @Test(priority = 1)
    public void AboutUs (){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 5);
        driver.get ("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[1]/a")).click();
        Assert.assertEquals("About - OnVoya", driver.getTitle()); }

    @Test(priority = 2)
    public void Team (){
        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[2]/a")).click();
        wait.until(titleIs("Team - OnVoya"));
        Assert.assertEquals("Team - OnVoya", driver.getTitle()); }

    @Test(priority = 3)
    public void ContactUs (){
        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[4]/a")).click();
        Assert.assertEquals("Contact Us - OnVoya", driver.getTitle()); }

    @Test(priority = 4)
    public void Help (){
        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[1]/ul/li[3]/a")).click();
        Assert.assertEquals("OnVoya Help Desk", driver.getTitle());
    }

    @Test(priority = 5)
    public void Privacy (){
        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[2]/div/span[2]/a")).click();
        Assert.assertEquals("Privacy - OnVoya", driver.getTitle());}

    @Test(priority = 6)
    public void Terms (){
        driver.navigate().to("http://web2.onvoya.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[2]/div/span[3]/a")).click();
        Assert.assertEquals("Terms - OnVoya", driver.getTitle());}

//    @Test(priority = 7)
//    public void Paris_Picture(){
//        driver.navigate().to("http://web2.onvoya.com/"); // paris
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_ANyVkEOKo7rE\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/a/span")).click();
//        String City = "Paris";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/paris/", driver.getCurrentUrl());}
//
//    @Test(priority = 8)
//    public void Bejing_Picture(){
//        driver.navigate().to("http://web2.onvoya.com/"); // beijing
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_ANyVkEOKo7rE\"]/div/div/div/div[1]/div/div/div/div[1]/div[2]/a/span")).click();
//
//        String City = "Bejing";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/beijing/", driver.getCurrentUrl());}
//
//    @Test(priority = 9)
//    public void Seoul_Picture(){
//        driver.navigate().to("http://web2.onvoya.com/"); // seoul
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_ANyVkEOKo7rE\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/a/span/span[1]")).click();
//
//        String City = "Seoul";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/seoul/", driver.getCurrentUrl());}
//
//    @Test(priority = 10)
//    public void Bangkok_Picture(){
//        driver.navigate().to("http://web2.onvoya.com/"); // bangkok
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_ANyVkEOKo7rE\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[3]/a/span")).click();
//
//        String City = "Bangkok";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/bangkok/", driver.getCurrentUrl());}
//
//    @Test(priority = 11)
//    public void Rome_Picture(){
//        driver.navigate().to("http://web2.onvoya.com/"); // rome
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_ANyVkEOKo7rE\"]/div/div/div/div[1]/div/div/div/div[2]/a/span")).click();
//
//        String City = "Rome";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/rome/", driver.getCurrentUrl());}
//
//    @Test(priority = 12)
//    public void London_Picture(){
//        driver.navigate().to("http://web2.onvoya.com/"); // london
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_ANyVkEOKo7rE\"]/div/div/div/div[1]/div/div/div/div[3]/a/span/span[1]")).click();
//
//        String City = "London";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/london/", driver.getCurrentUrl());}
//
//
//    @Test(priority = 13)
//    public void Barcelona_Picture(){
//        driver.navigate().to("http://web2.onvoya.com/"); // barcelona
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_ANyVkEOKo7rE\"]/div/div/div/div[1]/div/div/div/div[4]/a/span")).click();
//
//        String City = "Barcelona";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/barcelona/", driver.getCurrentUrl());}


//        first column

//    @Test(priority = 14)
//    public void New_York_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // new-york
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[1]")).click();
//
//        String City = "New York";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/new-york/", driver.getCurrentUrl());}
//
//    @Test(priority = 15)
//    public void Los_Angeles_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // los-angeles
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[2]")).click();
//
//        String City = "Los Angeles";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/los-angeles/", driver.getCurrentUrl());}
//
//    @Test(priority = 16)
//    public void San_Francisco_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // san-francisco
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[3]")).click();
//
//        String City = "San Francisco";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/san-francisco/", driver.getCurrentUrl());}
//
//    @Test(priority = 17)
//    public void London_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // london
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[4]")).click();
//
//        String City = "London";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/london/", driver.getCurrentUrl());}
//
//    @Test(priority = 18)
//    public void Rio_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // rio de janeiro
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[5]")).click();
//
//        String City = "Rio de Janeiro";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/rio-de-janeiro/", driver.getCurrentUrl());}
//
//    @Test(priority = 19)
//    public void Beijing_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // beijing
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[6]")).click();
//
//        String City = "Beijing";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/beijing/", driver.getCurrentUrl());}
//
//    @Test(priority = 20)
//    public void Istanbul_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // istanbul
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[7]")).click();
//
//        String City = "Istanbul";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/istanbul/", driver.getCurrentUrl());}
//
//    //second column
//
//    @Test(priority = 21)
//    public void Crete_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // crete
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[1]")).click();
//
//        String City = "Crete";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/crete/", driver.getCurrentUrl());}
//
//    @Test(priority = 22)
//    public void Rome_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // rome
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[2]")).click();
//
//        String City = "Rome";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/rome/", driver.getCurrentUrl());}
//
//    @Test(priority = 23)
//    public void Barcelona_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // barcelona
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[3]")).click();
//
//        String City = "Barcelona";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/barcelona/", driver.getCurrentUrl());}
//
//    @Test(priority = 24)
//    public void Paris_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // paris
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[4]")).click();
//
//        String City = "Paris";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/paris/", driver.getCurrentUrl());}
//
//    @Test(priority = 25)
//    public void Porto_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // porto
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[5]")).click();
//
//        String City = "Porto";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/porto/", driver.getCurrentUrl());}
//
//    @Test(priority = 26)
//    public void Prague_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // prague
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[6]")).click();
//
//        String City = "Prague";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/prague/", driver.getCurrentUrl());}
//
//    @Test(priority = 27)
//    public void Amsterdam_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // amsterdam
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[7]")).click();
//
//        String City = "Amsterdam";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/amsterdam/", driver.getCurrentUrl());}
//
//
//    //third column
//
//
//    @Test(priority = 28)
//    public void StPetersburg_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // St.Petersburg
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[1]")).click();
//
//        String City = "St. Petersburg";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/st-petersburg/", driver.getCurrentUrl());}
//
//    @Test(priority = 29)
//    public void HoiAn_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // Hoi An
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[2]")).click();
//
//        String City = "Hoi An";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/hoi-an/", driver.getCurrentUrl());}
//
//    @Test(priority = 30)
//    public void Bali_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); //bali
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[3]")).click();
//
//        String City = "Bali";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/bali/", driver.getCurrentUrl());}
//
//    @Test(priority = 31)
//    public void Dubai_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // dubai
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[4]")).click();
//
//        String City = "Dubai";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/dubai/", driver.getCurrentUrl());}
//
//    @Test(priority = 32)
//    public void Seoul_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // seoul
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[5]")).click();
//
//        String City = "Seoul";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/seoul/", driver.getCurrentUrl());}
//
//    @Test(priority = 33)
//    public void Bangkok_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // bangkok
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[6]")).click();
//
//        String City = "Bangkok";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/bangkok/", driver.getCurrentUrl());}
//
//    @Test(priority = 34)
//    public void Phuket_Cities(){
//        driver.navigate().to("http://web2.onvoya.com/"); // phuket
//        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fH7GBmSPIzxt\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[7]")).click();
//
//        String City = "Phuket";
//
//        String title = driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[1]/div[1]/h1")).getText();
//        String information = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[1]/div/div/div[1]/h2")).getText();
//        String weather = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[2]/div[1]/div[1]/h4")).getText();
//        String airport = driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_fMB0Q2OBCEzS\"]/div/div/div/div[1]/div/div[3]/div/div/div[2]/h3")).getText();
//
//        if (!title.contains(City) || (!information.contains(City)) || (!weather.contains(City)) || (!airport.contains(City)))
//        {System.out.println("Does not work "+City);}
//
//        Assert.assertEquals("http://web2.onvoya.com/phuket/", driver.getCurrentUrl());
//    }

        @Test(priority = 35)

        public void Hotels(){

            driver.get ("http://web2.onvoya.com");
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

        @Test(priority = 36)

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

        @Test(priority = 37)

        public void FaceBook(){

        parentHandle = driver.getWindowHandle(); // Save parent window

        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[2]/ul/li[1]/a/i")).click();

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

        @Test(priority = 38)

        public void Twitter(){

        parentHandle = driver.getWindowHandle(); // Save parent window

        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[2]/ul/li[2]/a/i")).click();

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

        @Test(priority = 39)

        public void Instagram(){

        parentHandle = driver.getWindowHandle(); // Save parent window

        driver.findElement(By.xpath("/html/body/div/div[2]/footer/div/div[1]/div/div[2]/ul/li[3]/a/i")).click();

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
        driver.switchTo().window(parentHandle); }

       @Test(priority = 40)

       public void Apple(){

        parentHandle = driver.getWindowHandle(); // Save parent window

        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_TjTYvta2iccX\"]/div/div/div/div[1]/a/span/span[2]")).click();

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
        boolean isContain = URL.contains("https://itunes.apple.com/us/app/id1298953393");

        //если перешли на нужную страницу провайдера

        if (isContain==true) { System.out.println("*********************************");
            System.out.println("Redirect is successful for Apple"); }

        //если страница не открылась

        else {System.out.println("*********************************");
            System.out.println("NOT SUCCESS FOR APPLE");}

        driver.close();
           driver.quit();
           driver = null;
    }


}

