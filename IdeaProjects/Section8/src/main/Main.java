package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.html.HTMLDocument;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {

        // 1. Get count of links on the page
        WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = new FirefoxDriver();
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        }

        @Test(priority = 1)
        public void getLinksCount() {
            List<WebElement> linksList = driver.findElements(By.tagName("a"));
            System.out.println("Number of links: " + linksList.size());
        }

        @Test(priority = 2)
        public void getFooterLinksCount() {
            WebElement footerWebElement = driver.findElement(By.cssSelector("div[class*='footer']"));

            List<WebElement> footerLinksList = footerWebElement.findElements(By.tagName("a"));

            System.out.println("Footer links count: " + footerLinksList.size());

        }

        @Test(priority = 3)
        public void getFooterFirstColumnLinksCount() {
            WebElement footerDriver = driver.findElement(By.cssSelector("div[class*='footer']"));

            WebElement columnDriver = footerDriver.findElement(By.cssSelector("tr td:nth-child(1)"));

            List<WebElement> firstColumnLinks = columnDriver.findElements(By.tagName("a"));

            for (int i = 0; i < firstColumnLinks.size(); i++) {

                String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);

                firstColumnLinks.get(i).sendKeys(clickLink);

            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Get window handles
            Set<String> windowHandles = driver.getWindowHandles();

            // Iterator on the window handles
            Iterator<String> it = windowHandles.iterator();

            // Move to first window
            it.next();

            int count = 0;

            while (it.hasNext()) {
                driver.switchTo().window(it.next());
                System.out.println("Window N" + (++count) + " Title: " + driver.getTitle());
            }

        }

        @AfterMethod
        public void tearDown() {
            //driver.quit();
        }
}