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



        @AfterMethod
        public void tearNika() {
            driver.quit();
        }
}