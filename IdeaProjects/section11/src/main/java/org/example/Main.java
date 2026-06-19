package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
            WebElement footerWebElement = driver.findElement(By.cssSelector("div[class*='footer']"));

            WebElement firstColumn = footerWebElement.findElement(By.cssSelector("tr td:nth-child(1)"));

            List<WebElement> firstColumnLinks = firstColumn.findElements(By.tagName("a"));

            System.out.println("First column links count: " + firstColumnLinks.size());
        }

        @AfterMethod
        public void tearNika() {
            driver.quit();
        }
}