package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

// Questions for this assignment
// 1. Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked
// 2. How to get the Count of number of check boxes present in the page

public class Assigment {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Find and check first option
        WebElement option1 = driver.findElement(By.cssSelector("div[id='checkbox-example'] input[id='checkBoxOption1']"));
        option1.click();
        Assert.assertTrue(option1.isSelected());
        option1.click();
        Assert.assertFalse(option1.isSelected());

        // Get number of checkboxes
        List<WebElement> options = driver.findElements(By.cssSelector("div[id='checkbox-example'] input[type='checkbox']"));
        int optionsNumber = options.size();
        Assert.assertEquals(3, optionsNumber);


    }
}
