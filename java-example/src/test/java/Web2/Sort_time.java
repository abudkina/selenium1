package Web2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class Sort_time {

    public WebDriver driver;
    public WebDriverWait wait;
    int result;

    @Test (priority =1)

    public void Sort_time_departure_One () {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY,options);


       // driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.navigate().to("http://web2.onvoya.com/flights/search?From=NYC&To=DEL&Class=E&Departure=2018-03-04&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 30);


        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));

        String[] early = new String[]{"12", "00", "01", "02", "03", "04", "05", "06", "07"};

        String[] morning = new String[]{"08", "09", "10", "11"};

        String[] noon = new String[]{"12", "00", "01", "02", "03", "04", "05"};

        String[] evening = new String[]{"06", "07", "08", "09", "10", "11"};

       //early

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[4]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[1]/div[2]/div[1]")).getText();

            if (time.contains("am"))  {

                time = time.substring(0,2);

                for (int j=0;j<early.length;j++) {

                    if (time.equals(early[j])) {
                        result +=1;
                        break;
                    }
               }
         }

        }

        if (result!=25) {System.out.println("Not Work");}

        //morning

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[4]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[4]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[1]/div[2]/div[1]")).getText();

            if (time.contains("am"))  {

                time = time.substring(0,2);

                for (int j=0;j<morning.length;j++) {

                    if (time.equals(morning[j])) {
                        result +=1;
                        break;
                    }
                }
            }
        }

        if (result!=25) {System.out.println("Not Work");}

        //noon

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[4]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[4]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[1]/div[2]/div[1]")).getText();

            if (time.contains("pm"))  {

                time = time.substring(0,2);

                for (int j=0;j<noon.length;j++) {

                    if (time.equals(noon[j])) {
                        result +=1;
                        break;
                    }
                }

            }

        }

        if (result!=25) {System.out.println("Not Work");}

        //evening

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[4]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[4]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();
        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[1]/div[2]/div[1]")).getText();

            if (time.contains("pm"))  {

                time = time.substring(0,2);

                for (int j=0;j<evening.length;j++) {

                    if (time.equals(evening[j])) {
                        result +=1;
                        break;
                    }
                }

            }

        }

        if (result!=25) {System.out.println("Not Work");}

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[4]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();
    }

    @Test (priority =2)

    public void Sort_time_arrive_One () {

//        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
//        driver.navigate().to("http://web2.onvoya.com/flights/search?From=NYC&To=DEL&Class=E&Departure=2018-03-04&Adult=1&Ref=WF1");
//        wait = new WebDriverWait(driver, 30);
//
//        WebElement new1 = driver.findElement(By.id("resultMask"));
//        wait.until(invisibilityOf(new1));

        String[] early = new String[]{"12", "00", "01", "02", "03", "04", "05", "06", "07"};

        String[] morning = new String[]{"08", "09", "10", "11"};

        String[] noon = new String[]{"12", "00", "01", "02", "03", "04", "05"};

        String[] evening = new String[]{"06", "07", "08", "09", "10", "11"};

        //early

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[5]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[1]/div[4]/div[1]")).getText();

            if (time.contains("am"))  {

                time = time.substring(0,2);

                for (int j=0;j<early.length;j++) {

                    if (time.equals(early[j])) {
                        result +=1;
                        break;
                    }
                }

            }

        }
        if (result!=25) {System.out.println("Not Work");}
        //morning

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[5]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[5]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[1]/div[4]/div[1]")).getText();

            if (time.contains("am"))  {

                time = time.substring(0,2);

                for (int j=0;j<morning.length;j++) {

                    if (time.equals(morning[j])) {
                        result +=1;
                        break;
                    }
                }

            }
        }

        if (result!=25) {System.out.println("Not Work");}
        //noon

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[5]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[5]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[1]/div[4]/div[1]")).getText();

            if (time.contains("pm"))  {

                time = time.substring(0,2);

                for (int j=0;j<noon.length;j++) {

                    if (time.equals(noon[j])) {
                        result +=1;
                        break;
                    }
                }

            }
        }
            if (result!=25) {System.out.println("Not Work");}

        //evening

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[5]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[5]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[1]/div[4]/div[1]")).getText();

            if (time.contains("pm"))  {

                time = time.substring(0,2);

                for (int j=0;j<evening.length;j++) {

                    if (time.equals(evening[j])) {
                        result +=1;
                        break;
                    }
                }

            }

        }

        if (result!=25) {System.out.println("Not Work");}
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[5]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();
    }

    @Test (priority =3)

    public void Sort_time_departure_Round () {

//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 5);
        driver.navigate().to("http://web2.onvoya.com/flights/search?From=NYC&To=DEL&Class=E&Departure=2018-03-04&Return=2018-03-08&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 50);

        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));

        String[] early = new String[]{"12", "00", "01", "02", "03", "04", "05", "06", "07"};

        String[] morning = new String[]{"08", "09", "10", "11"};

        String[] noon = new String[]{"12", "00", "01", "02", "03", "04", "05"};

        String[] evening = new String[]{"06", "07", "08", "09", "10", "11"};

        //early

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[6]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[3]/div[2]/div[1]")).getText();

            if (time.contains("am"))  {

                time = time.substring(0,2);

                for (int j=0;j<early.length;j++) {

                    if (time.equals(early[j])) {
                        result +=1;
                        break;
                    }
                }

            }

        }
        if (result!=25) {System.out.println("Not Work");}
        //morning

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[6]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[6]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[3]/div[2]/div[1]")).getText();

            if (time.contains("am"))  {

                time = time.substring(0,2);

                for (int j=0;j<morning.length;j++) {

                    if (time.equals(morning[j])) {
                        result +=1;
                        break;
                    }
                }

            }
        }

        if (result!=25) {System.out.println("Not Work");}
        //noon

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[6]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[6]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[3]/div[2]/div[1]")).getText();

            if (time.contains("pm"))  {

                time = time.substring(0,2);

                for (int j=0;j<noon.length;j++) {

                    if (time.equals(noon[j])) {
                        result +=1;
                        break;
                    }
                }

            }
        }
        if (result!=25) {System.out.println("Not Work");}

        //evening

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[6]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[6]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[3]/div[2]/div[1]")).getText();

            if (time.contains("pm"))  {

                time = time.substring(0,2);

                for (int j=0;j<evening.length;j++) {

                    if (time.equals(evening[j])) {
                        result +=1;
                        break;
                    }
                }

            }

        }

        if (result!=25) {System.out.println("Not Work");}
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[6]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();
    }

    @Test (priority =4)

    public void Sort_time_arrive_Round () {

        //driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
       // driver.navigate().to("http://web2.onvoya.com/flights/search?From=NYC&To=DEL&Class=E&Departure=2018-03-04&Return=2018-03-08&Adult=1&Ref=WF1");
        //wait = new WebDriverWait(driver, 90);

//        WebElement new1 = driver.findElement(By.id("resultMask"));
//        wait.until(invisibilityOf(new1));

        String[] early = new String[]{"12", "00", "01", "02", "03", "04", "05", "06", "07"};

        String[] morning = new String[]{"08", "09", "10", "11"};

        String[] noon = new String[]{"12", "00", "01", "02", "03", "04", "05"};

        String[] evening = new String[]{"06", "07", "08", "09", "10", "11"};

        //early

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[7]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[3]/div[4]/div[1]")).getText();

            if (time.contains("am"))  {

                time = time.substring(0,2);

                for (int j=0;j<early.length;j++) {

                    if (time.equals(early[j])) {
                        result +=1;
                        break;
                    }
                }

            }

        }
        if (result!=25) {System.out.println("Not Work");}
        //morning

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[7]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[7]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[3]/div[4]/div[1]")).getText();

            if (time.contains("am"))  {

                time = time.substring(0,2);

                for (int j=0;j<morning.length;j++) {

                    if (time.equals(morning[j])) {
                        result +=1;
                        break;
                    }
                }

            }
        }

        if (result!=25) {System.out.println("Not Work");}
        //noon

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[7]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[7]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[3]/div[4]/div[1]")).getText();

            if (time.contains("pm"))  {

                time = time.substring(0,2);

                for (int j=0;j<noon.length;j++) {

                    if (time.equals(noon[j])) {
                        result +=1;
                        break;
                    }
                }

            }
        }
        if (result!=25) {System.out.println("Not Work");}

        //evening

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[7]/div/div[2]/div[1]/ul/li[3]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[7]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();

        result = 0;

        for (int i=1; i<26; i++) {

            String time = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[3]/div[4]/div[1]")).getText();

            if (time.contains("pm"))  {

                time = time.substring(0,2);

                for (int j=0;j<evening.length;j++) {

                    if (time.equals(evening[j])) {
                        result +=1;
                        break;
                    }
                }

            }

        }

        if (result!=25) {System.out.println("Not Work");}
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[7]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();

        driver.quit();
        driver = null;

    }

}

