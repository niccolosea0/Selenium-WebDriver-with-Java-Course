package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.Selector;
import java.time.Duration;
import java.util.List;

public class Exercise {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        List<WebElement> credentials = driver.findElements(
                By.cssSelector("p.text-center.text-white i")
        );

        // Get username and password from the page
        String username = credentials.get(0).getText();
        String password = credentials.get(1).getText();

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Enter username and password
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        //  Select User radio button
        driver.findElement(By.xpath("//label[2]/span[2]")).click();

        // Click OK on popup after selecting radio button
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-success"))).click();

        // Wait until modal of pop-up will be dissapeared
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myModal")));

        WebElement dropdownElement = driver.findElement(By.cssSelector("select.form-control"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("consult");

        // Click terms checkbox
        driver.findElement(By.id("terms")).click();

        // Click sign In
        driver.findElement(By.xpath("//input[@id='signInBtn']")).click();


        // Locate all the elements that have "Add to cart"
        List<WebElement> items = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector("button.btn.btn-info")
                )
        );

        // Add each item in cart, by clicking them;
        for (WebElement item : items) {
            item.click();
        }

        // Navigate to Checkout page
        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();


    }
}
