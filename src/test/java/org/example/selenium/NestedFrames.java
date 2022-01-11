package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class NestedFrames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        String actualMessage = driver.findElement(By.id("content")).getText();
        String expectedMessage = "MIDDLE";
        Assert.assertEquals(actualMessage,expectedMessage);

        driver.close();


    }
}
