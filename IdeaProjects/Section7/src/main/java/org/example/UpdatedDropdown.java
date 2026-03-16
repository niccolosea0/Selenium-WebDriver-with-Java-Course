package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement srCitizenChecBox = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
        srCitizenChecBox.click();
        System.out.println(srCitizenChecBox.isSelected());

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("div[id='discount-checkbox'] input[type='checkbox']"));
        System.out.println("Number of checkboxes: " + checkBoxes.size());


        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click(); // 5 adult is selected after loop
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String passengersText = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(passengersText, "5 Adult");
    }
}
