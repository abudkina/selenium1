package Web2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class Sort_duration {

    public WebDriver driver;
    public WebDriverWait wait;
    int duration_1;
    int duration_2;

    @Test (priority =1)

    public void Sort_duration_1 () {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.navigate().to("http://web2.onvoya.com/flights/search?From=NYC&To=MEL&Class=E&Departure=2018-02-27&Adult=1&Ref=WF1");
        wait = new WebDriverWait(driver, 90);

        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));

        driver.findElement(By.xpath("//*[@id=\"sortListContainer\"]/ul/li[2]/span")).click();

        for (int i = 1; i < 25; i++) {

            String first = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[1]")).getText();

            String second = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + (i+1) + "]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[1]")).getText();

            if (first.contains("d")) {sort_days_1(first);}

            else {sort_hours_1(first);}

            if (second.contains("d")) {sort_days_2(second);}

            else {sort_hours_2(second);}

            if (duration_2 < duration_1 ) {

                System.out.println("Sorting duration are not working");
            }
    }
        driver.quit();
        driver = null;

    }


    public int sort_hours_1 (String duration) {

        if (duration.length() == 3) {

            duration = duration.substring(0, 2);

            String zero = "00";

            duration = duration + zero;

            duration_1 = Integer.parseInt(duration);

        }

        else {

            if (duration.length() == 5) {

                String duration_11 = duration.substring(0, 1);

                String zero = "0";

                String duration_12 = duration.substring(3, 4);

                duration = zero + duration_11 + zero + duration_12;

                duration_1 = Integer.parseInt(duration);

            }

            else {

            if (duration.length() == 2) {

                duration = duration.substring(0, 1);

                String zero = "00";

                duration = duration + zero;

                duration_1 = Integer.parseInt(duration);

            }

            else {

                if (duration.length() == 6) {

                    try {

                        String duration_11 = duration.substring(0, 1);

                        String duration_12 = duration.substring(3, 5);

                        String durationT = duration_11 + duration_12;

                        duration_1 = Integer.parseInt(durationT);}

                    catch (Exception e) {

                        //duration = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[1]")).getText();

                        String duration_11 = duration.substring(0, 2);

                        String zero = "0";

                        String duration_12 = duration.substring(4, 5);

                        duration = duration_11 + zero + duration_12;

                        duration_1 = Integer.parseInt(duration);
                    }

                }

                else {

                    String duration_11 = duration.substring(0, 2);

                    String duration_12 = duration.substring(4, 6);

                    duration = duration_11 + duration_12;

                    duration_1 = Integer.parseInt(duration);}}



        }}return duration_1;}

    public int sort_days_1 (String duration) {

        if (duration.length() == 2) {

            String duration1 = duration.substring(0, 1);

            String zero1 = "0";

            duration = duration1 + zero1 + zero1 + zero1 + zero1;

            duration_1 = Integer.parseInt(duration);

        }

        else {

        if (duration.length() == 5) {

            String duration1 = duration.substring(0, 1);

            String zero1 = "0";

            String duration2 = duration.substring(3, 4);

            if (duration.contains("h")){

            duration = duration1 + zero1 + duration2 + zero1 + zero1;

            duration_1 = Integer.parseInt(duration);}

            else {

                duration = duration1 + zero1 + zero1 + zero1 + duration2;

                duration_1 = Integer.parseInt(duration);

            }

        }

        else {


            if (duration.length() == 8) {

                String duration1 = duration.substring(0, 1);

                String zero1 = "0";

                String duration2 = duration.substring(3, 4);

                String duration3 = duration.substring(6, 7);

                duration = duration1 + zero1 + duration2 + zero1 + duration3;

                duration_1 = Integer.parseInt(duration);


            }

            else {

            if (duration.length() == 6) {

                String duration1 = duration.substring(0, 1);

                String zero1 = "0";

                String duration2 = duration.substring(3, 5);

                if (duration.contains("h")){

                duration = duration1 + duration2 + zero1 + zero1;

                duration_1 = Integer.parseInt(duration);}

                else { duration = duration1 + zero1 + zero1 + duration2;

                duration_1 = Integer.parseInt(duration);}

            }

            else {

                if (duration.length() == 9) {

                    try {

                        String duration1 = duration.substring(0, 1);

                        String zero1 = "0";

                        String duration2 = duration.substring(3, 4);

                        String duration3 = duration.substring(6, 8);

                        String durationT = duration1 + zero1 + duration2 + duration3;

                        duration_1 = Integer.parseInt(durationT);}

                    catch (Exception e) {

                        //duration = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[1]")).getText();

                        String duration1 = duration.substring(0, 1);

                        String zero1 = "0";

                        String duration2 = duration.substring(3, 5);

                        String duration3 = duration.substring(7, 8);

                        duration = duration1 + duration2 + zero1 + duration3;

                        duration_1 = Integer.parseInt(duration);
                    }

                }

                else {

                    String duration1 = duration.substring(0, 1);

                    String duration2 = duration.substring(3, 5);

                    String duration3 = duration.substring(7,9);

                    duration = duration1 + duration2 + duration3;

                    duration_1 = Integer.parseInt(duration);}}

        }}}

        return duration_1;}

    public int sort_hours_2 (String duration) {

        if (duration.length() == 3) {

            duration = duration.substring(0, 2);

            String zero = "00";

            duration = duration + zero;

            duration_2 = Integer.parseInt(duration);

        }

        else {

            if (duration.length() == 5) {

                String duration_11 = duration.substring(0, 1);

                String zero = "0";

                String duration_12 = duration.substring(3, 4);

                duration = zero + duration_11 + zero + duration_12;

                duration_2 = Integer.parseInt(duration);

            }

        else {

            if (duration.length() == 2) {

                duration = duration.substring(0, 1);

                String zero = "00";

                duration = duration + zero;

                duration_2 = Integer.parseInt(duration);

            }

            else {

                if (duration.length() == 6) {

                    try {

                        String duration_11 = duration.substring(0, 1);

                        String duration_12 = duration.substring(3, 5);

                        String durationT = duration_11 + duration_12;

                        duration_2 = Integer.parseInt(durationT);}

                    catch (Exception e) {

                        //duration = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[1]")).getText();

                        String duration_11 = duration.substring(0, 2);

                        String zero = "0";

                        String duration_12 = duration.substring(4, 5);

                        duration = duration_11 + zero + duration_12;

                        duration_2 = Integer.parseInt(duration);
                    }

                }

                else {

                    String duration_11 = duration.substring(0, 2);

                    String duration_12 = duration.substring(4, 6);

                    duration = duration_11 + duration_12;

                    duration_2 = Integer.parseInt(duration);}}

        }}

        return duration_2;}

    public int sort_days_2 (String duration) {

        if (duration.length() == 2) {

            String duration1 = duration.substring(0, 1);

            String zero1 = "0";

            duration = duration1 + zero1 + zero1 + zero1 + zero1;

            duration_2 = Integer.parseInt(duration);

        }

        else {

        if (duration.length() == 5) {

            String duration1 = duration.substring(0, 1);

            String zero1 = "0";

            String duration2 = duration.substring(3, 4);

            if (duration.contains("h")){

                duration = duration1 + zero1 + duration2 + zero1 + zero1;

                duration_2 = Integer.parseInt(duration);}

            else {

                duration = duration1 + zero1 + zero1 + zero1 + duration2;

                duration_2 = Integer.parseInt(duration);

            }

        }

        else {


            if (duration.length() == 8) {

                String duration1 = duration.substring(0, 1);

                String zero1 = "0";

                String duration2 = duration.substring(3, 4);

                String duration3 = duration.substring(6, 7);

                duration = duration1 + zero1 + duration2 + zero1 + duration3;

                duration_2 = Integer.parseInt(duration);


            }

            else {

                if (duration.length() == 6) {

                    String duration1 = duration.substring(0, 1);

                    String zero1 = "0";

                    String duration2 = duration.substring(3, 5);

                    if (duration.contains("h")){

                        duration = duration1 + duration2 + zero1 + zero1;

                        duration_2 = Integer.parseInt(duration);}

                    else { duration = duration1 + zero1 + zero1 + duration2;

                        duration_2 = Integer.parseInt(duration);}

                }

                else {

                    if (duration.length() == 9) {

                        try {

                            String duration1 = duration.substring(0, 1);

                            String zero1 = "0";

                            String duration2 = duration.substring(3, 4);

                            String duration3 = duration.substring(6, 8);

                            String durationT = duration1 + zero1 + duration2 + duration3;

                            duration_2 = Integer.parseInt(durationT);}

                        catch (Exception e) {

                            //duration = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[" + i + "]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[1]")).getText();

                            String duration1 = duration.substring(0, 1);

                            String zero1 = "0";

                            String duration2 = duration.substring(3, 5);

                            String duration3 = duration.substring(7, 8);

                            duration = duration1 + duration2 + zero1 + duration3;

                            duration_2 = Integer.parseInt(duration);
                        }

                    }

                    else {

                        String duration1 = duration.substring(0, 1);

                        String duration2 = duration.substring(3, 5);

                        String duration3 = duration.substring(7,9);

                        duration = duration1 + duration2 + duration3;

                        duration_2 = Integer.parseInt(duration);}}

            }}}

        return duration_2;}

}

