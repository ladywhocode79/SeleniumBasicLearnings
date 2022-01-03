package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();


       /* driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        //reaching child with multiple elements having same value using index
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();*/

        //reaching child with multiple elements having same value using parent child relationship xpath
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
        //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
        Thread.sleep(2000);
        driver.findElement(By.xpath(" //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']




        driver.close();
    }
}
