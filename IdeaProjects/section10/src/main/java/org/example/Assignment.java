package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Assignment {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void handleMultipleWindows() {
        // Go to MultipleWindows link
        WebElement multipleWindowsElement = driver.findElement(By.cssSelector("a[href='/windows']"));
        multipleWindowsElement.click();

        // Open Child window
        WebElement childWindowLink = driver.findElement(By.cssSelector("a[href='/windows/new']"));
        childWindowLink.click();

        // Get Window handles
        Set<String> windows = driver.getWindowHandles();

        // Iterator to iterate through windows
        Iterator<String> it = windows.iterator();

        // Windows ID's
        String parentWindowId = it.next();
        String childWindowId = it.next();

        // Switch to Child window
        driver.switchTo().window(childWindowId);

        // Get text and print it
        String childWindowText = driver.findElement(By.cssSelector(".example")).getText();
        System.out.println("Child Window: " + childWindowText);

        // Switch to Parent id and get text
        driver.switchTo().window(parentWindowId);
        String parentWindowText = driver.findElement(By.cssSelector("div.example > h3")).getText();
        System.out.println("Parent Window: " + parentWindowText);

    }


    @AfterMethod
    public void teardown() {
         driver.quit();
    }
}
