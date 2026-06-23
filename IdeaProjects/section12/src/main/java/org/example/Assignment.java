package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;

public class Assignment {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
    }


    @Test (priority = 1)
    public void testRowNumber() {

        WebElement table = getTableWebElement();
        List<WebElement> rowList = table.findElements(By.tagName("tr"));

        int rowCount = rowList.size();
        System.out.println("Row Count: " + rowCount);

    }

    @Test (priority = 2)
    public void testColumnNumber() {
        WebElement table = getTableWebElement();
        List<WebElement> columnList = table.findElements(By.cssSelector("tr:nth-child(1) th"));

        int columnCount = columnList.size();
        System.out.println("Column count: " + columnCount);

        // Print Empty line
        System.out.println();
    }

    @Test (priority = 3)
    public void printSecondRow() {
        WebElement table = getTableWebElement();
        List<WebElement> secondRowContent = table.findElements(By.cssSelector("tr:nth-child(3) td"));
        for (WebElement content : secondRowContent) {
            System.out.println(content.getText());
        }
    }

    private WebElement getTableWebElement() {
        return driver.findElement(By.cssSelector(".table-display"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
