package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class PaginationWithStreams {
    public static void main(String[] args) {
        //customize method for selenium using streams
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


        //scan the name of column with getText->Rice->print the price of Rice
        List<String> getProductPrice;
        String expectedVegetablePrice = "37";

        do {
            //if Rice is not found on a page,click next using if condition,do check Rice on
            //first page,if found getProductPrice String size will be incremented
            //else using if condition click on next and again come into do while loop
            //to grab all lists elements on a page.

            List<WebElement> productList = driver.findElements(By.xpath("//tr/td[1]"));
            getProductPrice = productList.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceForProduct(s)).collect(Collectors.toList());
            // System.out.println(getProductPrice);


            //if Rice not found,then click on next
            if(getProductPrice.size()<1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();

            }
        }while (getProductPrice.size()<1);
        //if found then verify the value
        Assert.assertEquals(getProductPrice.get(0), expectedVegetablePrice);
        driver.close();

    }

    private static String getPriceForProduct(WebElement s) {
        String price= s.findElement(By.xpath("following-sibling::td[1]")).getText();
        //  System.out.println(price);
        return price;
    }
}
