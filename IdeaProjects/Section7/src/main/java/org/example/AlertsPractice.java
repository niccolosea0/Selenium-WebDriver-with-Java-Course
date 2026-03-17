package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertsPractice {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String name = "John";
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert message: " + alert.getText());
        alert.accept();


        driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
        System.out.println("Second alert message: " + alert.getText());
        alert.dismiss();

    }
}
