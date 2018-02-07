package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FullScreen {

        private WebDriver driver;
        private WebDriverWait wait;

        @Before

        public void start() {
           // driver = new InternetExplorerDriver();
            // driver = new FirefoxDriver();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-fullscreen");
            driver = new ChromeDriver(options);
           DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(ChromeOptions.CAPABILITY,options);
           //driver = new ChromeDriver(caps);
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait (driver, 10);
        }

        @Test
        public void myFirstTest() throws InterruptedException {
            driver.get ("https://www.google.com/");
           //driver.findElement(By.id("gs_ok0")).click();
          // driver.findElement(By.id("K32")).click();
          // driver.findElement(By.id("gs_ok0")).click();
            driver.findElement(By.name("q")).sendKeys("gfghfht424524");
            driver.findElement(By.name("btnK")).click();
            wait.until(titleIs("gfghfht424524 - Поиск в Google"));
        }

        @After

        public void stop () {
            driver.quit();
            driver = null;
        }
}
