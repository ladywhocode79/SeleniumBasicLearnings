package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("div[id='start'] button")).click();

        Wait<WebDriver> fluentWait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
        WebElement webElement = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                if(driver.findElement(By.cssSelector("div[id='finish'] h4 ")).isDisplayed()) {
                    return driver.findElement(By.cssSelector("div[id='finish'] h4 "));
                }
                return null;
            }
        });
        String expectedString = "Hello World!";
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish'] h4 ")).getText(),expectedString);
        driver.close();

    }
}
