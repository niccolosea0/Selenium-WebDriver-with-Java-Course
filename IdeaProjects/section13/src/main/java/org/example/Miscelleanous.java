package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscelleanous {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // driver.manage().deleteCookie("cookie-name");
        // driver.manage().addCookie("cookie-name");

        driver.get("https://google.com");

        // Take Screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Place screenshot in your path
        FileUtils.copyFile(src, new File("C:\\Users\\name\\Pictures\\Screenshots\\screenshot.png"));
    }
}
