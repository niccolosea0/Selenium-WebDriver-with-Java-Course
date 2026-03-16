package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DynamicDropdown {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Click From cities list
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        // Select from city
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        // Select to city
        driver.findElement(By.xpath("//a[@value='MAA'] ")).click();

        // Select date
        driver.findElement(By.cssSelector("div[class*='group-first'] a[class*='ui-state-active']")).click();

        // Check, one-way flight radio button

        WebElement oneWay = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
        WebElement roundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
        roundTrip.click();
        System.out.println("Now round trip is selected ");
        WebElement returnDate = driver.findElement(By.id("Div1"));

        if (roundTrip.isSelected() && returnDate.getDomAttribute("style").contains("1")) {
            System.out.println("Return date is enabled");
            Assert.assertTrue(true);
        }

        // Select oneway
        oneWay.click();
        System.out.println("\nNow one way trip is selected ");
        if (returnDate.getDomAttribute("style").contains("0.5")) {
            System.out.println("Return date is disabled");
            Assert.assertFalse(false);
        }


    }
}
