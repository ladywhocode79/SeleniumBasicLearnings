package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class ParentChildWindowSwitchSample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        String expectedChildMessage = "New Window";
        String actualChildMessage = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        Assert.assertEquals(actualChildMessage,expectedChildMessage);
        driver.switchTo().window(parentId);
        String expectedParentMessage = "Opening a new window";
        String actualParentMessage = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        Assert.assertEquals(actualParentMessage,expectedParentMessage);
        driver.quit();


    }
}
