package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinksSample {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert a = new SoftAssert();

        List<WebElement> listOfLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for(WebElement link : listOfLinks){
            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int actualResponseCode = connection.getResponseCode();
            int expectedResponseCode = 404;
            //hard assert
          /* Assert.assertTrue(actualResponseCode<400,"The link with Text "+link.getText()+
                        " is broken with code "+actualResponseCode);*/
           //soft assert
            a.assertTrue(actualResponseCode<400,"The link with Text "+link.getText()+
                    " is broken with code "+actualResponseCode);




        }
        //it will report all the links result including failure
        a.assertAll();
       /* //a[href*='soapui']
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        int actualResponseCode = connection.getResponseCode();
        int expectedResponseCode = 404;
        Assert.assertEquals(actualResponseCode,expectedResponseCode);
       */ driver.close();
    }
}
