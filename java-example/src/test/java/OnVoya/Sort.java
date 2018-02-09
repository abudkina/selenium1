package OnVoya;

        import  org.junit.After;
        import org.junit.Before;
        import org.testng.annotations.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.util.concurrent.TimeUnit;

        import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
        import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
        import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class Sort {

 private WebDriver driver;
    private WebDriverWait wait;


    @Test
    public void Sort() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 30);

        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-04&Return=2018-03-08&Adult=1&Child=1&Ref=WF1");
        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));
        detailsOpened(driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[2]/div")));

       //SORTING

        //1 price range

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[1]/label")).click();

        sortRangePrice(driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[1]/label/span[1]/em[1]")),
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/span"))); //1 range is selected

        //check price 1 - 5 - 10 - 15 fares

        sortPrice();

        //2 price range

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[2]/label")).click();

        sortRangePriceAfter(driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[2]/label/span[1]/em[1]")), //first price
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/span"))); // first fare

        //check price 1 - 5 - 10 - 15 fares

        sortPrice();

//        //3 range price

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[2]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[3]/label")).click();
        sortRangePriceAfter( driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[3]/label/span[1]/em[1]")), //first price
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/span"))); // first fare

        //check price 1 - 5 - 10 - 15 fares

        sortPrice();

        // 4 range price
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[3]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[4]/label")).click();
        sortRangePriceAfter(driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[4]/label/span[1]/em[1]")), //first price
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/span"))); // first fare

        //check price 1 - 5 - 10 - 15 fares

        sortPrice();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[4]/label")).click();
        //check price 1 - 5 - 10 - 15 fares

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();
        sortAirlines(driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/ul/li[4]/label/span[1]")));

        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    private void detailsOpened (WebElement a) {

        a.click();
        System.out.println("Details are opened");}

    private void SortStops_1 () {

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[2]/label/span[1]")).click();


        String firstStop = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[1]/div/div/div[1]/div[3]/div[2]")).getText();
        int firstNumber = Integer.parseInt(firstStop);

    }

    private void fareRules() { // доделать!

        driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div[2]/div[2]/div/div[5]/a")).click(); // fare rules are opened - работает
        driver.findElement(By.xpath("//*[@id=\"fareRulesPopup\"]/div[3]/a")).click();// закрыть fare rules - не работает / frame ?
        System.out.println("Fare rules are opened");}

    private void sortRangePrice(WebElement range, WebElement fare) { // проверяет совпадает ли ранг каждой цены с отображением fares

        String minPrice1 = range.getText();
        int minPrice = Integer.parseInt(minPrice1);
        String minFare1 = fare.getText();
        int minFare = Integer.parseInt(minFare1);
        if (minFare == minPrice ) {System.out.println("Min Prices equals: " + " MinPrice = " + minPrice + " Min Fare = " + minFare); }
        else {System.out.println("*****Min prices are not equal");}

    }

    private void sortRangePriceAfter(WebElement range, WebElement fare) { // проверяет совпадает ли ранг каждой цены с отображением fares

        String minPrice1 = range.getText();
        int minPrice = Integer.parseInt(minPrice1);
        String minFare1 = fare.getText();
        int minFare = Integer.parseInt(minFare1);
        if (minFare >= minPrice ) {System.out.println("Min Prices equals: " + " MinPrice = " + minPrice + " Min Fare = " + minFare); }
        else {System.out.println("*****Min prices are not equal");}
    }

    private void sortPrice () {

        String firstFareS = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/span")).getText();
        int firstFare = Integer.parseInt(firstFareS);
        String fivethFareS = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[5]/div/div/div[1]/div[2]/div[1]/div[1]/span")).getText();
        int fivethFare = Integer.parseInt(fivethFareS);
        String tenthFareS = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[10]/div/div/div[1]/div[2]/div[1]/div[1]/span")).getText();
        int tenthFare = Integer.parseInt(tenthFareS);
        String fifteenthFareS = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[15]/div/div/div[1]/div[2]/div[1]/div[1]/span")).getText();
        int fifteenFare = Integer.parseInt(fifteenthFareS);
        if ((firstFare <= fivethFare) && (fivethFare <= tenthFare) && (tenthFare <= fifteenFare))
        {System.out.println("Sort Price working: " + "1 = " + firstFare + " 5 = " + fivethFare + " 10 = " + tenthFare + " 15 = " + fifteenFare); }
        else {System.out.println("*****Sort price is not working");}}

    private void sortAirlines(WebElement a) {

        String airline = a.getText();
        String firstAirline = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[1]/div/div/div[1]/div[1]/div/ul/li[2]")).getText();
        String firstAirline_2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[1]/div/div/div[3]/div[1]/div/ul/li[2]")).getText();
        String secondAirline = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[5]/div/div/div[1]/div[1]/div/div/div[1]/div[1]/div/ul/li[2]")).getText();
        String secondAirline_2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[5]/div/div/div[1]/div[1]/div/div/div[3]/div[1]/div/ul/li[2]")).getText();
        String thirdAirline = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[10]/div/div/div[1]/div[1]/div/div/div[1]/div[1]/div/ul/li[2]")).getText();
        String thirdAirline_2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[10]/div/div/div[1]/div[1]/div/div/div[3]/div[1]/div/ul/li[2]")).getText();
        String fourthAirline = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[15]/div/div/div[1]/div[1]/div/div/div[1]/div[1]/div/ul/li[2]")).getText();
        String fourthAirline_2 = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[15]/div/div/div[1]/div[1]/div/div/div[3]/div[1]/div/ul/li[2]")).getText();
        if ((firstAirline.equals(secondAirline)) && (firstAirline_2.equals(secondAirline_2)) && (thirdAirline.equals(fourthAirline)) && (thirdAirline_2.equals(fourthAirline_2))
                &&(thirdAirline_2.equals(fourthAirline_2)) && (secondAirline.equals(thirdAirline)) && (airline.equals(firstAirline)) ){

            System.out.println("Sort Airline working: " + "1 - " + firstAirline + " 5 - " + secondAirline + " 10 - " + thirdAirline + " 15 - " + fourthAirline);
            //else {System.out.println("*****Sort Airline is not working");}
        }
        else {System.out.println(" Sorting is not working");}
    }
}


