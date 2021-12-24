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

    }
}
