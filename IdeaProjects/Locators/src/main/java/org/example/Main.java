package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("rahul123");

        driver.findElement(By.className("signInBtn")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("p.error"));
        System.out.println(errorMessage.getText());

        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("John@random.com");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("matteroftime@fly.com");


        // driver.close();

    }
}
