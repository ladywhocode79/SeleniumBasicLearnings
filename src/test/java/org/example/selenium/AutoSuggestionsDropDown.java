package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestionsDropDown {
    public static void main(String[] args) throws InterruptedException {
        String inputValue = "bru";
        String searchedString = "Brunei Darussalam";
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.findElement(By.id("autosuggest")).sendKeys(inputValue);
        Thread.sleep(5000);
       // List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        Thread.sleep(5000);
        for(WebElement option :options) {

            if (option.getText().equalsIgnoreCase(searchedString)) {

                option.click();

                break;

            }
        }
       // System.out.println(driver.findElement(By.id("autosuggest")).getText());


    }
}
