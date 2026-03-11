package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(3);
        String selectUSD = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectUSD, "USD");

        dropdown.selectByValue("INR");
        String selectINR = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectINR, "INR");

        dropdown.selectByVisibleText("AED");
        String selectAED = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectAED, "AED");

    }
}
