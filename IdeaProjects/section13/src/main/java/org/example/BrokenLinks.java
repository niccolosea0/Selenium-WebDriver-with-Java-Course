package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

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

        SoftAssert softAssert = new SoftAssert();

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

                try {

                    // Make HTTP connection with URL
                    HttpURLConnection conn =
                            (HttpURLConnection) new URI(url).toURL().openConnection();

                    // Send Head Request (We do not need whole page, only status code)
                    conn.setRequestMethod("HEAD");

                    // Wait 5 seconds to connect with the server
                    conn.setConnectTimeout(5000);

                    // Wait 5 seconds for server response
                    conn.setReadTimeout(5000);

                    // Open Connection
                    conn.connect();

                    // Get response code
                    int responseCode = conn.getResponseCode();


                    // Using SoftAssert, to not stop execution right away, broken link is found
                    softAssert.assertTrue(
                            responseCode < 400,// if it fails
                            "Broken link found: " + url + " | Status code: " + responseCode // print that message
                    );

                    // A little bit more complex way
//                    if (responseCode >= 400) {
//                        softAssert.fail("Broken link found: " + url + " | Status code: " + responseCode);
//                    }

                        System.out.println("Checked link: " + url + " | Status code: " + responseCode);

                    // Close connection
                    conn.disconnect();

                } catch (IOException | URISyntaxException | IllegalArgumentException e) {
                    softAssert.fail("Could not verify link: " + url + " Reason: " + e.getMessage());
                }
            }

            softAssert.assertAll();

        } finally {
            driver.quit();
        }
    }
}
