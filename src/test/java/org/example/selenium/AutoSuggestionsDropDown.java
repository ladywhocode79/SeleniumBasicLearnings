package org.example.selenium;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestionsDropDown {
    public static void main(String[] args) throws InterruptedException {
        String inputValue = "bra";
        String searchedString = "Brazil";
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        driver.findElement(By.id("autosuggest")).sendKeys(inputValue);
        Thread.sleep(5000);


        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> options = (List<WebElement>) wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='ui-menu-item'] a")));*/
       List<WebElement> options =driver.findElements(By.xpath("//*[@class=\"ui-menu-item\"]/a"));

        for(WebElement option :options) {

            if (option.getText().equalsIgnoreCase(searchedString)) {
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("arguments[0].click()", option);
                Thread.sleep(2000);
                option.click();
               // option.sendKeys(Keys.ENTER);

                break;

            }
        }

        driver.close();
    }
}
