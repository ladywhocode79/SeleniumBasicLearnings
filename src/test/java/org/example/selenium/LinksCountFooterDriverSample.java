package org.example.selenium;

import io.netty.buffer.ByteBufProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.*;

public class LinksCountFooterDriverSample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        //get count of a tags or links on a page
        System.out.println("Count of tags on a page : "+driver.findElements(By.tagName("a")).size());

        //get count of a tags or links in footer of a page
        //limiting scope of webdriver
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println("Count of tags on footer of  page : "+ footerDriver.findElements(By.tagName("a")).size());

        //get count of first column links
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int countOfLinksinFirstColumn=columnDriver.findElements(By.tagName("a")).size();
        System.out.println("Count of tags in first column of footer of  page : "+ countOfLinksinFirstColumn);

        //Click and enter control to open link in seperate tab or command and enter
            String clickAndEnterToOpenLink = Keys.chord(Keys.COMMAND,Keys.ENTER);

        WebDriverWait w =new WebDriverWait(driver,5);
        //check if links are working
     List<String> actualWindowTitles=new ArrayList<>();
        for(int i=1;i<countOfLinksinFirstColumn;i++){
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickAndEnterToOpenLink);
           // w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
            Thread.sleep(5000);

        }
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();

        while (it.hasNext()){
            driver.switchTo().window(it.next());
            actualWindowTitles.add(driver.getTitle());

        }
        //get count of windows and verify names of windows
        int actualClickWindowCounts = driver.getWindowHandles().size(); //[parentid,childid,subchildId]
        int expectedClickWindowCount =4;
        Assert.assertEquals(actualClickWindowCounts,expectedClickWindowCount);

      List<String>expectedWindowNames = new ArrayList<String>(Arrays.asList("Practice Page",
              "REST API Tutorial",
                "The World's Most Popular API Testing Tool | SoapUI",
                "Appium Mobile Automation Testing from Scratch + Frameworks Tutorial | Udemy",
                "Apache JMeter Apache JMeter™"));
        for(int i=1;i<expectedWindowNames.size();i++)
            Assert.assertEquals(actualWindowTitles.get(i),expectedWindowNames.get(i));

        driver.quit();
    }
}
