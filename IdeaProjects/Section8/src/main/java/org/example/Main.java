package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));

        String[] names = {"Cucumber", "Broccoli"};

        for (int i = 0; i < products.size(); i++) {
            String productName = products.get(i).getText();
            if (productName.contains(names[0])) {
                System.out.println(productName);
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }
    }
}