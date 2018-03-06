package OnVoya;

        import  org.junit.After;
        import org.junit.Before;
        import org.testng.Assert;
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
    int length;
    String a;

    @Test
    public void Sort() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, 90);

        driver.navigate().to("https://www.onvoya.com/flights/search?From=LAX&To=BOS&Class=E&Departure=2018-03-20&Return=2018-03-30&Adult=1&Child=1&Ref=WF1");
        WebElement new1 = driver.findElement(By.id("resultMask"));
        wait.until(invisibilityOf(new1));
        detailsOpened(driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[2]/div")));

       //SORTING

        //1 price range

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[1]/label")).click();

        a = driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[1]/label/span[2]")).getText();
        length = Integer.parseInt(a);
        if (length<25) {length = Integer.parseInt(a)-1;}
        else {length = 25-1;}

        sortRangePrice(driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[1]/label/span[1]/em[1]")),
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/span"))); //1 range is selected

        //check price 1 - 5 - 10 - 15 fares

        sortPrice();

        //2 price range

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[2]/label")).click();

        a = driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[2]/label/span[2]")).getText();
        length = Integer.parseInt(a);
        if (length<25) {length = Integer.parseInt(a)-1;}
        else {length = 25-1;}

        sortRangePriceAfter(driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[2]/label/span[1]/em[1]")), //first price
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/span"))); // first fare

        //check price 1 - 5 - 10 - 15 fares

        sortPrice();

        //3 range price

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[2]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[3]/label")).click();

        a = driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[3]/label/span[2]")).getText();
        length = Integer.parseInt(a);
        if (length<25) {length = Integer.parseInt(a)-1;}
        else {length = 25-1;}

        sortRangePriceAfter( driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[3]/label/span[1]/em[1]")), //first price
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/span"))); // first fare

        //check price 1 - 5 - 10 - 15 fares

        sortPrice();

        // 4 range price
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[3]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[4]/label")).click();

        a = driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[4]/label/span[2]")).getText();
        length = Integer.parseInt(a);
        if (length<25) {length = Integer.parseInt(a)-1;}
        else {length = 25-1;}

        sortRangePriceAfter(driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[4]/label/span[1]/em[1]")), //first price
                driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div[1]/div/div/div[1]/div[2]/div[1]/div[1]/span"))); // first fare

        //check price 1 - 5 - 10 - 15 fares

        sortPrice();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[1]/div/div[2]/div[1]/ul/li[4]/label")).click();
        //check price 1 - 5 - 10 - 15 fares

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();
        sortAirlines(driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/ul/li[4]/label/span[1]")));

        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/ul/li[4]/label/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/ul/li[1]/label/span[1]")).click();

        sortAirlines(driver.findElement(By.xpath("//*[@id=\"filter\"]/div/div[1]/div/div[3]/div/div[2]/div[1]/ul/li[1]/label/span[1]")));

        wait.until(titleIs("Search, Find, Book and Save on Flights - OnVoya"));

    }

    private void detailsOpened (WebElement a) {

        a.click();
        System.out.println("Details are opened");}

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

        for (int i=1;i<length;i++){

            String firstFareS = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[2]/div[1]/div[1]/span")).getText();
            int firstFare = Integer.parseInt(firstFareS);
            String secondFareS = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+(i+1)+"]/div/div/div[1]/div[2]/div[1]/div[1]/span")).getText();
            int secondFare = Integer.parseInt(secondFareS);

            if (secondFare >= firstFare)
            {System.out.println("Sort Price working " + firstFare + " " + secondFare); }
            else {System.out.println("*****Sort price is not working");
                Assert.assertEquals("111", driver.getTitle());}}
    }

    private void sortAirlines(WebElement a) {

        String airline = a.getText();

        for (int i=1;i<=20;i++){

            String firstAirline = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[1]/div[1]/div/ul/li[2]")).getText();
            String secondAirline = driver.findElement(By.xpath("//*[@id=\"itineraries\"]/div["+i+"]/div/div/div[1]/div[1]/div/div/div[3]/div[1]/div/ul/li[2]")).getText();

            if ((airline.equals(secondAirline)) || (airline.equals(firstAirline))){

                System.out.println("Sort Airline working " + firstAirline + " " + secondAirline);
            }
            else {System.out.println("Sorting is not working");
                Assert.assertEquals("111", driver.getTitle());}
        }
    }}

