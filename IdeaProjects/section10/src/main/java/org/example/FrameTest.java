package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FrameTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable");
    }

    @Test
    public void handleFrames() {
        // WebElement frameElement = driver.findElement(By.cssSelector("iframe.demo-frame"));

        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        System.out.println("iframe count: " + iframeList.size());

        // Switch to frame
        // driver.switchTo().frame(frameElement);
        driver.switchTo().frame(iframeList.get(0));

        // Get WebElements of source and target objects
        WebElement sourceObjectToDrag = driver.findElement(By.id("draggable"));
        WebElement targetObjectToDrop = driver.findElement(By.id("droppable"));

        Actions a = new Actions(driver);
        a.dragAndDrop(sourceObjectToDrag, targetObjectToDrop).build().perform();

        // Verify text in dropped object
        String droppedText = targetObjectToDrop.getText();
        Assert.assertEquals("Dropped!", droppedText);

        // Switch back to default content
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }
}
