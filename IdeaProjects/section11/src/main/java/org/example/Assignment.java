package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assignment {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

   @Test
   public void checkOption() {

        WebElement optionCheckbox = driver.findElement(By.id("checkBoxOption3"));
        optionCheckbox.click();

        String optionText = getOptionName();
        System.out.println("Text: " + optionText);
   }

   @Test
   public void selectDropdownValue() {

        WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
        Select optionSelect = new Select(dropdownElement);

        String optionText = getOptionName();
        optionSelect.selectByVisibleText(optionText );
   }

   @Test
   public void fillInputBox() {

        String optionText = getOptionName();
        WebElement inputBox = driver.findElement(By.id("name"));
        inputBox.sendKeys(optionText);

        driver.findElement(By.id("alertbtn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

       String alertText = alert.getText();

       String[] alertTextArray = alertText.split(",")[0].split(" ");

       String alertOptionText = alertTextArray[1];
       Assert.assertEquals(alertOptionText, optionText);

   }

   private String getOptionName() {

       WebElement optionLabel = driver.findElement(By.cssSelector("label[for='honda']"));
        return optionLabel.getText();
   }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
