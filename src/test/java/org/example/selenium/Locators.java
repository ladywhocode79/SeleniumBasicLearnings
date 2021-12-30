package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) {
        //user Signuup
        System.setProperty("webdriver.chrome.driver","src/test/driver/chromedriver 2");
        WebDriver driver = new ChromeDriver();
        //Implicit wait-globally applicable to everything in a testcase
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://spree-vapasi-prod.herokuapp.com/signup");
        String email = "test28@testapp.com";
        String password = "123456";
        driver.findElement(By.id("spree_user_email")).sendKeys(email);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys(password);
        driver.findElement(By.name("commit")).click();

        //for link tags,pass text of the links
       // driver.findElement(By.linkText()).click();

        //Xpath -> //Tagname[@attribute='value']
        // eg //input[@placeholder='email']

        //CSS -> Tagname[attribute='value']
        // eg input[placeholder='email']

        //to clear the value of testbox
        // driver.findElement(By.id("spree_user_password")).clear();

        //to get value from element of browser
        //driver.findElement(By.name("commit")).getText();

        //to identify element from list of elements with same attribute values we use index,applicable only for xpath and not css
        //eg->//Tagname[@attribute = 'value'][index=1 or 2or 3 or any number]

        //for css we use following format
        //eg tagname[attribute='value']:nth-child(index)
        //ideally we should use unique value and avoid index values

        //traverse to an element using tag names of parent and child using xpath
        // eg -> //parent tagname/childtagname
        //eg -> //parent tagname/childtagname[index]

        //identify element using css .classname
        //eg-> driver.findElement(By.cssSelector(".reset_btn_name"));

        //traverse to an element using tag names of parent and child using css
        //        // eg -> parent tagname childtagname
        //        //eg -> parent tagname childtagname[index]

        //generate css using id
        //eg driver.findElement(By.cssSelector('#spree_user_password'));

        //Regular expression CSS - * is a regular experession matches all elements
        //eg css -> input[type*='pass']=>will match all elements starting with pass static word

        //Regular expression Xpath - *
        //eg css -> //button[contains(@class,'submit')]=>will match all elements starting with pass static word

        //paremt child xpath with index
        //eg //div[@class='forgot-pwd-btn-class']//button[1]

        //if there is a single tag then use locator tagnname
       //    driver.findElement(By.tagName("p"));

        /*// Sibling - Child to parent traverse

        //header/div/button[1]/following-sibling::button[1]

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());


*/


        /*==code samples from couurse
        import java.time.Duration;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;





public class org.example.selenium.Locators {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//implicit wait - 2 seconds time out

System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

WebDriver driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

driver.get("https://rahulshettyacademy.com/locatorspractice/");

driver.findElement(By.id("inputUsername")).sendKeys("rahul");

driver.findElement(By.name("inputPassword")).sendKeys("hello123");

driver.findElement(By.className("signInBtn")).click();

System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

driver.findElement(By.linkText("Forgot your password?")).click();

Thread.sleep(1000);//

driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

System.out.println(driver.findElement(By.cssSelector("form p")).getText());

driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

Thread.sleep(1000);

driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

driver.findElement(By.id("chkboxOne")).click();

driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

}



}
        * */

    }
}
