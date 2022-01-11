package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarAdvancedSample {
    public static void main(String[] args) {
        String userSelectedDate ="23";
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.findElement(By.xpath(".//[@id='travel_date']")).click();
        //select month as April
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")){
            driver.findElement(By.cssSelector("[class='datepicker-days] th[class='next']")).click();
        }
        //use common locator/attribute used across the calendar for dates
        List<WebElement>calendarDates=driver.findElements(By.className("day"));
        int countOfDays = calendarDates.size();

        for(int i=0;i<countOfDays;i++){
            String calendarDate = calendarDates.get(i).getText();
            if(calendarDate.equalsIgnoreCase(userSelectedDate)){
                calendarDates.get(i).click();
            }
        }
    }
}
