package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.get("https://github.com");
        // driver.navigate().to("https://github.com");
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
    }
}
