package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameAssignment {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        // driver.manage().window().maximize();
    }

    @Test
    public void testNestedFrames() {

        navigateToNestedFrames();
        handleFrames();
    }

    public void handleFrames() {

        // Get frames list
        List<WebElement> framesList = getFrameList("Parent frame");

        WebElement topFrame = framesList.get(0);

        // Switch to topFrame
        driver.switchTo().frame(topFrame);

        // Get Nested frames list
        List<WebElement> nestedFramesList = getFrameList("Child frame");

        // Move to middle frame
        driver.switchTo().frame(nestedFramesList.get(1));

        // Get text from middle frame
        String middleFrameText = driver.findElement(By.id("content")).getText();
        System.out.println("Text: " + middleFrameText);
    }

    public List<WebElement> getFrameList(String frameName) {
        List<WebElement> framesList = driver.findElements(By.tagName("frame"));
        System.out.println(frameName + " size: " + framesList.size());
        return framesList;
    }

    public void navigateToNestedFrames() {
        WebElement frameLink = driver.findElement(By.cssSelector("a[href='/frames']"));
        frameLink.click();

        WebElement nestedFrames = driver.findElement(By.cssSelector("a[href='/nested_frames']"));
        nestedFrames.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
