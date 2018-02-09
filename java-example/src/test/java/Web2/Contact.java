package Web2;

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

    public WebDriver driver;
    public WebDriverWait wait;

      @Test
    public void Send()  {

//          driver = new ChromeDriver();
//          wait = new WebDriverWait(driver, 5);
          driver.navigate().to("http://web2.onvoya.com/contact");

        driver.findElement(By.xpath("//*[@id=\"_contactus_WAR_contactus_name\"]")).sendKeys("Anna");
        driver.findElement(By.xpath("//*[@id=\"_contactus_WAR_contactus_emailAddress\"]")).sendKeys("a.budkina@onvoya.com");
        driver.findElement(By.xpath("//*[@id=\"_contactus_WAR_contactus_comment\"]")).sendKeys("Test comment");

        driver.findElement(By.xpath("//*[@id=\"_contactus_WAR_contactus_contact-form\"]/div[5]/button")).click();

        WebElement Thanks = driver.findElement(By.xpath("//*[@id=\"formContainer\"]/div"));
        wait.until(visibilityOf(Thanks));
    }


}
