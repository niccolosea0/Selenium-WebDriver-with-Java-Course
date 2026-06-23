package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();

        // Proceed with insecure way
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://expired.badssl.com");
        System.out.println(driver.getTitle());
    }
}