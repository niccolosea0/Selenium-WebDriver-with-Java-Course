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

        // Login name
        String name = "John";
        String password = getPassword(driver);
        Assert.assertEquals(password, "rahulshettyacademy");

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='pass'")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.cssSelector("input[name='chkboxTwo']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();


        Thread.sleep(2000);
        String successText = driver.findElement(By.tagName("p")).getText();
        System.out.println("Successfully logged in text: " + successText);

        Assert.assertEquals(successText, "You are successfully logged in.");
        String greetingMessage = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        System.out.println("greeting message: " + greetingMessage);
        Assert.assertEquals(greetingMessage, "Hello " + name + ",");

        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
    }

    private static String getPassword(WebDriver driver) throws InterruptedException {


        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordTextArr = passwordText.split("'");
        String password = passwordTextArr[1].split("'")[0];

        return password;
    }
}
