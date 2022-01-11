package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class BrowserAndTableScrolling {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //browser scroll
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        //table scroll
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        //sum of values of a column
        int actualsum=0;
        int expectedSum = 296;
        List<WebElement> columnValues = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        for(int i=0;i<columnValues.size();i++){
            actualsum=actualsum+Integer.parseInt(columnValues.get(i).getText());
        }
        Assert.assertEquals(actualsum,expectedSum);

        //compare actual value captured with value on screen
        int capturedSumValue=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).
                getText().split(":")[1].trim());

        Assert.assertEquals(capturedSumValue,expectedSum);

        driver.close();

    }
}
