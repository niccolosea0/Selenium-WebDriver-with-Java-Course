package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> anchorLinks =  driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        try {

            for (WebElement element : anchorLinks) {
                String url = element.getAttribute("href");


                // Validation for links that are null, blank, or not actual links
                if (url == null || url.isBlank()) {
                    continue;
                }

                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    continue;
                }

                // Go to
                try {

                    HttpURLConnection conn =
                            (HttpURLConnection) new URI(url).toURL().openConnection();

                    conn.setRequestMethod("HEAD");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    conn.connect();

                    int responseCode = conn.getResponseCode();

                    if (responseCode >= 400) {
                        System.out.println("Invalid link: " + url + " | Status code: " + responseCode);
                    } else {
                        System.out.println("Valid link: " + url + " | Status code: " + responseCode);
                    }

                    conn.disconnect();
                } catch (IOException | URISyntaxException | IllegalArgumentException e) {
                    System.out.println("Could not verify link: " + url);
                    System.out.println("Reason: " + e.getMessage());
                }
            }
        } finally {
            driver.quit();
        }
    }
}
