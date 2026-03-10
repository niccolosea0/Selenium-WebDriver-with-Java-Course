package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locators2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("John");
        driver.findElement(By.cssSelector("input[type*='pass'")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.cssSelector("input[name='chkboxTwo']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();

    }
}
