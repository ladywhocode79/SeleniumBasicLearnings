package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SearchFlightEndToEndTestcase {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        //click on Departure city lst box
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        //select Departure city
        //reaching child with multiple elements having same value using parent child relationship xpath
        String departureCity = "BHO";
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='"+departureCity+"']")).click();
        Thread.sleep(2000);

        //select Destination city
        String destinationCity = "JAI";
        driver.findElement(By.xpath(" //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='"+destinationCity+"']")).click();

        //select current highlighted date from Departure Date calender
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        //       Return Date calender is disabled
         Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"));

         //Family and Friends Checkbox is selected
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());

        //Select number eg 5 of adults from the dropdown and by default 1 is selected
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        int i =1;
        while (i<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        //click on done
        driver.findElement(By.id("btnclosepaxoption")).click();
        String expectedCountOfAdult = "5 Adult";
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),expectedCountOfAdult);

        //select the Currency as USD
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select selectDropDown = new Select(staticDropDown);
        selectDropDown.selectByIndex(3);
        String expectedCurrency = "USD";
        Assert.assertEquals(selectDropDown.getFirstSelectedOption().getText(),expectedCurrency);

        //Click on Search
        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();



    }

}
