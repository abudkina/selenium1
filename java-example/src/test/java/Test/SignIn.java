package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
//import static org.openqa.selenium.support.ui.ExpectedConditions.

public class SignIn {

        private WebDriver driver;
        private WebDriverWait wait;

        @Before

        public void start() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait (driver, 10);
        }

        @Test
        public void myFirstTest(){

            driver.navigate().to("https://www.onvoya.com/flights/booking?searchSessionId=0913ec6e-b255-4ea2-bc54-2f5fb3271f6f&itineraryKey=118JFK1519416000000KUE381KWI1519498200000KUE&itineraryId=f385a278-0193-4f72-8930-f839b2c6d52b&provider=Smartfares&deepLink=null");



            driver.findElement(By.xpath("//*[@id=\"create-account\"]")).click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

          WebElement a =  driver.findElement(By.xpath("//*[@id=\"yui_patched_v3_11_0_1_1518187539018_642\"]"));
if (a.isDisplayed())

{  System.out.println("найдено"); }}

         //   <button class="btn" type="button" onclick="callLoginServeResource()" id="yui_patched_v3_11_0_1_1518180388330_461">

        @After

        public void stop () {
            driver.quit();
            driver = null;
        }

}
