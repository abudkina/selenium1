package ru.stqa.training.selenium.Final_web2;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Final {

    // public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before

    public void start() {

//        if (tlDriver.get() !=null) {
//
//            driver = tlDriver.get();
//            wait = new WebDriverWait(driver , 10);
//            return;
//        }

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(ChromeOptions.CAPABILITY, false);
//        driver = new ChromeDriver(caps);

        if (driver != null) {

            if (driver != null) {

                return;
            }

        }

        driver = new ChromeDriver();
//        tlDriver.set(driver);
        System.out.println(((HasCapabilities)driver).getCapabilities());
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(

                new Thread(() -> {driver.quit(); driver = null;}));
    }

    @After

    public void stop() {
        driver.quit();
        driver = null;
    }
}
