package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
    }

    @Test
    public void verifyChildWindow() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.cssSelector(".blinkingText")).click();


        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        String email = driver.switchTo().window(childId).findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split("with")[0];

        System.out.println(email);
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);

    }

    @AfterMethod
    public void teardown() {
        //driver.quit();
    }
}
