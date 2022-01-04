package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FlightAssignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //click on calendar
        driver.findElement(By.cssSelector("button[class='flex flex-middle flex-between t-all " +
                "fs-2 focus:bc-secondary-500 " +
                "bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']")).click();
        //select current date
        driver.findElement(By.cssSelector("div[class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today']")).click();
        //update adult and child count
        WebElement staticAdultDropDown = driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[1]"));
        Select selectAdultDropDown = new Select(staticAdultDropDown);
        selectAdultDropDown.selectByIndex(3);

        WebElement staticChildDropDown = driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[2]"));
        Select selectChildDropDown = new Select(staticChildDropDown);
        selectChildDropDown.selectByIndex(2);

        WebElement staticInfantDropDown = driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[2]"));
        Select selectInfantDropDown = new Select(staticInfantDropDown);
        selectInfantDropDown.selectByIndex(1);

        //click on class of travel
        String searchedAirlineName = "air";
        driver.findElement(By.linkText("More options: Class of travel, Airline preference")).click();
        driver.findElement(By.cssSelector("input[placeholder='Airline name']")).sendKeys(searchedAirlineName);
        List<WebElement> optionsAirlines =driver.findElements(By.xpath("//*[@class='to-ellipsis o-hidden ws-nowrap c-inherit fs-3']"));
        for(WebElement options:optionsAirlines){
            if(options.getText().equalsIgnoreCase("AIS Airlines (IS)")){
                options.click();
            }
        }
    driver.close();

    }
}
