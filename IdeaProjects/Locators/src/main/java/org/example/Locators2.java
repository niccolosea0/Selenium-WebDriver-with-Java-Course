package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;


public class Locators2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("John");
        driver.findElement(By.cssSelector("input[type*='pass'")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.cssSelector("input[name='chkboxTwo']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();


        Thread.sleep(2000);
        String successText = driver.findElement(By.tagName("p")).getText();
        System.out.println("Successfully logged in text: " + successText);

        Assert.assertEquals(successText, "You are successfully logged in.");
    }
}
