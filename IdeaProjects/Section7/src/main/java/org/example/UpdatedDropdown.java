package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

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
