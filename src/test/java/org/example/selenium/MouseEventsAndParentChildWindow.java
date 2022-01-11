        package org.example.selenium;

        import java.util.Iterator;

        import java.util.Set;

        import org.checkerframework.checker.units.qual.A;
        import org.openqa.selenium.By;

        import org.openqa.selenium.WebDriver;

        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;

        import javax.swing.*;

        public class MouseEventsAndParentChildWindow {
            public static void main(String[] args) {
                System.setProperty("webdriver.chrome.driver", "src/test/driver/chromedriver 2");

                WebDriver driver = new ChromeDriver();

                driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

                driver.findElement(By.cssSelector(".blinkingText")).click();

                Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

                Iterator<String> it = windows.iterator();

                String parentId = it.next();

                String childId = it.next();

                driver.switchTo().window(childId);

                System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

                driver.findElement(By.cssSelector(".im-para.red")).getText();

                String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

                driver.switchTo().window(parentId);

                driver.findElement(By.id("username")).sendKeys(emailId);
              /*Right click
              Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement()).contextClick().build().perform();*/

                /*enter text ‘Hello’ in capital letters help of actions class in Selenium
                 Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement()).click().keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
                * */
                driver.close();

            }
        }
