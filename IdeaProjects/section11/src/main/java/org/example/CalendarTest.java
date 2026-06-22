package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CalendarTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    }

    @Test
    public void selectDate() {

        String monthNumber = "6";
        String date = "15";
        String year = "2027";

        // Call method to go to year selection
        openYearSelection();


        // Select year
        selectYear();
        selectMonth();
    }

    private void selectMonth() {

        WebElement monthSection = driver.findElement(By.cssSelector(".react-calendar__year-view__months"));
        driver.findElement(By.cssSelector("button:nth-child(6)")).click();

    }

    private void selectYear() {

        List<WebElement> yearElements = driver.findElements(By.cssSelector(".react-calendar__tile.react-calendar__decade-view__years__year"));

        for (WebElement element : yearElements) {
            if (element.getText().equals("2027")) {
                element.click();
                System.out.println("Done");
            }
        }
    }

    private void openYearSelection() {
        driver.findElement(By.cssSelector(".react-date-picker__calendar-button__icon.react-date-picker__button__icon")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
    }


    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
