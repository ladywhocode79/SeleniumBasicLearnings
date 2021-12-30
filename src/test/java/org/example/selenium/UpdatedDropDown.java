package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdatedDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        int i =1;
        while (i<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.close();





    }
}
