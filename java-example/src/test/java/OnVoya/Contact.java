package OnVoya;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Contact {

    private WebDriver driver;
    private WebDriverWait wait;


      @Test
    public void Send()  {

//          driver = new ChromeDriver();
//          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//          wait = new WebDriverWait (driver, 10);

        driver.navigate().to("https://www.onvoya.com/contact");

        driver.findElement(By.xpath("//*[@id=\"_contactus_WAR_contactus_name\"]")).sendKeys("Anna");
        driver.findElement(By.xpath("//*[@id=\"_contactus_WAR_contactus_emailAddress\"]")).sendKeys("a.budkina@onvoya.com");
        driver.findElement(By.xpath("//*[@id=\"_contactus_WAR_contactus_comment\"]")).sendKeys("Test comment");

        driver.findElement(By.xpath("//*[@id=\"_contactus_WAR_contactus_contact-form\"]/div[5]/button")).click();

        WebElement Thanks = driver.findElement(By.xpath("//*[@id=\"formContainer\"]/div"));
        wait.until(visibilityOf(Thanks));
    }



}
