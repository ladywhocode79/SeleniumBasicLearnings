package org.example.selenium;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();



        //reaching child with multiple elements having same value using parent child relationship xpath
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(" //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();


        //select current highlighted date from calender
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
       // driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        //click on Roound Trip Radio button
        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();

        //check if return date is enabled on Round trip  radio button click
        Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));

        //click on one way again and check that return date is disabled
        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_0']")).click();
        Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"));




        //driver.close();
    }

}
