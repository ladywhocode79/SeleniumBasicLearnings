package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchFilterUsingStream {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //eneter value as Rice in search field
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        //get the lists into a searched lists
        List<WebElement> searchedResultList = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredLists = searchedResultList.stream().
                filter(searchedProduct->searchedProduct.getText().contains("Rice"))
                .collect(Collectors.toList());
        Assert.assertEquals(searchedResultList.size(),filteredLists.size());
        driver.close();


    }
}
