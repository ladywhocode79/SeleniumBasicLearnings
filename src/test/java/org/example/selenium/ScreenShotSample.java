package org.example.selenium;

import org.apache.commons.io.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

public class ScreenShotSample {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());

        File dest = new File("src/test/screenshot/screenshot"+fileName+".png");
        FileUtils.copyFile(src,dest );
        driver.close();
    }
}
