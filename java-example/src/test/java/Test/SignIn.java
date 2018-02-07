package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            driver.get ("http://www.onvoya.com/");
            driver.findElement(By.xpath("//*[@id=\"banner\"]/div/div[3]/ul/li[1]/span")).click();
            wait.until(titleIs("Sign In"));
            driver.findElement(By.xpath("//*[@id=\"yui_patched_v3_11_0_1_1517228562209_514\"]")).click();
        }


    //*[@id="yui_patched_v3_11_0_1_1517224972966_480"]

        @After

        public void stop () {
            driver.quit();
            driver = null;
        }

}
