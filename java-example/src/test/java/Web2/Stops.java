package Web2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class Stops {

    public WebDriver driver;
    public WebDriverWait wait;
    public int j = 1;

    @Test
    public void Sorting(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        driver.navigate().to("http://web2.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-04&Return=2018-03-08&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 30);

        try {

            WebElement new1 = driver.findElement(By.id("resultMask"));
            wait.until(invisibilityOf(new1));
        }

        catch (Exception e) { }

        int i=0;


    }
}
