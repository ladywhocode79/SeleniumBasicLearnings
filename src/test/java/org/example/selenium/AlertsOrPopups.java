package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AlertsOrPopups {
    public static void main(String[] args) {
        String text = "sonal";
        String expectedOkAlertString="Hello sonal, share this practice page and share your knowledge";
        String expectedOKCancelStrings ="Hello sonal, Are you sure you want to confirm?";

        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);

        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(),expectedOkAlertString);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(),expectedOKCancelStrings);
        driver.switchTo().alert().dismiss();

        driver.close();

    }
}
