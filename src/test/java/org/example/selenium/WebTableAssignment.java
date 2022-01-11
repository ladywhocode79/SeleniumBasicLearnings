package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class WebTableAssignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //browser scroll
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
       /* //table scroll
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");*/

        //sum of values of a column
        int actualNoOfRows=0;
        int expectedNoOfRows = 11;
        actualNoOfRows = driver.findElements(By.cssSelector("table[name='courses'] tr")).size();
        Assert.assertEquals(actualNoOfRows,expectedNoOfRows);
        int actualNoOfColumns=0;
        int expectedNoOfColumns = 3;
        actualNoOfColumns = driver.findElements(By.cssSelector("table[name='courses'] th")).size();
        Assert.assertEquals(actualNoOfColumns,expectedNoOfColumns);
        String actualThirdRowValues="";
        String expectedThirdRowValues="Rahul Shetty Learn SQL in Practical + Database Testing from Scratch 25";

        List<WebElement> rowValues= driver.findElements(By.cssSelector("table[name='courses'] tr"));
        actualThirdRowValues =rowValues.get(2).getText();
        Assert.assertEquals(actualThirdRowValues,expectedThirdRowValues);

        driver.close();

        /*WebElement table=driver.findElement(By.id("product"));
        System.out.println(table.findElements(By.tagName("tr")).size());
        System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
        List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
        System.out.println(secondrow.get(0).getText());
        System.out.println(secondrow.get(1).getText());
        System.out.println(secondrow.get(2).getText());
        * */
    }
}
