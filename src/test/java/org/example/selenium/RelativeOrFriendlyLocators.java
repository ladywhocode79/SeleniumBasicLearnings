package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeOrFriendlyLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
       String label = driver.findElement(with(By.tagName("label")).above(name)).getText();
        //System.out.println(label);

        WebElement dateOfBirth = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();

        WebElement labelAfterCheckBox= driver.findElement(By.cssSelector("label[for=\"exampleCheck1\"]"));
        driver.findElement(with(By.tagName("input")).toLeftOf(labelAfterCheckBox)).click();

        WebElement labelBeforeRadioButton= driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(labelBeforeRadioButton)).getText());
        driver.close();
    }
}
