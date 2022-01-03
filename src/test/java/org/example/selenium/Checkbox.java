package org.example.selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
      /*  driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");

        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        int countOfCheckBox = 6;
        Assert.assertEquals(countOfCheckBox,driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        driver.close();
*/
        //assignment
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue( driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

        int countOfCheckBox = 3;
        Assert.assertEquals(countOfCheckBox,driver.findElements(By.cssSelector("input[name *= 'checkBoxOption']")).size());
        driver.close();



    }
}
