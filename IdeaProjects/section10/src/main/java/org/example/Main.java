package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {
        WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.get("https://www.amazon.com/");
        }

        @Test
        public void testMouseHover() {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            Actions a = new Actions(driver);

            WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
            WebElement accountLists = driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));

            a.moveToElement(searchInput).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
            Assert.assertEquals("HELLO", searchInput.getAttribute("value"));

            a.moveToElement(accountLists).contextClick().build().perform();

        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
}