package org.example;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class SSLCheck {
    public static void main(String[] args) {

        FirefoxOptions options = new FirefoxOptions();
        Proxy proxy = new Proxy();

        // Setup Proxy
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy", proxy);

        // Set download directory
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "/directory/path");

        // Proceed with insecure way
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://expired.badssl.com");
        System.out.println(driver.getTitle());
    }
}