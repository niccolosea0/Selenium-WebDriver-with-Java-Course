package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // Login
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("rahul123");
        driver.findElement(By.className("signInBtn")).click();
        WebElement errorMessage = driver.findElement(By.cssSelector("p.error"));

        System.out.println(errorMessage.getText());
        // Click forgot password
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);

        // Forgot password
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("John@random.com");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("matteroftime@fly.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("12344532");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        // Go to login
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("John");
        driver.findElement(By.cssSelector("input[type*='pass'")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.cssSelector("input[name='chkboxTwo']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();


        // log out
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".logout-btn")).click();

        // driver.close();

    }
}
