package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.nio.channels.Selector;

// Please go through above video to understand the Assignment which need to be completed
// Questions for this assignment

public class Assignment2 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.cssSelector("input[class*='form-control'][name='name']")).sendKeys("Jullia");
        driver.findElement(By.cssSelector("input[class*='form-control'][name='email']")).sendKeys("Jullia2026@example.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("myPassword12%");
        driver.findElement(By.id("exampleCheck1")).click();

        // Select gender
        WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
        Select genderSelect = new Select(gender);
        genderSelect.selectByVisibleText("Female");

        // Select student
        driver.findElement(By.id("inlineRadio1")).click();

        driver.findElement(By.xpath("//input[@class='form-control'][@name='bday']")).sendKeys("2007-05-21");

        driver.findElement(By.cssSelector("input[value='Submit']")).click();

        String alertMessage = driver.findElement(By.cssSelector(".alert strong")).getText();
        Assert.assertEquals(alertMessage, "Success!");




    }
}
