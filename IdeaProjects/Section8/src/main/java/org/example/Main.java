package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beans"};

        List<String> itemsNeededList = Arrays.asList(itemsNeeded);
        for (int i = 0; i < products.size(); i++) {

            String[] splitedName = products.get(i).getText().split("-");
            String productName = splitedName[0].trim();


            int itemsFound = 0;

            if (itemsNeededList.contains(productName)) {
                System.out.println(productName);
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();


                itemsFound++;

                if (itemsFound == itemsNeededList.size()) {
                    break;
                }
            }
        }
    }
}