package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SecondAssignment {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testAutoComplete() throws InterruptedException {

        String country = "United States (USA)";
        String threeChar = "Uni";

        // Get autoCompleteInput field and send keys
        WebElement autoCompleteInput = driver.findElement(By.id("autocomplete"));
        autoCompleteInput.sendKeys(threeChar);

        // Get list of AUto Suggestions
        List<WebElement> autoCompleteSuggestions = hoverOverAutoSuggestions();

        // Method that finds desired country, by pressing key down
        findDesiredCountry(autoCompleteSuggestions, autoCompleteInput, country);

        // Get input field value after auto-suggestion updates it
        String inputValue = autoCompleteInput.getAttribute("value");

        Assert.assertEquals(inputValue, country);
    }

    public List<WebElement> hoverOverAutoSuggestions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector("ul[id='ui-id-1'] li")
                )
        );
    }

    public void findDesiredCountry(List<WebElement> list, WebElement input, String country) {
        for (WebElement suggestion : list) {
            input.sendKeys(Keys.DOWN);
            if (suggestion.getText().equals(country)) {
                break;
            }
        }
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
