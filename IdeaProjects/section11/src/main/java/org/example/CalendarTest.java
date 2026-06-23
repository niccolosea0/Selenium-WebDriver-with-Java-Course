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
Add
        openYearSelection();
        selectDeliveryDate(year, monthNumber, date);
    }

    private void selectDeliveryDate(String year, String monthNumber, String date) {
        selectYear(year);
        selectMonth(monthNumber);
        selectDate(date);
    }

    private void selectDate(String date) {

        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();
    }

    private void selectMonth(String monthNumber) {

        List<WebElement> months = driver.findElements(By.cssSelector(".react-calendar__tile.react-calendar__year-view__months__month"));
        months.get(Integer.parseInt(monthNumber) - 1).click();
    }

    private void selectYear(String year) {

        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
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
