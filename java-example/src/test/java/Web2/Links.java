package Web2;

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;


public class Links {

    private WebDriver driver;
    private WebDriverWait wait;


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

    @Test(priority = 7)
    public void Paris_Picture(){
        driver.navigate().to("http://web2.onvoya.com/"); // paris
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/a/span")).click();
        Assert.assertEquals("http://web2.onvoya.com/paris/", driver.getCurrentUrl());}

    @Test(priority = 8)
    public void Bejing_Picture(){
        driver.navigate().to("http://web2.onvoya.com/"); // beijing
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[2]/a/span")).click();
        Assert.assertEquals("http://web2.onvoya.com/beijing/", driver.getCurrentUrl());}

    @Test(priority = 9)
    public void Seoul_Picture(){
        driver.navigate().to("http://web2.onvoya.com/"); // seoul
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[2]/a/span/span[1]")).click();
        Assert.assertEquals("http://web2.onvoya.com/seoul/", driver.getCurrentUrl());}

    @Test(priority = 10)
    public void Bangkok_Picture(){
        driver.navigate().to("http://web2.onvoya.com/"); // bangkok
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div[3]/a/span")).click();
        Assert.assertEquals("http://web2.onvoya.com/bangkok/", driver.getCurrentUrl());}

    @Test(priority = 11)
    public void Rome_Picture(){
        driver.navigate().to("http://web2.onvoya.com/"); // rome
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[2]/a/span")).click();
        Assert.assertEquals("http://web2.onvoya.com/rome/", driver.getCurrentUrl());}

    @Test(priority = 12)
    public void London_Picture(){
        driver.navigate().to("http://web2.onvoya.com/"); // london
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[3]/a/span/span[1]")).click();
        Assert.assertEquals("http://web2.onvoya.com/london/", driver.getCurrentUrl());}


    @Test(priority = 13)
    public void Barcelona_Picture(){
        driver.navigate().to("http://web2.onvoya.com/"); // barcelona
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_7VVAgmnsDNVm\"]/div/div/div/div[1]/div/div/div/div[4]/a/span")).click();
        Assert.assertEquals("http://web2.onvoya.com/barcelona/", driver.getCurrentUrl());}


//        first column

    @Test(priority = 14)
    public void New_York_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // new-york
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[1]")).click();
        Assert.assertEquals("http://web2.onvoya.com/new-york/", driver.getCurrentUrl());}

    @Test(priority = 15)
    public void Los_Angeles_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // los-angeles
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[2]")).click();
        Assert.assertEquals("http://web2.onvoya.com/los-angeles/", driver.getCurrentUrl());}

    @Test(priority = 16)
    public void San_Francisco_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // san-francisco
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[3]")).click();
        Assert.assertEquals("http://web2.onvoya.com/san-francisco/", driver.getCurrentUrl());}

    @Test(priority = 17)
    public void London_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // london
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[4]")).click();
        Assert.assertEquals("http://web2.onvoya.com/london/", driver.getCurrentUrl());}

    @Test(priority = 18)
    public void Rio_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // rio de janeiro
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[5]")).click();
        Assert.assertEquals("http://web2.onvoya.com/rio-de-janeiro/", driver.getCurrentUrl());}

    @Test(priority = 19)
    public void Beijing_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // beijing
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[6]")).click();
        Assert.assertEquals("http://web2.onvoya.com/beijing/", driver.getCurrentUrl());}

    @Test(priority = 20)
    public void Istanbul_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // istanbul
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[1]/ul/li[7]")).click();
        Assert.assertEquals("http://web2.onvoya.com/istanbul/", driver.getCurrentUrl());}

    //second column

    @Test(priority = 21)
    public void Crete_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // crete
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[1]")).click();
        Assert.assertEquals("http://web2.onvoya.com/crete/", driver.getCurrentUrl());}

    @Test(priority = 22)
    public void Rome_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // rome
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[2]")).click();
        Assert.assertEquals("http://web2.onvoya.com/rome/", driver.getCurrentUrl());}

    @Test(priority = 23)
    public void Barcelona_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // barcelona
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[3]")).click();
        Assert.assertEquals("http://web2.onvoya.com/barcelona/", driver.getCurrentUrl());}

    @Test(priority = 24)
    public void Paris_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // paris
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[4]")).click();
        Assert.assertEquals("http://web2.onvoya.com/paris/", driver.getCurrentUrl());}

    @Test(priority = 25)
    public void Porto_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // porto
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[5]")).click();
        Assert.assertEquals("http://web2.onvoya.com/porto/", driver.getCurrentUrl());}

    @Test(priority = 26)
    public void Prague_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // prague
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[6]")).click();
        Assert.assertEquals("http://web2.onvoya.com/prague/", driver.getCurrentUrl());}

    @Test(priority = 27)
    public void Amsterdam_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // amsterdam
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[2]/ul/li[7]")).click();
        Assert.assertEquals("http://web2.onvoya.com/amsterdam/", driver.getCurrentUrl());}


    //third column


    @Test(priority = 28)
    public void StPetersburg_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // St.Petersburg
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[1]")).click();
        Assert.assertEquals("http://web2.onvoya.com/st-petersburg/", driver.getCurrentUrl());}

    @Test(priority = 29)
    public void HoiAn_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // Hoi An
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[2]")).click();
        Assert.assertEquals("http://web2.onvoya.com/hoi-an/", driver.getCurrentUrl());}

    @Test(priority = 30)
    public void Bali_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); //bali
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[3]")).click();
        Assert.assertEquals("http://web2.onvoya.com/bali/", driver.getCurrentUrl());}

    @Test(priority = 31)
    public void Dubai_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // dubai
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[4]")).click();
        Assert.assertEquals("http://web2.onvoya.com/dubai/", driver.getCurrentUrl());}

    @Test(priority = 32)
    public void Seoul_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // seoul
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[5]")).click();
        Assert.assertEquals("http://web2.onvoya.com/seoul/", driver.getCurrentUrl());}

    @Test(priority = 33)
    public void Bangkok_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // bangkok
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[6]")).click();
        Assert.assertEquals("http://web2.onvoya.com/bangkok/", driver.getCurrentUrl());}

    @Test(priority = 34)
    public void Phuket_Cities(){
        driver.navigate().to("http://web2.onvoya.com/"); // phuket
        driver.findElement(By.xpath("//*[@id=\"portlet_56_INSTANCE_FdObAQifMTdF\"]/div/div/div/div[1]/div/div/div/div[3]/ul/li[7]")).click();
        Assert.assertEquals("http://web2.onvoya.com/phuket/", driver.getCurrentUrl());
        driver.quit();
        driver = null;
    }


}

