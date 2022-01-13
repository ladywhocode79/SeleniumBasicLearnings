package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class SortWebTableUsingJavaStreams {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //click on column to sort the table lists
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //get all values of first columns into a list
        List<WebElement> vegetablesList = driver.findElements(By.xpath("//tr/td[1]"));
        //get values of these web elements into lists
        List<String> originalVegetableLists=vegetablesList.stream().map(s->s.getText()).collect(Collectors.toList());
        //sort original list from web table
        List<String> sortedVegetableLists=originalVegetableLists.stream().sorted().collect(Collectors.toList());
        //compare original list and sorted list to verify if lists are sorted in web table
        Assert.assertEquals(originalVegetableLists,sortedVegetableLists);
        driver.close();



    }
}
