package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDowns {
    public static void main(String[] args) {
        //user Signuup
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select selectDropDown = new Select(staticDropDown);
        selectDropDown.selectByIndex(3);
        System.out.println(selectDropDown.getFirstSelectedOption().getText());
        selectDropDown.selectByValue("AED");
        System.out.println(selectDropDown.getFirstSelectedOption().getText());
        selectDropDown.selectByVisibleText("INR");
        System.out.println(selectDropDown.getFirstSelectedOption().getText());
        driver.close();
    }
}
