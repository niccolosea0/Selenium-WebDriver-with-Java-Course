package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {

        // Invoking Browser
        // Firefox - FirefoxDriver -> Methods
        // Declaring WebDriver type to have access only to WebdRiver methods, not specific ones for browsers
        WebDriver driver = new ChromeDriver();

    }
}
