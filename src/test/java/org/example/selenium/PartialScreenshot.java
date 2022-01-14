package org.example.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class PartialScreenshot {

        public static void main(String[] args) throws IOException {
            System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/angularpractice/");
            // driver.switchTo().newWindow(WindowType.TAB);
            driver.switchTo().newWindow(WindowType.WINDOW);
            Set<String> handles = driver.getWindowHandles();
            Iterator<String> it = handles.iterator();
            String parentId = it.next();
            String childId = it.next();
            driver.switchTo().window(childId);
            driver.get("https://rahulshettyacademy.com/#/index");
            String courseName = driver.findElements(By.cssSelector("a[href=\"https://courses.rahulshettyacademy.com/p/" +
                    "core-java-for-automation-testers-interview-programs\"]")).get(1).getText();
            driver.switchTo().window(parentId);
            WebElement name = driver.findElement(By.cssSelector("[name='name']"));
            name.sendKeys(courseName);

            //partial screenshot
            File file =name.getScreenshotAs(OutputType.FILE);
            String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
            FileUtils.copyFile(file, new File("src/test/screenshot/partialscreenshot"+fileName+".png"));

            driver.quit();


        }
    }


